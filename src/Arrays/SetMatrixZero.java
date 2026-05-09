package Arrays;

import java.util.Scanner;

public class SetMatrixZero {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];

        for (int i = 0; i <row ; i++) {
            for(int j = 0; j <col ; j++) {
                matrix[i][j]= sc.nextInt();
            }
        }

        //Brute force method
        //setmatrixzero(matrix, row, col);
        //betterapproach(matrix);
        optimalsolution(matrix);

        for (int i = 0; i <row ; i++) {
            for(int j = 0; j <col ; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    static void setmatrixzero(int[][]  matrix, int row, int col)
    {
        for (int i = 0; i <row ; i++) {
            for(int j = 0; j <col ; j++) {
                if(matrix[i][j]== 0) {
                    for (int k = 0; k < col; k++) {
                       if( matrix[i][k]!=0)
                       {
                           matrix[i][k] = -1;
                      }
                }
                    for (int k = 0; k < row; k++) {
                        if(matrix[k][j]!=0)
                        {
                            matrix[k][j] =-1;
                        }

                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col ; j++) {
                if (matrix[i][j]==-1)
                {
                    matrix[i][j]= 0;
                }
            }
        }

    }

    //Better approach
    public static void betterapproach(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[] colarray= new boolean[n];
        boolean[] rowarray=  new boolean[m];

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0)
                {
                    colarray[j]= true;
                    rowarray[i]= true;
                }

            }
            
        }
        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                if(colarray[j]|| rowarray[i])
                {
                    matrix[i][j] = 0;
                }
            }

        }
    }

    //Optimal solution
    public static void optimalsolution(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        int col0 = 1;

        for(int i = 0; i < m; i++) {
            for (int j = 0; j<n; j++) {
                if(matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    if(j !=0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }

            }

        }

        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                if(matrix[i][j]!=0)
                {
                    if(matrix[0][j] == 0 || matrix[i][0]==0)
                    {
                        matrix[i][j] = 0;
                    }

                }

            }

        }
        if(matrix[0][0]==0)
        {
            for (int j = 0; j < n ;j++) {
                matrix[0][j]=0;

            }
        }
        if(col0 == 0)
        {
            for (int i = 0; i <m ; i++) {
                matrix[i][0]=0;

            }
        }

    }
}
