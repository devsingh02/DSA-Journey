// 1 round -> 2/3 same level tasks
class Solution {
    public static int[] dp; 
    public int minimumRounds(int[] tasks) {
        dp = new int[tasks.length];
        Arrays.fill(dp,-1);
        Arrays.sort(tasks);
        int res = Integer.MAX_VALUE;
        res = minimumRoundsHelper(tasks,0,0);
        if(res ==Integer.MAX_VALUE){
            return -1;
        }
       return res;
    }
    
    private int minimumRoundsHelper(int[] tasks, int index, int total){
        if(index >= tasks.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        if(index+2 < tasks.length && tasks[index] == tasks[index+1] && tasks[index] == tasks[index+2])
           a  = minimumRoundsHelper(tasks,index+3,total+1);
        if(index+1 < tasks.length && tasks[index] == tasks[index+1]){
           b = minimumRoundsHelper(tasks,index+2,total+1);
        }
        int res = Math.min(a,b);
        if(res == Integer.MAX_VALUE){
            dp[index] = Integer.MAX_VALUE;
        }else{
            dp[index] = 1+ res;
        }
        return dp[index];
    }
}
// class Solution {
//     public int minimumRounds(int[] tasks) {
//         HashMap<Integer, Integer> hm = new HashMap<>();
//         for (int I : tasks) {
//             hm.put(I, hm.getOrDefault(I, 0) + 1);
//         }
//         int rnds = 0;
//         for (int ct : hm.values()) {
//             if (ct == 1) return -1;
            
//             if (ct%3==0) rnds += ct/3;
//             else if (ct%3==1) rnds += ct/3-1 + 2;
//             else rnds += ct/3 + 1;
//         }
//         return rnds;
//     }
// }
    
// HashMap    
// class Solution {
//     public int minimumRounds(int[] tasks) {
//         HashMap<Integer, Integer> hm = new HashMap<>(); // <task-level,its-count> 
//         for (int I : tasks) {
//             if (!hm.containsKey(I))
//                 hm.put(I, 1);
//             else {
//                 int v = hm.get(I);
//                 v++;
//                 hm.put(I, v);
//             } 
//         }
//         int tot_rounds = 0;
//         for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
//             int ct = e.getValue();
//             int r = Rounds(ct);
//             if (r==-1) return -1;
//             tot_rounds += r;
//         }
//         return tot_rounds;
//     }
//     public int Rounds(int n) {
//         if (n==1) return -1;
        
//         if (n%3==0) 
//             return n/3;
//         if (n%3==2)
//             return (int)n/3 + 1;
//         if (n%3==1)
//             return (int)n/3-1 + 2;
        
//         return 0;
//     }
// }