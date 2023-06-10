class RecentCounter {
    private Queue<Integer> queue;
    private int numInQueue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
        this.numInQueue = 0;
    }
    
    public int ping(int t) {
        if(queue.peek() == null){
            queue.add(t);
            numInQueue++;
        }
        else{
            while(queue.peek() != null && t - queue.peek() > 3000){
                queue.remove();
                numInQueue--;
            }
            queue.add(t);
            numInQueue++;
        }

        return numInQueue;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */