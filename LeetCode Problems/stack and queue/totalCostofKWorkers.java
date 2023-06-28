
class Solution {

    public long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;
        PriorityQueue<Integer> leftQueue = new PriorityQueue<Integer>();
        PriorityQueue<Integer> rightQueue = new PriorityQueue<Integer>();
        int left = 0; 
        int right = len -1;
        long output = 0;
        int candidateHolder = candidates;
        boolean swap = true;
        System.out.println(len);
        if(len == 1){
            leftQueue.add(costs[0]);
            len--;
        }
        else if(len %2 == 0){
            while(left < right && candidates > 0){
                leftQueue.add(costs[left]);
                rightQueue.add(costs[right]);
                left++;
                right--;
                candidates--;
                len -= 2;
            }
        }
        else{
            while(left != right && candidates > 0){
                if(swap){
                    rightQueue.add(costs[right]);
                    
                    right--;
                    swap = false;
                    len--;
                }
                else{
                    
                    leftQueue.add(costs[left]);
                    System.out.println(costs[left] + " " + left);
                    left++;
                    swap = true;
                    candidates--;
                    len--;

                }
            }
        }

        int temp1 = 0; 
        int temp2 = 0;
        for(int i = 0; i < k; i++){
            if(leftQueue.peek() != null){
                temp1 = leftQueue.peek();
            }
            else{
                temp1 = 1000000;
            }

            if(rightQueue.peek() != null){
                temp2 = rightQueue.peek();
            }
            else{
                temp2 = 10000000;
            }


            if(temp1 < temp2){
                output += leftQueue.poll();
                if(len != 0){
                    leftQueue.add(costs[left]);
                    left++;
                    len--;
                }
            }
            else if(temp2 < temp1){
                output += rightQueue.poll();
                if(len != 0){
                    rightQueue.add(costs[right]);
                    right--;
                    len--;
                }
            }
            else{
                output += leftQueue.poll();
                if(len != 0){
                    leftQueue.add(costs[left]);
                    left++;
                    len--;
                }
            }
        }

        return output;
        
    }

}