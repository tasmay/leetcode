/*
* https://leetcode.com/problems/sort-characters-by-frequency/
* */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortByFrequency {
    public static String frequencySort(String s) {
        String result = "";
        // build character frequency map
        Map<Character, int[]> freq = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!freq.containsKey(c))
                freq.put(c, new int[]{1,i});
            else {
                int[] temp = freq.get(c);
                temp[0]++;
                freq.put(c, temp);
            }
        }

        PriorityQueue<Character> heap = new PriorityQueue<Character>(new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                if (freq.get(b)[0] == freq.get(a)[0])
                    return freq.get(b)[1] - freq.get(a)[1];
                else
                    return freq.get(b)[0] - freq.get(a)[0];
            }
        });

        // add into heap times it's frequency
        for (Character ch: freq.keySet()) {
            int multiplier = freq.get(ch)[0];
            for(int i=0; i < multiplier; i++) {
                heap.add(ch);
            }
        }
        // create output string
        while (!heap.isEmpty()) {
            Character ch = heap.poll();
            result = result.concat(ch.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb2222"));
    }
}
