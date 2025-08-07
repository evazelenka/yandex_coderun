import java.io.*;

public class NodNok {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int od = nod(a, b);
        System.out.println(od + " " + nok(a, b, od));

        reader.close();
        writer.close();
    }

//    private static int nod(int a, int b) {
//        int big = b;
//        int small = a;
//         if (big == small){
//             return big;
//         }
//         if (a > b){
//             big = a;
//             small = b;
//         }
//        if (big % small == 0){
//            return small;
//        }
//        for (int i = small; i > 1; i--) {
//            if (small % i == 0 && big % i == 0){
//                return i;
//            }
//        }
//        return 1;
//    }
    private static int nod(int a, int b) {
        if (a == 0 && b == 0){
            return 0;
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static long nok(int a, int b, int od) {
        return Math.abs(((long)a/od)*(long) b);
    }

}
