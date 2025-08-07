import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ClosetNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        int findNumber = Integer.parseInt(reader.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int value = Integer.parseInt(str[i]);
            map.put(Math.abs(value - findNumber), value);
        }
        int resultIndex = map.keySet().stream().mapToInt(v -> v).min().getAsInt();
        System.out.println(map.get(resultIndex));
        reader.close();
        writer.close();
    }

}
