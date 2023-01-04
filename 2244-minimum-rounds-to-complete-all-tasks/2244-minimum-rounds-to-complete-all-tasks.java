// 1 round -> 2/3 same level tasks
class Solution {
    public int minimumRounds(int[] tasks) {
        // Sort the tasks array in ascending order
        Arrays.sort(tasks);
        int result = 0, count = 0;
        // Iterate through each task
        for (int i = 0; i < tasks.length; i++) {
            // Increment the count of tasks with the same value
            count++;
            // If we have reached the last task or the current task is different from the next task
            if (i == tasks.length - 1 || tasks[i] != tasks[i + 1]) {
                // If there is only one task with this value, we cannot create groups of 3
                // and we return -1
                if (count == 1) {
                    return -1;
                }
                // Add the number of full groups of 3 we can create from the tasks with this value
                result += count / 3;
                // If there are remaining tasks that cannot be included in a group of 3,
                // we need one more round to process these tasks
                if(count % 3 != 0) result++;
                // Reset the count for the next set of tasks
                count = 0;
           }
        }
        // Return the total number of rounds needed
        return result;
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