import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class BinaryTreeLeetCode {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        Integer[] array = new Integer[str.length];
        for (int i = 0; i < array.length; i++) {
            if (str[i].equals("null")){
                array[i] = null;
            } else array[i] = Integer.parseInt(str[i]);
        }

        System.out.println(diameter(array));

        reader.close();
    }


    public static int diameter(Integer[] array){
      int left = recursive(array, 1);
      int right = recursive(array, 2);
      return left + right;
    }

    private static int recursive(Integer[] array, int root){
        if (root >= array.length){
            return 0;
        }
        int left = recursive(array, root * 2 + 1);
        int right = recursive(array, root * 2 + 2);
        return Math.max(left, right) + 1;
    }
}
