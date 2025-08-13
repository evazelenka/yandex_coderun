import java.io.*;

public class Sum {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());

        sumRep("", n, n);

        reader.close();
        writer.close();
    }

    private static String getWithSign(String left) {
        return left + (left == "" ? "" : " + ");
    }

    private static void sumRep(String left, int n, int max) throws IOException {
        if (n == 1) {
            System.out.print(getWithSign(left) + "1");
            return;
        }

        for (int i = 1; i < n; ++i) {
            if (i > max) continue;
            sumRep(getWithSign(left) + i, n - i, i);
            System.out.println();
        }

        if (n <= max)
            System.out.print(getWithSign(left) + n);
    }
}
