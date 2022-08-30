package Amazon.websiteVisitPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    /*
        map<username, List<visit>>
        map<3-sequence, JavaAPI.Set<username>>
        O(n * M^3)
    */

    static class Visit{
        private int timestamp;
        private String website;
        public Visit(int time, String web) {
            timestamp = time;
            website = web;
        }
    }

    private static Map<String, List<Visit>> getUserVisit(String[] username, int[] timestamp, String[] website) {
        // collect the website info for every user, key: username, value: (timestamp, website)
        Map<String, List<Visit>> userVisited = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            if (!userVisited.containsKey(username[i])) {
                userVisited.put(username[i], new ArrayList<>());
            }
            userVisited.get(username[i]).add(new Visit(timestamp[i], website[i]));
        }
        for (String tempUsername : userVisited.keySet()) {
            List<Visit> visits = userVisited.get(tempUsername);
            Collections.sort(visits, (visit1, visit2) -> (
                    visit1.timestamp - visit2.timestamp
            ));
        }
        return userVisited;
    }

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> userVisits = getUserVisit(username, timestamp, website);
        Map<String, Set<String>> sequenceUser = new HashMap<>();
        for (String tempUsername : userVisits.keySet()) {
            List<Visit> visits = userVisits.get(tempUsername);

            for (int i = 0; i < visits.size() - 2; i++) {
                for (int j = i + 1; j < visits.size() - 1; j++) {
                    for (int k = j + 1; k < visits.size(); k++) {
                        String sequence = visits.get(i).website + "->" + visits.get(j).website + "->"
                                + visits.get(k).website;
                        if (!sequenceUser.containsKey(sequence)) {
                            sequenceUser.put(sequence, new HashSet<>());
                        }
                        sequenceUser.get(sequence).add(tempUsername);
                    }
                }
            }
        }

        int maxFrequence = 0;
        String mostSequence = "";
        for (String sequence : sequenceUser.keySet()) {
            if (sequenceUser.get(sequence).size() == maxFrequence) {
                if (mostSequence.compareTo(sequence) > 0) {
                    mostSequence = sequence;
                }
            } else if (sequenceUser.get(sequence).size() > maxFrequence) {
                maxFrequence = sequenceUser.get(sequence).size();
                mostSequence = sequence;
            }
        }

        List<String> res = new ArrayList<>();
        for (String web : mostSequence.split("->")) {
            res.add(web);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] usernames = new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        int[] timestamps = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] websites = new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
        List<String> res = mostVisitedPattern(usernames, timestamps, websites);
        System.out.println(res);
    }
}
