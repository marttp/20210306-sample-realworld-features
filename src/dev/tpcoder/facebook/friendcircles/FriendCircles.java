package dev.tpcoder.facebook.friendcircles;

import java.util.Arrays;

public class FriendCircles {

  public static void main(String[] args) {
    int n = 4;
    boolean[][] friends = {
        {true, true, false, false}, // 1
        {true, true, true, false}, // 2
        {false, true, true, false}, // 3
        {false, false, false, true} // 4
    };
    System.out.println("Number of friends circles: " + friendCircles(friends, n));
  }

  public static int friendCircles(boolean[][] friends, int n) {
    if (n == 0) {
      return 0;
    }

    int numCircles = 0;     //Number of friend circles

    //Keep track of whether a user is already in a friend circle
    boolean[] visited = new boolean[n];
    Arrays.fill(visited, false);

    // Start with the first user and recursively find all other users in his/her
    // friend circle. Then, do the same thing for the next user that is not already
    // in a friend circle. Repeat until all users are in a friend circle.
    for (int i = 0; i < n; ++i) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(friends, n, visited, i); // Recursive step to find all friends
        numCircles++;
      }
    }

    return numCircles;
  }

  public static void dfs(boolean[][] friends, int n, boolean[] visited, int v) {
    for (int i = 0; i < n; ++i) {
      // A user is in the friend circle if he/she is friends with the user represented by
      // user index and if he/she is not already in a friend circle
      if (friends[v][i] && !visited[i] && i != v) {
        visited[i] = true;
        dfs(friends, n, visited, i);
      }
    }
  }



}
