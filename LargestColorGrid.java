
import java.lang.*;

class LargestColorGrid
{
    static final int n = 9;
    static final int m = 10;

    // stores information about visited cell
    static final int visited[][] = new int [n][m];

    // same colored connected components
    static int COUNT;


     // BFS to find all cells in
    // connection with key = input[i][j]
    static Integer BFS(int x, int i,
                    int j, int colorGrid[][])
    {


        visited[i][j] = 1;
        COUNT++;



        // possible movements in x or y direction
        int x_move[] = { 0, 0, 1, -1 };
        int y_move[] = { 1, -1, 0, 0 };

        // checks all four points with in margin
        for (int u = 0; u < 4; u++)
                if(i + y_move[u] < n && i + y_move[u] >= 0 && j + x_move[u] < m && j + x_move[u] >=0 )
                {
                  if(visited[i + y_move[u]][j + x_move[u]] == 0 && colorGrid[i + y_move[u]][j + x_move[u]] == x) {
                      BFS(x, i + y_move[u],
                              j + x_move[u], colorGrid);
                  }
                }

        return COUNT;

    }


    // function to calculate the
   // largest connected component
    static void findLargeColorGrid(int colorGrid[][])
    {
        int current_max = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                COUNT = 0;

                  BFS(colorGrid[i][j],i, j, colorGrid);

                // updating result
                if (COUNT >= current_max)
                {
                    current_max = COUNT;

                }

            }
        }
        System.out.println ("Number of elements on the largest color grid is : "+ current_max );
    }

    public static void main(String args[])

            // Let Color has a reference key as a Integer value
            // Cordinates of the grid is started from 0,0 continous grid
    {
        int colorGrid[][] = {{1, 1, 2, 1, 1, 3, 3, 1,3,1},
                {1, 3, 3, 3, 2, 3, 3, 3, 2, 1},
                {2, 2, 2, 2, 3, 2, 3, 2, 2, 2},
                {2, 2, 2, 1, 2, 1, 1, 1, 3, 2},
                {1, 1, 1, 3, 2, 3, 2, 3, 2, 3},
                {3, 2, 1, 3, 1, 3, 2, 1, 1, 1},
                {1, 2, 3, 3, 3, 3, 1, 1, 3, 3},
                {3, 3, 2, 1, 2, 2, 1, 3, 3, 1},
                {3, 1, 1, 1, 1, 1, 3, 1, 1, 2},
                {1, 3, 1, 1, 3, 1, 1, 1, 3, 3},
                {1, 3, 1, 1, 2, 1, 1, 1, 2, 3},};


        findLargeColorGrid(colorGrid);
    }
}

