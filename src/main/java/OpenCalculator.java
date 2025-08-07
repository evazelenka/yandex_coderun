import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class OpenCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] btns = reader.readLine().split(" ");
        String[] num = reader.readLine().split("");


        System.out.println(countMissingBtns(btns, num));
        reader.close();
        writer.close();
    }

    private static int countMissingBtns(String[] str, String[] num){
        num = uniqueArray(num);
        int counter = num.length;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (num[j].equals(str[i])){
                    counter--;
                }
            }
        }
        if (counter < 0){
            return 0;
        }
        return counter;
    }

    private static String[] uniqueArray(String[] num) {
        Set<String> set = Arrays.stream(num).collect(Collectors.toSet());
        String[] result = new String[set.size()];
        return set.toArray(result);
    }
}
