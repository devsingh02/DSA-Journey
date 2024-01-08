class Solution {
    static HashMap<String, Boolean> mp = new HashMap<String, Boolean>();
   
    static boolean isScramble(String S1, String S2)
    {
        
        // Strings of non-equal length
        // cant' be scramble strings
        if (S1.length() != S2.length()) {
            return false;
        }
   
        int n = S1.length();
   
        // Empty strings are scramble strings
        if (n == 0) {
            return true;
        }
   
        // Equal strings are scramble strings
        if (S1.equals(S2)) {
            return true;
        }
        // Check for the condition of anagram
        String copy_S1 = S1, copy_S2 = S2;
        char[] t1 = copy_S1.toCharArray();
        char[] t2 = copy_S2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        copy_S1 = new String(t1);
        copy_S2 = new String(t2);
   
        if (!copy_S1.equals(copy_S2)) {
            return false;
        }
   
        // make key of type string for search in map
        String key = (S1 + " " + S2);
        // checking if both string are before calculated or not
        // if calculated means find in map then return it's
        // value
        if (mp.containsKey(key)) {
            return mp.get(key);
        }
   
        // declaring flag variable to store result
        boolean flag = false;
   
        for (int i = 1; i < n; i++) {
   
            // Check if S2[0...i] is a scrambled
            // string of S1[0...i] and if S2[i+1...n]
            // is a scrambled string of S1[i+1...n]
            if (isScramble(S1.substring(0, i), S2.substring(0, i))
                && isScramble(S1.substring(i, n), S2.substring(i, n))) {
                flag = true;
                 mp.put(key, flag);//store for future use
                return true;
            }
   
            // Check if S2[0...i] is a scrambled
            // string of S1[n-i...n] and S2[i+1...n]
            // is a scramble string of S1[0...n-i-1]
            if (isScramble(S1.substring(0, i), S2.substring(n - i, n))
                && isScramble(S1.substring(i, n),
                              S2.substring(0, n - i))) {
                flag = true;
                  mp.put(key, flag); //store for future use
                return true;
            }
        }
   
        // add key & flag value to map (store for future use)
        // so next time no required to calculate it again
        mp.put(key, flag);
   
        // If none of the above conditions are satisfied
        return false;
    }
}