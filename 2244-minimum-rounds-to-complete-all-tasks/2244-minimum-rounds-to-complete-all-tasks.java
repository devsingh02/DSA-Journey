// 1 round -> 2/3 same level tasks

// HashMap 
// class Solution {
//     public int minimumRounds(int[] tasks) {
//         HashMap<Integer, Integer> hm = new HashMap<>();
//         for (int I : tasks) {
//             hm.put(I, hm.getOrDefault(I, 0) + 1);
//         }
//         int rnds = 0;
//         for (int ct : hm.values()) {
//             if (ct == 1) return -1;
            
//             // if (ct%3==0) rnds += ct/3;
//             // else if (ct%3==1) rnds += ct/3-1 + 2;
//             // else rnds += ct/3 + 1;
//             rnds += ct/3;
//             if(ct%3!=0) rnds++;
//         }
//         return rnds;
//     }
// }
    
// class Solution {
//     public int minimumRounds(int[] tasks) {
//         Arrays.sort(tasks);
//         int res = 0;
//         int i=0;
//         while(i<tasks.length) {
//             int j=i+1;
//             while(j<tasks.length && tasks[i] == tasks[j]) j++;
//             if(j-i==1) return -1;
//             res += (j-i)%3 == 0 ? (j-i)/3 : (j-i)/3 + 1;
//             i = j;
//         }
//         return res;
//     }
// } 
class Solution {
    public int minimumRounds(int[] tasks) {
        // Put the task numbers and their counts
        HashMap<Integer, Integer> taskMap = new HashMap<>();
        for(int task: tasks){
            taskMap.put(task, taskMap.getOrDefault(task, 0)+1);
        }
        
        // Count the number of rounds
        int rounds = 0;
        for(int key:taskMap.keySet()){            
            // Check if only 1 task at a time is possible
            int count = taskMap.get(key);
            if(count == 1){
                return -1;
            }
            
            // Round counter for this specific task number
            int roundTmp = 0;
            roundTmp = (int) count / 3;
            int remainder = count % 3;
            
            // Switch statement can obviously be simplified
            switch(remainder){
                // No remainder, perfect division by 3
                case 0:
                    rounds += roundTmp;
                    break;
                // Remainder of 1, too many 3s. Lose 1 three tasks and add 2 two tasks
                case 1:
                    rounds += roundTmp + 1;
                    break;
                // Remainder of 2, not enough, add 1 two tasks.
                case 2:
                    rounds += roundTmp + 1;
                    break;                    
            }
        }
        return rounds;
    }
}
