import java.io.*;

public class Triangle {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        System.out.println(isTriangle(a, b, c));
        reader.close();
        writer.close();
    }

    private static String isTriangle(int a, int b, int c){
        int ab = a + b;
        int ac = a + c;
        int bc = b + c;

        if (c < ab){
            if (b < ac){
                if (a < bc){
                    return "YES";
                }
            }
        }
        return "NO";
    }
}
