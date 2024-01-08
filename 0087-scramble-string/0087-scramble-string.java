class Solution {
    public static boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<String, Boolean> memo = new HashMap<>();
        return isScrambleHelper(s1, s2, memo);
    }

    private static boolean isScrambleHelper(String s1, String s2, Map<String, Boolean> memo) {
        String key = s1 + "_" + s2;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int length = s1.length();

        if (length == 1) {
            return s1.equals(s2);
        }

        // // Check if the two strings are anagrams
        // if (!isAnagram(s1, s2)) {
        //     memo.put(key, false);
        //     return false;
        // }

        for (int i = 1; i < length; i++) {
            // Check if the strings are scrambled for the current split
            if ((isScrambleHelper(s1.substring(0, i), s2.substring(0, i), memo)
                    && isScrambleHelper(s1.substring(i), s2.substring(i), memo))
                    || (isScrambleHelper(s1.substring(0, i), s2.substring(length - i), memo)
                    && isScrambleHelper(s1.substring(i), s2.substring(0, length - i), memo))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

//     private static boolean isAnagram(String s1, String s2) {
//         int[] count = new int[26];

//         for (char c : s1.toCharArray()) {
//             count[c - 'a']++;
//         }

//         for (char c : s2.toCharArray()) {
//             count[c - 'a']--;
//         }

//         for (int value : count) {
//             if (value != 0) {
//                 return false;
//             }
//         }

//         return true;
//     }
}