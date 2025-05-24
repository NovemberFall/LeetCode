package _JavaCore_interview.Problem_Solve.TopArticles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 [Ford] In this challenge, the REST API contains information about a collection of articles.
 Given a limit value, the goal is to return articles ordered by the number of comments they have and
 limited to the first ones in that order by the given limit value.
 To access the collection of users perform HTTP Get request to:
 https://jsonmock.hackerrank.com/api/articles?page=<pageNumber>
 Where <pageNumber> is an integer denoting the page of the results to render.
 For example, GET requests to https://jsonmock.hackerrank.com/api/articles?page=2
 return the second page of the collection of articles.
 Pages are numbered from 1, so in order to access the first page, you need to ask for page number 1.

 The response to such request is a JSON with the following 5 fields:
 page: The current page of the results
 per_page: The maximum number of records returned per page
 total: The total number of records on all pages of the result
 total_pages: The total number of pages with results
 data: An array of objects containing records returned on the requested

 */
public class ArticleService_fasterxml {

    public static List<String> TopArticles(int limit) {
        List<String> topArticles = new ArrayList<>();

        int pageNumber = 1;
        while (true) {
            String apiUrl = "https://jsonmock.hackerrank.com/api/articles?page=" + pageNumber;
            // Perform HTTP GET request to apiUrl and parse JSON response
            List<Article> articles = getArticlesFromApi(apiUrl);

            if (articles.isEmpty()) {
                break; // No more articles to fetch
            }

            // Filter and sort articles based on comments
            List<Article> filteredArticles = filterAndSortArticles(articles);

            // Add article names to the result list
            for (Article article : filteredArticles) {
                topArticles.add(article.getName());
                if (topArticles.size() == limit) {
                    return topArticles;
                }
            }

            pageNumber++;
        }

        return topArticles;
    }

    private static List<Article> getArticlesFromApi(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(connection.getInputStream());
                StringBuilder response = new StringBuilder();
                while (scanner.hasNextLine()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();

                // Assume the existence of a method like JsonParser.parseArticles(response)
                // that parses the JSON response and returns a list of Article objects.
                return JsonParser.parseArticles(response.toString());
            } else {
                System.out.println("HTTP GET request failed with response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(); // Return an empty list in case of failure
    }

    private static List<Article> filterAndSortArticles(List<Article> articles) {
        // Implement the logic to filter out articles with empty titles,
        // sort the remaining articles based on comments and then alphabetically,
        // and return the sorted list

        List<Article> filteredArticles = new ArrayList<>();
        for (Article article : articles) {
            if (!article.getName().isEmpty() || !article.getStoryTitle().isEmpty()) {
                filteredArticles.add(article);
            }
        }

        Collections.sort(filteredArticles, (a1, a2) -> {
            if (a1.getComments() != a2.getComments()) {
                return Integer.compare(a2.getComments(), a1.getComments()); // Sort by comments in descending order
            } else {
                return a1.getName().compareTo(a2.getName()); // Sort alphabetically by name
            }
        });

        return filteredArticles;
    }

    private static class Article {
        private String name;
        private String storyTitle;
        private int comments;

        public Article(String name, String storyTitle, int comments) {
            this.name = name;
            this.storyTitle = storyTitle;
            this.comments = comments;
        }

        public String getName() {
            return name;
        }

        public String getStoryTitle() {
            return storyTitle;
        }

        public int getComments() {
            return comments;
        }

        // Add setters if needed
    }

    private static class JsonParser {
        // Assume the existence of a method like JsonParser.parseArticles(response)
        // that parses the JSON response and returns a list of Article objects.
        public static List<Article> parseArticles(String jsonResponse) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Article> articles = new ArrayList<>();

            try {
                JsonNode root = objectMapper.readTree(jsonResponse);
                JsonNode dataNode = root.get("data");

                for (JsonNode articleNode : dataNode) {
                    String name = articleNode.get("title").asText();
                    String storyTitle = articleNode.get("story_title").asText();
                    int comments = articleNode.get("num_comments").asInt();

                    articles.add(new Article(name, storyTitle, comments));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return articles;
        }
    }

    public static void main(String[] args) {
        int limit = 5; // Set the desired limit

        List<String> topArticles = ArticleService_fasterxml.TopArticles(limit);

        System.out.println("Top " + limit + " Articles:");
        for (int i = 0; i < topArticles.size(); i++) {
            System.out.println((i + 1) + ". " + topArticles.get(i));
        }
    }
}

