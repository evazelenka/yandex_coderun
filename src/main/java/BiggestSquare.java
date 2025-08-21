import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BiggestSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) { // заполняем матрицу числами
            List<Integer> nums = readNumsViaSpace(reader);
            nums.add(0); // прибавляем ноль в конец каждой строки, чтобы проще было работать с индексами
            matrix[i] = nums.stream().mapToInt(value -> value).toArray();
        }

        for (int i = 1; i < n; i++) { // каждый не нулевой элемент увеличиваю на значение, стоящее над ним в матрице
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] != 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        int maxLength = 0;
        int x = -1;
        int y = -1;

        for (int i = 0; i < n; i++) {
            int[] pair = getMaxArea(matrix[i]);
            if (maxLength <= pair[0]){
                maxLength = pair[0];
                x = i - maxLength +2;
                y = pair[1];
            }
        }
        writer.write(maxLength + "\n");
        writer.write(String.format("%d %d\n", x, y));

        reader.close();
        writer.close();
    }

    private static int[] getMaxArea(int[] heights) {
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{0, -1});
        int maxLength = 0;
        int index = -1;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];

            int currentIndex = i + 1;

            while (height <= stack.peek()[1]){
                Integer[] top = stack.peek();
                currentIndex = top[0];
                if (top[1] == (i - currentIndex +1)){
                    if (maxLength <= top[1]){
                        maxLength = top[1];
                        index = currentIndex;
                    }
                }
                stack.pop();
            }
            stack.push(new Integer[]{currentIndex, height});
        }
        return new int[]{maxLength, index};
    }

    public static List<Integer> readNumsViaSpace(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
    }
    
    
}
