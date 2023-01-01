// class Solution {
//     public boolean wordPattern(String pattern, String s) {
        
//         HashMap<String, Character> hm = new HashMap<>();
        
//         // Checking if pattern.length = no. of words
//         int ct = 0; s = s + " ";
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i)==' ') ct++;
//         }
//         if (ct != pattern.length()) return false;        
        
        
//         int start = 0, end;
//         for (int i = 0; i < pattern.length(); i++) {
            
//             // if (start >= s.length()) return false;
//             end = s.indexOf(' ', start);
//             String word = s.substring(start, end);
//             start = end + 1;
            
//             // if (i==pattern.length()-1 && start<s.length()) return false;
//             char ch = pattern.charAt(i);
            
//             if (hm.containsKey(word) && hm.get(word)==ch)
//                 continue;
//             if (!hm.containsKey(word) && !hm.containsValue(ch)) {
//                 hm.put(word, ch);
//                 continue;
//             }
//             return false;
//         }
//         return true;
//     }
// }
import java.util.StringTokenizer;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        StringTokenizer st = new StringTokenizer(s, " "); 
        
        HashMap<String, Character> hm = new HashMap<>();
        
        if (pattern.length() != st.countTokens()) return false;
        
        for (int i = 0; i < pattern.length(); i++) {
            String word = st.nextToken();
            char ch = pattern.charAt(i);
            
            if ((hm.containsKey(word) && !(hm.get(word)==ch)) || (!hm.containsKey(word) && hm.containsValue(ch)))
                return false;
            hm.put(word, ch);
        }
        return true;
    }
}