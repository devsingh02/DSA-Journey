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
