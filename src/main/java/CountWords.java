import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.stream.Stream;

public class CountWords {
    public static void main(String[] args) throws IOException {
        HashMap<String,Integer> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/input.txt"));

//        FileInputStream reader = new FileInputStream("src/main/java/input.txt");
        int v;
        StringBuilder word = new StringBuilder();
        while(true){
            v = reader.read();
            if (v == -1){
                if (!word.isEmpty()){
                    if (map.containsKey(word.toString())){
                        int counter = map.get(word.toString())+1;
                        map.put(word.toString(), counter);
                    }else map.put(word.toString(), 0);
//                    System.out.println(word + " " + map.get(word.toString()));
                System.out.print(map.get(word.toString()) + " ");
                }
                break;
            }
            char c = (char) v;
            if ((c == ' ' || c == '\n')&& !word.isEmpty()){
                if (map.containsKey(word.toString())){
                    int counter = map.get(word.toString())+1;
                    map.put(word.toString(), counter);
                }else map.put(word.toString(), 0);
//                    System.out.println(word + " " + map.get(word.toString()));
                System.out.print(map.get(word.toString()) + " ");
                word = new StringBuilder();
            }else {
                word.append(c);
            }
        }
        reader.close();
    }
}
