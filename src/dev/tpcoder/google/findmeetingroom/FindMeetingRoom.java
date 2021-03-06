package dev.tpcoder.google.findmeetingroom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMeetingRoom {

  public static void main( String[] args) {
    // Driver code
    int[][] meetingTimes = {
        {2, 8},
        {3, 4},
        {3, 9},
        {5, 11},
        {8, 20},
        {11, 15}
    };
    // Find min quantity of meeting rooms
    System.out.print(minMeetingRooms(meetingTimes));
  }

  public static int minMeetingRooms(int[][] meetingTimes){

    if(meetingTimes.length == 0){
      return 0;
    }
    // Sort by starting time first
    Arrays.sort(meetingTimes, Comparator.comparingInt(a -> a[0]));

    // Min Heap keeps track of earliest ending meeting:
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    // Add first meeting
    minHeap.add(meetingTimes[0][1]);

    for (int i = 1; i < meetingTimes.length; i++) {
      int currStart = meetingTimes[i][0];
      int currEnding = meetingTimes[i][1];
      int earliestEnding = minHeap.peek();

      // If first room are end. can start next session
      if (earliestEnding <= currStart) {
        minHeap.remove();
      }
      // update heap with curr ending
      minHeap.add(currEnding);
    }

    return minHeap.size();
  }


}
