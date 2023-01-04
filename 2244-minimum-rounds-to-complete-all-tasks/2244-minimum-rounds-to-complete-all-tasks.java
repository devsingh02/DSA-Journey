// 1 round -> 2/3 same level tasks
class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> hm = new HashMap<>(); // <task-level,its-count> 
        for (int I : tasks) {
            if (!hm.containsKey(I))
                hm.put(I, 1);
            else {
                int v = hm.get(I);
                v++;
                hm.put(I, v);
            } 
                
        }
        // should be divisible by 2||3||5
        int tot_rounds = 0;
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            int ct = e.getValue();
            int r = Rounds(ct);
            if (r==-1) return -1;
            tot_rounds += r;
        }
        return tot_rounds;
    }
    public int Rounds(int n) {
        if (n==1) return -1;
        
        if (n%3==0) 
            return n/3;
        if (n%3==2)
            return (int)n/3 + 1;
        if (n%3==1)
            return (int)n/3-1 + 2;
        return 0;
    }
}