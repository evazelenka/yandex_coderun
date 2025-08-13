import java.io.*;
import java.util.*;

public class Poliglot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> map = new HashMap<>();
        List<String> popularLangs = new ArrayList<>();
        for (int i = 0; i < n; i++) { // перебор учеников
            int m = Integer.parseInt(reader.readLine());
            for (int j = 0; j < m; j++) { // перебор языков ученика
                String lang = reader.readLine();
                int c = map.getOrDefault(lang, 1)+1;
                map.put(lang, c);
                if (map.get(lang) == n){
                    popularLangs.add(lang);
                }
            }
        }
        System.out.println(popularLangs.size());
        for (String popularLang : popularLangs) {
            System.out.println(popularLang);
        }

        int all = map.size();
        System.out.println(all);
        Set<String> langs = map.keySet();
        for (String lang : langs) {
            System.out.println(lang);
        }
        reader.close();
        writer.close();
    }
}
