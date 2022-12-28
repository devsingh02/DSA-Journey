class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        HashSet<Character> J = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) J.add(jewels.charAt(i)); //input
        int ans = 0;
        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if (J.contains(ch)) ans++;
        }
        return ans;
    }
}