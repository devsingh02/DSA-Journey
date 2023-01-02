class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maximum_length = 0;
 
    
    int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
       for(int i=0; i<s.length(); i++){
          
          if(map.containsKey(s.charAt(i)))
      {
         start = Math.max(start, map.get(s.charAt(i)) + 1);
      }
 
      
      map.put(s.charAt(i), i);
      maximum_length = Math.max(maximum_length, i-start + 1);
    }
    return maximum_length;
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