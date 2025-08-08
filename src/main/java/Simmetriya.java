import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Simmetriya {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        int[] array = new int[c];
        for (int i = 0; i < c; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        checkSimm(array);
        reader.close();
        writer.close();

    }

    private static void checkSimm(int[] array){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!check(array, i, array.length-1)){
                result.add(array[i]);
            } else {
//                System.out.println(array[i] + "!");
                break;
            }
        }
        System.out.println(result.size());
        if (!result.isEmpty()){
            for (int i = result.size()-1; i >= 0; i--) {
                System.out.print(result.get(i) + " ");
            }
        }
    }

    private static boolean check(int[] array, int start, int end){
        while (start<=end){
            if (array[start] != array[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
