class Solution {
    public int findMinArrowShots(int[][] points) {
        // result will store the minimum number of arrows needed to burst all the balloons
        int result = 0;

        // PriorityQueue to sort the balloon ranges in ascending order of their end points
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> a[1]-b[1]);

        // add all the balloon ranges to the PriorityQueue
        for (int []point : points) priorityQueue.add(point);

        // if there are no balloons, return 0
        if (priorityQueue.isEmpty()) return 0;

        // while there are balloons in the PriorityQueue, process each balloon range
        while (!priorityQueue.isEmpty()) {
            // get the current balloon range
            int [] prev = priorityQueue.poll();

            // check if any subsequent balloon ranges start before or at the same time as the end of the current range
            // if a subsequent range does, remove it from the PriorityQueue because it will also be burst when the current range is burst
            while (!priorityQueue.isEmpty() && prev[1]>=priorityQueue.peek()[0] && prev[1]<=priorityQueue.peek()[1]) {
                priorityQueue.poll();
            }

            // increment the result counter by 1 for each balloon range processed, since each range requires one arrow to burst it
            result++;
        }

        // return the minimum number of arrows needed to burst all the balloons
        return result;
    }
}