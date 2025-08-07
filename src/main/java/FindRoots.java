import java.io.*;

public class FindRoots {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int c = Integer.parseInt(str[2]);
        long start = System.currentTimeMillis();
       findRoots(a, b, c);
        long end = System.currentTimeMillis();
        System.out.println((end - start)*0.001);
        reader.close();
        writer.close();
    }

    private static void findRoots(int a, int b, int c) {
        double d = b * b - 4 * a *c;
        if (d > 0){
            System.out.println(2);
            double x1 = ((-b - Math.sqrt(d))/(2*a));
            double x2 = ((-b + Math.sqrt(d))/(2*a));
            if (x1 > x2){
                System.out.printf("%.6f %.6f%n", x2, x1);
            }else System.out.printf("%.6f %.6f%n", x1, x2);
        } else if (d == 0) {
            System.out.println(1);
            System.out.printf("%.6f%n", (double)-b /(2*a));
        } else System.out.println(0);

    }
}
