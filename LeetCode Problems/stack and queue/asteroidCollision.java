class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        // add asteroids to the stack 
        // if asteroid is positive
        // if asteroid is negative

        boolean remove = true;
        int len = asteroids.length;
        int temp = 0;
        int size = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < len; i++){
            if(stack.empty()){
                stack.push(asteroids[i]);
                size++;
            }
            else if(stack.peek() > 0 && asteroids[i] > 0){
                stack.push(asteroids[i]);
                size++;
            }
            else if(stack.peek() < 0){
                stack.push(asteroids[i]);
                size++;
            }
            else if(stack.peek() > 0 && asteroids[i] < 0){
                while(remove){

                    if(stack.empty()){
                        stack.push(asteroids[i]);
                        size++;
                        remove = false;
                    }
                    else{
                        temp = stack.pop();
                        size--;
                    
                        if(temp < 0){
                            stack.push(temp);
                            stack.push(asteroids[i]);
                            size+=2;
                            remove = false;
                        }
                        else if(temp == Math.abs(asteroids[i])){
                            remove = false;
                        }
                        else if(temp > Math.abs(asteroids[i])){
                            stack.push(temp);
                            size++;
                            remove = false;
                        }
                    }
                }
                remove = true;
            }
        }

        int output[] = new int[size];
        if(size == 0){
            return output;
        }

        for(int i = size - 1; i >= 0; i--){
            output[i] = stack.pop();
        }

        return output;
    }
}