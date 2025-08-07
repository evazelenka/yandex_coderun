import java.io.*;

public class Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int k = Integer.parseInt(str[2]);
        int[][] a = new int[n][m];
        int[][] b = new int[m][k];

        for (int i = 0; i < n; i++) {
            String[] str2 = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(str2[j]);
//                System.out.println(a[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            String[] str2 = reader.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                b[i][j] = Integer.parseInt(str2[j]);
            }
        }

        int[][] result = calculate(a, b, n, m, k);
        showMatrix(result);

        reader.close();
        writer.close();
    }

    private static void showMatrix(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] calculate(int[][] a, int[][] b, int n, int m, int k) {
        int[][] c = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < m; l++) {
                    c[i][j] += a[i][l]*b[l][j];
                }
            }
        }
        int[][] result = new int[k][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                result[j][i] = c[i][j];
            }
        }
        return result;
    }

}
