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
     * Complete the 'essayPlagiarism' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     *  3. INTEGER n
     */

    public static int essayPlagiarism(String s1, String s2, int n) {
        int[] letters = new int[26];
        int count = 0;
        
        for(int i = 0; i < s1.length(); i++)
            letters[s1.charAt(i) - 'a']++;
        
        for(int i = 0; i < s2.length(); i++)
            letters[s2.charAt(i) - 'a']--;
        
        for(int i : letters)
            count += (int) Math.abs(i);
        
        return count / 2;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String s1 = firstMultipleInput[0];

        String s2 = firstMultipleInput[1];

        int answer = Result.essayPlagiarism(s1, s2, n);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
