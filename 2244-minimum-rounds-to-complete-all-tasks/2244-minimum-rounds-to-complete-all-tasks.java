// 1 round -> 2/3 same level tasks
class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int ans =0;
        int index =0;
        for(int i=0;i<tasks.length;i++){
            int ab =count(tasks,tasks[i],index);
            index+=ab;
            if(ab<2){  return -1; }
            i+=(ab-1);
            int b =ab;
            if(ab==2){  ans+=1;   }
            else if(ab%3==0){
                while (true){
                    if(ab==0||ab==1){  break;  }
                    ab/=3;
                    ans+=ab;
                    ab%=3;
                }
            }
            else{
                while (true){
                    ab/=3;
                    int added =ab;
                    ans+=ab;
                    ab =b;
                    ab%=3;
                    if(ab==1||ab==2){
                        ans--;
                        ans+=2;
                        break;
                    }} 
                    }}
        if(ans==0){  return -1;  }
        return ans;
    }
    public static int count(int []tasks,int val,int j){
        int count =0;
        for(int i =j;i<tasks.length;i++){
            if(tasks[i]==val){  count++;  }
            if(tasks[i]!=val){ break;  }
        }
        return count;
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