import java.io.*;

public class Average {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(reader.readLine());
        long b = Long.parseLong(reader.readLine());
        long c = Long.parseLong(reader.readLine());
        reader.close();

        long t = 3*a + b - c;
        long d = (t <= 0) ? 0 : (t + 2) / 3; // округление вверх

        System.out.println(d);
    }
}
