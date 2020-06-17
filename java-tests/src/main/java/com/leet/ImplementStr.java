package com.leet;

public class ImplementStr {
    // Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of
    // haystack.
    // What should we return when needle is an empty string? This is a great question to ask during an
    // interview.
    // For the purpose of this problem, we will return 0 when needle is an empty string

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return 0;

        if (needle.length() == 0)
            return 0;

        int needlength = needle.length();
        for (int i = 0; i + needlength <= haystack.length(); i++) {
            String sub = haystack.substring(i, i + needlength);
            System.out.println(sub);
            System.out.println(needle);
            if (sub.equals(needle))
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
//    String haystack = "hello";
//    String needle = "ll";

//    String haystack = "a";
//    String needle = "a";

        String haystack = "ababcaababcaabc";
        String needle = "ababcaabc";

        ImplementStr iss = new ImplementStr();
        int res = iss.strStr(haystack, needle);
        System.out.println(res);
    }
}
