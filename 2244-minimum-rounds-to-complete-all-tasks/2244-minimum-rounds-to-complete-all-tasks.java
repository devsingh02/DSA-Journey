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
    
class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int res = 0;
        int i=0;
        while(i<tasks.length) {
            int j=i+1;
            while(j<tasks.length && tasks[i] == tasks[j]) j++;
            if(j-i==1) return -1;
            res += (j-i)%3 == 0 ? (j-i)/3 : (j-i)/3 + 1;
            i = j;
        }
        return res;
    }
}   
