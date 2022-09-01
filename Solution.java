class Solution 
{
    static int[][] isPacificOceanReachable;
    static int[][] isAtlanticOceanReachable;
    
    public static boolean canReachPacificOcean(int[][] heights, int i, int j)
    {
        if(isPacificOceanReachable[i][j] != -1)
        {
            return (isPacificOceanReachable[i][j] == 1);
        }
        else if(i != 0 ? heights[i-1][j] <= heights[i][j] : false)
        {
            isPacificOceanReachable[i][j] = canReachPacificOcean(heights, i-1, j) == true? 1 : 0;
        }
        else if(i != heights.length - 1 ? heights[i+1][j] <= heights[i][j] : false)
        {
            isPacificOceanReachable[i][j] = canReachPacificOcean(heights, i+1, j) == true ? 1 : 0;
        }
        else if(j != 0 ? heights[i][j-1] <= heights[i][j] : false)
        {
            isPacificOceanReachable[i][j] = canReachPacificOcean(heights, i, j-1) == true ? 1 : 0;
        }
        else if(j != heights[0].length - 1 ? heights[i][j+1] <= heights[i][j] : false)
        {
            isPacificOceanReachable[i][j] = canReachPacificOcean(heights, i, j+1) == true ? 1 : 0;
        }
        else
        {
            isPacificOceanReachable[i][j] = 0;
        }
        
        return  (isPacificOceanReachable[i][j] == 1);
    }
    
    public static boolean canReachAtlanticOcean(int[][] heights, int i, int j)
    {
        System.out.println("i = " + i + "\t" + "j = " + j);
        
        if(isAtlanticOceanReachable[i][j] != -1)
        {
            return (isAtlanticOceanReachable[i][j] == 1);
        }
        else if(i != 0 ? heights[i-1][j] <= heights[i][j] : false)
        {
            isAtlanticOceanReachable[i][j] = canReachAtlanticOcean(heights, i-1, j) == true ? 1 : 0;
        }
        else if(i != heights.length - 1 ? heights[i+1][j] <= heights[i][j] : false)
        {
            isAtlanticOceanReachable[i][j] = canReachAtlanticOcean(heights, i+1, j) == true ? 1 : 0;
        }
        else if(j != 0 ? heights[i][j-1] <= heights[i][j] : false)
        {
            isAtlanticOceanReachable[i][j] = canReachAtlanticOcean(heights, i, j-1) == true ? 1 : 0;
        }
        else if(j != heights[0].length - 1 ? heights[i][j+1] <= heights[i][j] : false)
        {
            isAtlanticOceanReachable[i][j] = canReachAtlanticOcean(heights, i, j+1) == true ? 1 : 0;
        }
        else
        {
            isAtlanticOceanReachable[i][j] = 0;
        }
        return (isAtlanticOceanReachable[i][j] == 1);
    } 
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) 
    {
        isPacificOceanReachable = new int[heights.length][heights[0].length];
        isAtlanticOceanReachable = new int[heights.length][heights[0].length];
        
        for(int i=0;i<heights.length;i++)
        {
            for(int j=0;j<heights[0].length;j++)
            {
                if(i == 0 || j == 0) 
                {
                    isPacificOceanReachable[i][j] = 1; 
                    isAtlanticOceanReachable[i][j] = -1;
                }
                else if(i == heights.length - 1 || j == heights[0].length - 1)
                {
                    isAtlanticOceanReachable[i][j] = 1;
                    isPacificOceanReachable[i][j] = -1;
                }
                else
                {
                    isPacificOceanReachable[i][j] = -1;
                    isAtlanticOceanReachable[i][j] = -1;
                }
            }
        }
        
        List<List<Integer>> goodCoordinates = new ArrayList<List<Integer>>();
        
        for(int i=0;i<heights.length;i++)
        {
            for(int j=0;j<heights[0].length;j++)
            {
                if(canReachPacificOcean(heights, i, j) && canReachAtlanticOcean(heights, i, j))
                {
                    List<Integer> coordinate = new ArrayList<Integer>();
                    coordinate.add(i);
                    coordinate.add(j);
                    
                    goodCoordinates.add(coordinate);
                }
            }
        }
        return goodCoordinates;   
    }
}
