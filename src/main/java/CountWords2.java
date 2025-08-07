import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CountWords2 {
    public static void main(String[] args) throws IOException {
        // BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int v;
        StringBuilder word = new StringBuilder();
        Set<String> set = new HashSet<>();
        while((v = reader.read()) != -1){
            char c = (char) v;
            if ((c == ' ' || c == '\n') && !word.isEmpty()){
                set.add(word.toString());
                // System.out.println(word);
                word = new StringBuilder();
            } else {
                word.append(c);
            }
        }
        System.out.println(set.size());
        reader.close();
    }
}
