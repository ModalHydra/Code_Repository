class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int output = 0;
        int[] position;
        int depth = 0;
        int numInQueue = 0;
        int x, y;
        boolean notFound = true;

        queue.add(entrance);
        // need to be careful of infinite loops when dfs
        // mark current position as visited
        maze[entrance[0]][entrance[1]] = '+';

        while(!queue.isEmpty() && notFound){
            numInQueue = queue.size();
            for(int i = 0; i < numInQueue; i++){
                position = queue.poll();
                y = position[0];
                x = position[1];

                // found exit
                if(isExit(m,n,position) && maze[y][x] != '+'){
                    notFound = false;
                }


                position[0] = y+1;
                position[1] = x;
                // down in bounds and not wall 
                if(inBounds(m,n,position) && maze[y+1][x] == '.'){
                    maze[y+1][x] = '-';
                    queue.add(new int[]{y+1,x});
                }

                position[0] = y-1;
                position[1] = x;
                // up in bounds and not wall 
                if(inBounds(m,n,position) && maze[y-1][x] == '.'){
                     maze[y-1][x] = '-';
                     queue.add(new int[]{y-1,x});
                }

                position[0] = y;
                position[1] = x+1;
                // right in bounds and not wall 
                if(inBounds(m,n,position) && maze[y][x+1] == '.'){
                    maze[y][x+1] = '-';
                    queue.add(new int[]{y,x+1});
                }

                position[0] = y;
                position[1] = x-1;
                // left in bounds and not wall 
                if(inBounds(m,n,position) && maze[y][x-1] == '.'){
                    maze[y][x-1] = '-';
                    queue.add(new int[]{y,x-1});
                }

            }

            if(notFound){
                depth++;
            }

        }            

        if(notFound){
            depth = -1;
        }

        return depth;
    }

        // needs to be bfs
    
    
    public boolean isExit(int m, int n, int[] position){
        boolean output = false;


        if(position[0] == 0 || position[0] == m -1 || position[1] == 0 || position[1] == n - 1){
            output = true;
        }

        return output;
    }

    public boolean inBounds(int m, int n, int[] position){

        return position[0]<m && position[0]>=0 && position[1]<n && position[1]>=0;
    }
}