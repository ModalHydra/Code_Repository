class Solution {

    class Node{
        int num1;
        int num2;

        Node(int a, int b){
            this.num1 = a;
            this.num2 = b;
        }

        public int getNum1(){
            return this.num1;
        }

        public int getNum2(){
            return this.num2;
        }
    }

    class nodeCompare implements Comparator<Node>{
        public int compare(Node n1, Node n2)
        {
            if (n1.num2 == n2.num2)
                return 0;
            else if (n1.num2 > n2.num2)
                return -1;
            else
                return 1;
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;

        long max = 0;

        ArrayList<Node> array = new ArrayList<Node>();

        for(int i = 0; i < len; i++){
            array.add(new Node(nums1[i],nums2[i]));
        }

        array.sort(new nodeCompare());

        long currentSum = 0;
        long current = 0;
        int temp = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for(int i = 0; i < len; i++){
            temp = array.get(i).getNum1();
            queue.add(temp);
            currentSum += temp;

            if(queue.size() > k){
                currentSum -= queue.poll();
            }
            if(queue.size() == k){
                current = currentSum * array.get(i).getNum2();
                if(current > max){
                    max = current;
                }
            }

        }
        
        

        return max;
    }
}