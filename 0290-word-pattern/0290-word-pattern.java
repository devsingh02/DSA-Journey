class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        HashMap<String, Character> hm = new HashMap<>();
        
        int ct = 0; s = s + " ";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' ') ct++;
        }
        if (ct != pattern.length()) return false;        
        
        
        int pos = 0, end; 
        
        for (int i = 0; i < pattern.length(); i++) {
            
            end = s.indexOf(' ', pos);
            String word = s.substring(pos, end);
            pos = end + 1;
            
            char ch = pattern.charAt(i);
            
            if (hm.containsKey(word) && hm.get(word)==ch)
                continue;
            if (!hm.containsKey(word) && !hm.containsValue(ch)) {
                hm.put(word, ch);
                continue;
            }
            return false;
        }
        return true;
    }
}


// class Solution {
//     public boolean wordPattern(String pattern, String s) {
        
//         StringTokenizer st = new StringTokenizer(s, " "); 
        
//         HashMap<String, Character> hm = new HashMap<>();
        
//         for (int i = 0; i < pattern.length(); i++) {
//             String word = st.nextToken();
//             char ch = pattern.charAt(i);
//             if (hm.containsKey(word)) {
//                 if (hm.get(word) != ch) {
//                     return false;
//                 }
//             }   // bahar tab hi ayega jab ch equal hoga value ke
//             hm.put(word, ch);
//         }
//         return true;
//     }
// }