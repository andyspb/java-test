package com.leet.may;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
//  Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function
//  that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
//  Each letter in the magazine string can only be used once in your ransom note.

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), (map.getOrDefault(magazine.charAt(i), 0) + 1));
        }

        for (int i = 0; i < ransomNote.length(); i++) {

            if (map.containsKey(ransomNote.charAt(i))) {
                if (map.get(ransomNote.charAt(i)) <= 0)
                    return false;
            }
            else {
                return false;
            }

            map.put(ransomNote.charAt(i), (map.get(ransomNote.charAt(i)) - 1));
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        System.out.println(rn.canConstruct("aa", "aab"));

    }
}
