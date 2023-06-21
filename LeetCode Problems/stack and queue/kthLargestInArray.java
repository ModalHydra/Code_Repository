class Solution {
    public int findKthLargest(int[] nums, int k) {
        // keep a priority queue of lenght k
        // add the first k elements to the queue
        // then if new element is greater than queue min
        // remove min and add new element


        // there are more efficient ways to do this like adding
        // all the elements to a max heap and removing k - 1 elements
        int len = nums.length;
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(k, (a,b) -> b.compareTo(a));

        for(int i = 0; i < len; i++){
            pQueue.add(nums[i]);
        }
        
        for(int i = 0; i < k-1; i++){
            pQueue.remove();
        }

        return pQueue.poll();
    }
}