class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        int maxLen = 0;
        
        // [1] longest substring is the one with the largest 
        //    difference between positions of repeated characters; 
        //    thus, we should create a storage for such positions 
        int[] pos = new int[128];

        // [2] while iterating through the string (i.e., moving 
        //    the end of the sliding window), we should also 
        //    update the start of the window 
        int start = 0, end = 0;

        for (char ch : s.toCharArray())
        {
            // [3] get the position for the start of sliding window 
            //    with no other occurences of 'ch' in it 
            start  = Math.max(start, pos[ch]);

            // [4] update maximum length 
            maxLen = Math.max(maxLen, end-start+1);

            // [5] set the position to be used in [3] on next iterations
            pos[ch] = end + 1;
            
            end++;
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