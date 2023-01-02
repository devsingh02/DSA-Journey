class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input string is null");
        }

        int len = s.length();
        if (len <= 1) {
            return len;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < len; end++) {
            char eChar = s.charAt(end);
            if (map.containsKey(eChar)) {
                start = Math.max(start, map.get(eChar) + 1);
            }
            map.put(eChar, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
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