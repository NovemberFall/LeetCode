package _JavaCore_interview.Problem_Solve.TopArticles;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArticleService_GSON {

    public static List<String> TopArticles(int limit) {
        List<String> topArticles = new ArrayList<>();

        try {
            int page = 1;

            while (true) {
                String apiUrl = "https://jsonmock.hackerrank.com/api/articles?page=" + page;
                HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();

                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();

                int totalPages = jsonResponse.get("total_pages").getAsInt();
                JsonArray data = jsonResponse.getAsJsonArray("data");

                for (JsonElement article : data) {
                    JsonObject articleObject = article.getAsJsonObject();

                    String title = articleObject.has("title") ? articleObject.get("title").getAsString() : null;
                    String storyTitle = articleObject.has("story_title") ? articleObject.get("story_title").getAsString() : null;

                    if (title != null || storyTitle != null) {
                        String articleName = (title != null) ? title : storyTitle;
                        topArticles.add(articleName);
                    }
                }

                if (page >= totalPages) {
                    break;
                }

                page++;
            }

            // Sort articles by the number of comments and then by name
            Collections.sort(topArticles, Comparator.comparingInt(ArticleService_GSON::getCommentCount)
                    .reversed().thenComparing(Comparator.naturalOrder()));

            // Limit the result to the specified number
            if (limit < topArticles.size()) {
                topArticles = topArticles.subList(0, limit);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return topArticles;
    }

    private static int getCommentCount(String articleName) {
        try {
            String apiUrl = "https://jsonmock.hackerrank.com/api/articles?title=" + articleName;
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();

            JsonArray data = jsonResponse.getAsJsonArray("data");

            if (data.size() > 0) {
                return data.get(0).getAsJsonObject().get("num_comments").getAsInt();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public static void main(String[] args) {
        int limit = 2;
        List<String> result = TopArticles(limit);

        // Print the result
        for (String article : result) {
            System.out.println(article);
        }
    }
}

