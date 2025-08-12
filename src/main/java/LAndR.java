import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LAndR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        long l = Long.parseLong(str[0]);
        long r = Long.parseLong(str[1]);
        long counter = 0;

        for (int i = 1; i <= 18; i++) {
            for (int j = 1; j <= 9; j++) {
                long val = 0;
                for (int k = 0; k < i; k++) {
                    val = val * 10 + j;
                }
                if ( val >= l && val <= r){
                    counter++;
                }
            }
        }


        System.out.println(counter);
    }
}
