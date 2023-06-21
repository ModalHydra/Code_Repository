class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // depth first search
        // need a way to signify that a room has been visited
        int len = rooms.size();

        boolean visited[] = new boolean[len];

        Arrays.fill(visited, false);

        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        while(!stack.empty()){
            int num = stack.pop();
            if(!visited[num]){
                visited[num] = true;
                for(int i = 0; i < rooms.get(num).size(); i++){
                    stack.push(rooms.get(num).get(i));
                }
            }
        } 

        for(int i = 0; i < len; i++){
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }
}