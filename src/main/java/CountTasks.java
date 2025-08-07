import java.io.*;

public class CountTasks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        System.out.println(Long.parseLong(str[0]) + Long.parseLong(str[1]));
        reader.close();
        writer.close();
    }
}
