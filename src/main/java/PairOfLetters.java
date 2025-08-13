import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PairOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split("");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length-1; i++) {
            if (!str[i].equals(" ") && !str[i+1].equals(" ")){
                String pair = str[i] + str[i+1];
                int c = map.getOrDefault(pair, 0)+1;
                map.put(pair, c);
            }
        }

        int max = map.values().stream().max(Comparator.naturalOrder()).orElse(1);
//        System.out.println(max);
        List<String> popularPairs = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).equals(max)){
                popularPairs.add(key);
            }
        }
        System.out.println(popularPairs.stream().min(Comparator.reverseOrder()).orElse(null));

        reader.close();
        writer.close();
    }
}
