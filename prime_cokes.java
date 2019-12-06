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
     * Complete the 'primeCokes' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER n
     *  3. INTEGER_ARRAY scores
     *  4. CHARACTER_ARRAY cokes
     */

    public static Set<Integer> primesUpTo(int m) {
        Set<Integer> l = new HashSet<>();
        
        for(int i = 2; i < m; i++) {
            boolean bad = false;
            for(int j = 2; j < i; j++)
                if(i % j == 0) {
                    bad = true;
                    break;
                }
            if(!bad)
                l.add(i);
        }
        
        return l;
    }
    
    public static int primeCokes(int m, int n, int[] scores, char[] cokes) {
        Set<Integer> primes = primesUpTo(m);
        int cokeCount = 0;
        
        System.out.println(primes);
        
        for(int i = 0; i < n; i++) {
            if(cokes[i] == 'T') {
                if(scores[i] == m)
                    cokeCount--;
                else
                    cokeCount++;
            } else {
                if(primes.contains(scores[i]))
                    cokeCount++;
            }
            System.out.println(cokeCount);
        }
        
        return cokeCount;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Character> cokes = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(e -> e.charAt(0))
            .collect(toList());
		
      	int[] s = new int[scores.size()];
      	for(int i = 0; i < s.length; i++){
          s[i] = scores.get(i);
        }
      
      	char[] c = new char[cokes.size()];
      	for(int i = 0; i < c.length; i++){
          c[i] = cokes.get(i);
        }
      
        int answer = Result.primeCokes(m, n, s, c);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
