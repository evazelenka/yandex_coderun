import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Synonim {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(reader.readLine());
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] str = reader.readLine().split(" ");
            map.put(str[0], str[1]);
            map.put(str[1], str[0]);
        }
        String synonim = reader.readLine();
        System.out.println(map.get(synonim));

        reader.close();
        writer.close();
    }
}
