package com.hsartori.challenges.interviewbit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeetingRoomsTests {
    
    @Test
    void case0() {
        final ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(List.of(0, 30)));
        input.add(new ArrayList<>(List.of(5, 10)));
        input.add(new ArrayList<>(List.of(15, 20)));
        assertEquals(2, new MeetingRooms().solve(input));
    }

    @Test
    void case1() {
        final ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(List.of(1, 18)));
        input.add(new ArrayList<>(List.of(18, 23)));
        input.add(new ArrayList<>(List.of(15, 29)));
        input.add(new ArrayList<>(List.of(15, 29)));
        input.add(new ArrayList<>(List.of(4, 15)));
        input.add(new ArrayList<>(List.of(2, 11)));
        input.add(new ArrayList<>(List.of(5, 13)));
        assertEquals(4, new MeetingRooms().solve(input));
    }

    @Test
    void case2() {
        final ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(List.of(18, 19)));
        input.add(new ArrayList<>(List.of(0, 1)));
        input.add(new ArrayList<>(List.of(7, 24)));
        input.add(new ArrayList<>(List.of(21, 26)));
        input.add(new ArrayList<>(List.of(9, 26)));
        input.add(new ArrayList<>(List.of(12, 18)));
        assertEquals(3, new MeetingRooms().solve(input));
    }

    @Test
    void case4() {
        final ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(List.of(7, 10)));
        input.add(new ArrayList<>(List.of(4, 19)));
        input.add(new ArrayList<>(List.of(19, 26)));
        input.add(new ArrayList<>(List.of(14, 16)));
        input.add(new ArrayList<>(List.of(13, 18)));
        input.add(new ArrayList<>(List.of(16, 21)));
        assertEquals(3, new MeetingRooms().solve(input));
    }

}
