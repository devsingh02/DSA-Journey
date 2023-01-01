class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] arr = s.split(" ");
        if(pattern.length()!=arr.length)return false;
        HashMap<Character,String> map = new HashMap<>(); 
        for(int i = 0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            boolean containsKey = map.containsKey(ch);
            if(map.containsValue(arr[i]) && !containsKey)return false;
            if(containsKey && !map.get(ch).equals(arr[i]))return false;
            else map.put(ch,arr[i]);
        }
        return true;
    }
}


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