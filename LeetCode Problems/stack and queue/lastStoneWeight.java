class Solution {
    public int lastStoneWeight(int[] stones) {
        
        int len = stones.length;
        int rock1 = stones[0];
        int rock2;
        boolean empty = false;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < len; i++){
            queue.add(stones[i]);
        }


        while(!empty){
            rock1 = queue.poll();
            if(queue.peek() == null){
                empty = true;
            }
            else{
                rock2 = queue.poll();
                queue.add(Math.abs(rock1 - rock2));
            }
        }

        return rock1;
    }
}