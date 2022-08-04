package com.hsartori.challenges.interviewbit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

    public int solve(ArrayList<ArrayList<Integer>> meetings) {

        // Create queue
        final PriorityQueue<Integer> rooms = new PriorityQueue<>();
        final PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));
        queue.addAll(meetings);

        // Check elements
        rooms.add(queue.poll().get(1));
        int maxRooms = 1;
        while (!queue.isEmpty()) {

            // Find next meeting to check
            final ArrayList<Integer> curr = queue.poll();

            // Release room if it's already available
            if (rooms.peek() <= curr.get(0)) {
                rooms.poll();
            }

            // Allocate a new room or same room is released in previous step
            rooms.add(curr.get(1));

            // Prepare next iteration
            maxRooms = Math.max(maxRooms, rooms.size());

        }

        return maxRooms;
    }

}
