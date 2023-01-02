class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(map.size() == j - i + 1){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else if(map.size() < j - i + 1){
                while(map.size() < j - i + 1){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}

// O(n*n)
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         HashSet<Character> hs = new HashSet<>();
//         String max = "";
//         for (int i = 0; i < s.length(); i++) {
//             String str = "";
//             for (int j = i; j < s.length(); j++) {
//                 char ch = s.charAt(j);
//                 if (hs.contains(ch)) {
//                     if (str.length() > max.length())
//                         max = str;
//                     break;
//                 }
//                 else if (j+1 == s.length()) {
//                     str = str + ch;
//                     if (str.length() > max.length())
//                         max = str;
//                     hs.add(ch);
//                 }
//                 else {
//                     str = str + ch;
//                     hs.add(ch);
//                 }
//             }
//             hs.clear();
//         }
//         return max.length();
//     }
// }


// WITH SAKSHAM
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         String Max="";
//         for(int i=0;i<s.length()-1;i++) {
//               for(int j=i+1;j<s.length();j++) {
//                   String str=s.substring(i,j+1);
//                   int f=-1;
//                   for(int k=0;k<str.length()-1;k++){
//                       for(int l=k+1;l<str.length();l++){
//                           if(str.charAt(k)==str.charAt(l)){
//                               f++;
//                               break;
//                           }
//                       }
//                       break;
//                   }
//                   if(f==-1){
//                       if(str.length()>=Max.length()){
//                           Max=str;
//                       }
//                   }
                  
//               }
//         }
//         return Max.length();
//     }
// }