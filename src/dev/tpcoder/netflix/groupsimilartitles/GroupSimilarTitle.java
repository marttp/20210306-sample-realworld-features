package dev.tpcoder.netflix.groupsimilartitles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupSimilarTitle {

  public static void main(String[] args) {
    // Driver code
    String[] titleList = {"duel", "dule", "speed", "spede", "deul", "cars"};
    List<Set<String>> gt = groupTitles(titleList);
    String query = "spede";
    // Searching for all titles
    for (Set<String> g : gt) {
      if (g.contains(query)) {
        // return set of title
        System.out.println(g);
      }
    }
  }

  private static List<Set<String>> groupTitles(String[] titleList) {
    if (titleList.length == 0) {
      return new ArrayList<>();
    }

    Map<String, Set<String>> groups = new HashMap<>();
    for (String title : titleList) {

      int[] charCount = new int[26];
      for (char c : title.toCharArray()) {
        charCount[c - 'a']++;
      }

      StringBuilder sb = new StringBuilder();
      Arrays.stream(charCount).forEach(num -> {
        sb.append("#");
        sb.append(num);
      });

      String key = sb.toString();
      if (!groups.containsKey(key)) {
        groups.put(key, new HashSet<>());
      }

      groups.get(key).add(title);
    }
    return new ArrayList<>(groups.values());
  }

}
