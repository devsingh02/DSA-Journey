class Solution {    //O(m)
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char st : stones.toCharArray()) {
            if (jewels.indexOf(st) != -1) 
                count++;
        }
        return count;
    }
}

// USING HASHSET    O(n+m)
// class Solution {
//     public int numJewelsInStones(String jewels, String stones) {
//         HashSet<Character> J = new HashSet<>();
//         for (char ch : jewels.toCharArray()) 
//             J.add(ch); //input
//         int count = 0;
//         for (char ch : stones.toCharArray()) 
//             if (J.contains(ch)) count++;
//         return count;
//     }
// }


// USING HASHMAP
// class Solution {
//     public int numJewelsInStones(String jewels, String stones) {
//         HashMap<Character, Integer> J = new HashMap<>();    //only K imp.
//         for (int i = 0; i < jewels.length(); i++) J.put(jewels.charAt(i), 0); //input
//         int ans = 0;
//         for (int i = 0; i < stones.length(); i++) {
//             char ch = stones.charAt(i);
//             if (J.containsKey(ch)) ans++;
//         }
//         return ans;
//     }
// }