import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// задача т банк
public class School {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        Arrays.stream(str).forEach(s -> list.add(Integer.parseInt(s)));

//        for (int i = 0; i < list.size(); i++) {
//            boolean index = (i+1)%2==0;
//            if (index )
//        }

    }
}
