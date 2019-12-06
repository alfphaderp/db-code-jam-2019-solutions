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
     * Complete the 'schedulingYourWork' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY assignmentTimes
     *  3. INTEGER d
     */

    public static int schedulingYourWork(int n, int[] assignmentTimes, int d) {
        Arrays.sort(assignmentTimes);
        
        int count = 0, i = 0;
        while(d >= 0) {
            d -= assignmentTimes[i];
            count++;
            i++;
        }
        
        return count - 1;
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> assignmentTimes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
		
      	int[] aT = new int[assignmentTimes.size()];
      	for(int i = 0; i < aT.length; i++){
          aT[i] = assignmentTimes.get(i);
        }
      
        int d = Integer.parseInt(bufferedReader.readLine().trim());

        int answer = Result.schedulingYourWork(n, aT, d);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
