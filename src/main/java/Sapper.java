import java.io.*;

public class Sapper {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int bombs = Integer.parseInt(str[2]);
        int[][] field = new int[n][m];
        boolean[][] bombPosition = new boolean[n][m];
        for (int i = 0; i < bombs; i++) {
            String[] nm = reader.readLine().split(" ");
            int n1 = Integer.parseInt(nm[0])-1;
            int m1 = Integer.parseInt(nm[1])-1;
            bombPosition[n1][m1] = true;
            if (n1 - 1 >= 0){
                field[n1 - 1][m1] += 1;
                if (m1 -1 >= 0){
                    field[n1 - 1][m1-1] += 1;
                }
                if (m1 + 1 < m){
                    field[n1 -1][m1+1] += 1;
                }
            }
            if (n1 + 1 < n){
                field[n1 + 1][m1] += 1;
                if (m1 + 1 < m){
                    field[n1 + 1][m1+1] += 1;
                }
                if (m1 - 1 >= 0){
                    field[n1 + 1][m1-1] += 1;
                }
            }
            if (m1 - 1 >= 0){
                field[n1][m1-1] += 1;
            }
            if (m1 + 1 < m){
                field[n1][m1+1] += 1;
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bombPosition[i][j]){
                    System.out.print("* ");
                }else System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        reader.close();
        writer.close();
    }

}
