class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n= heights[0].length;
        int[][] result = new int[m][n];
        for(int[] r: result)
            Arrays.fill(r, Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap= new PriorityQueue<int[]>((a,b)->a[2]-b[2]);
        int[][] dirs=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int minEffort = 0;
        minHeap.offer(new int[]{0,0,0});
        result[0][0]=0;
        while(!minHeap.isEmpty()){
            int[] node =minHeap.poll();
            int x =node[0], y=node[1], effort=node[2];
            if (x==m-1 && y==n-1)
                return effort;
            for(int[] dir:dirs){
                int newX= x+dir[0];
                int newY= y+dir[1];
                if (newX>=0 && newX <m && newY >=0 && newY <n){
                    int absDiff = Math.abs(heights[newX][newY]-heights[x][y]);
                    int threshold = Math.max(effort, absDiff);
                    if (threshold< result[newX][newY]){
                        result[newX][newY]=threshold;
                        minHeap.offer(new int[]{newX,newY, threshold});
                    }
                }
            }
        }
        return result[m-1][n-1];
    }
}
