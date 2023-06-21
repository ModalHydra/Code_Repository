class SmallestInfiniteSet {
    int infiniteNum;
    SortedSet<Integer> returnedSet;

    public SmallestInfiniteSet() {
        infiniteNum = 1;
        returnedSet = new TreeSet<Integer>();
    }
    
    public int popSmallest() {
        if(returnedSet.isEmpty()){
            return infiniteNum++;
        }
        else{
            int temp = returnedSet.first();
            returnedSet.remove(temp);
            return temp;
        }
    }
    
    public void addBack(int num) {

        if(num < infiniteNum){
            returnedSet.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */