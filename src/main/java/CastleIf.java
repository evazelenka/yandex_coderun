import java.io.*;

public class CastleIf {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());

        System.out.println(ifPossible(a,b,c,d,e));
        reader.close();
        writer.close();
    }

    private static String ifPossible(int a, int b, int c, int d, int e) {
        if (a <= d && b <= e || a <=e && b <= d){
            return "YES";
        }
        if (a <= d && c <= e || a <=e && c <= d){
            return "YES";
        }
        if (c <= d && b <= e || c <=e && b <= d){
            return "YES";
        }

        return "NO";
    }
}
