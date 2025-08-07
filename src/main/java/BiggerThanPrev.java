import java.io.*;

public class BiggerThanPrev {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int[] array = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        System.out.println(isMoreThanPrev(array));

        reader.close();
        writer.close();
    }

    private static String isMoreThanPrev(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i-1]){
                return "NO";
            }
        }
        return "YES";
    }
}
