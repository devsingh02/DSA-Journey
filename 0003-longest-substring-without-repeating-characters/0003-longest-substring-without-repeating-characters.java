import java.util.Arrays;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();


        final byte[] countTemplate = new byte[]{
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
                -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
        };


        final byte[] strBytes = s.getBytes();
        int endPos = 0, startPos = 0, max = 1;

        countTemplate[strBytes[0]-32]=1;
        int size=1;

        for(endPos = 1; endPos<s.length(); endPos++){
            while(countTemplate[strBytes[endPos]-32]==1){
                countTemplate[strBytes[startPos]-32]=-1;
                size--;
                startPos++;
            }

            countTemplate[strBytes[endPos]-32]=1;
            size++;
            max = Math.max(max, size);
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