package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasacalTraingle {

    public static void main()
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<int[]> arr = new ArrayList<>();

        // storing rows
        for (int i = 0; i < n; i++) {
            arr.add(rowbased(i + 1));
        }

        // printing ArrayList
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        sc.close();
        //System.out.println(ncr(n-1,r-1)); //coz the formula is (n-1)C(r-1).
    }


        //Type One question i.e. given the name row and column return the element at that position.
        public static long ncr( int n, int r)
        {
            long result = 1;
            for (int i = 0; i < r; i++) {
                result = result * (n - i);
                result = result / (i + 1);
            }
            return result;
        }

        //Type 2 question i.e. given the row, print the entire elements of the row.

    public static int[] rowbased ( int n)
    {

        int[] arr = new int[n];

        int ans = 1;
        arr[0] = 1; // first element always 1

        for (int i = 1; i < n; i++) {

            ans = ans * (n - i);
            ans = ans / i;

            arr[i] = ans;
        }
            return arr;
    }
}
