class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        //USA
        int i;
        for (i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch))
                break;
        }
        if (i == n) return true;
        
        //leetcode
        for (i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch))
                break;
        }
        if (i == n) return true;
        
        //Google
        for (i = 1; i < n; i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch))
                break;
        }
        if (i == n && Character.isUpperCase(word.charAt(0))) return true;
        
        return false;
    }
}