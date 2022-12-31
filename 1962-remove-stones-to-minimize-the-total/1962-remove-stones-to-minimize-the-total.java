// piles[] -> no. of stones in ith pile


class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
         
        int sum = 0;
        for (int I : piles) {       //n
            pq.offer(I);    //logn
            sum += I;   // maintain sum from start to avoid addtional O(nlogn) in end
        }
        
        while (k > 0) {
            int max = pq.poll(); //removed the element
            int new_element = max - (int)max/2 ;
            sum -= (int)max/2;
            pq.offer(new_element);
            k--;
        }
        return sum;
    }
}


// BRUTE FORCE 1 : Time Limit Exceeded  O(k*n)
// class Solution {
//     public int minStoneSum(int[] piles, int k) {
//         if (k == 0) {
//             int sum = 0;
//             for (int I : piles) sum += I;
//             return sum;
//         }
//         int max_ind = 0;
//         for (int i = 0; i < piles.length; i++) {
//             if (piles[i] > piles[max_ind]) max_ind = i;
//         }
//         piles[max_ind] -= (int)(piles[max_ind]/2);
//         return minStoneSum(piles, --k);
//     }
// }

// BRUTE FORCE 2 : Time Limit Exceeded  O(k*nlogn)
// class Solution {
//     public int minStoneSum(int[] piles, int k) {
//         if (k == 0) {
//             int sum = 0;
//             for (int I : piles) sum += I;
//             return sum;
//         }
//         Arrays.sort(piles);
//         int n = piles.length;
//         piles[n-1] -= (int)(piles[n-1]/2);
//         return minStoneSum(piles, --k);
//     }
// }

// ALTERNATE Q. (RANDOM ELEMENT)
// class Solution {
//     public int minStoneSum(int[] piles, int k) {
//         if (k == 0) {
//             int sum = 0;
//             for (int I : piles) sum += I;
//             return sum;
//         }
//         int rand = ThreadLocalRandom.current().nextInt(0, piles.length);
//         piles[rand] -= (int)(piles[rand]/2);
//         return minStoneSum(piles, --k);
//     }
// }