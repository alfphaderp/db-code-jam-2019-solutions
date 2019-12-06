import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'meetingInDowntownDB' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY matrix
     *  3. INTEGER c
     */

    public static int ff(int[][] mat, int i, int j) {
        if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] == 1)
            return 0;
        else {
            mat[i][j] = 1;
            return 1 + ff(mat, i - 1, j - 1) + ff(mat, i - 1, j) + ff(mat, i - 1, j + 1) + ff(mat, i, j - 1) + ff(mat, i, j + 1) + ff(mat, i + 1, j - 1) + ff(mat, i + 1, j) + ff(mat, i + 1, j + 1);
        }
    }
    
    public static int meetingInDowntownDB(int n, int[][] matrix, int c) {
        int count = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(ff(matrix, i, j) >= c)
                    count++;
        return count;
    }

}

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int c= scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        int answer = Result.meetingInDowntownDB(n, matrix, c);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
