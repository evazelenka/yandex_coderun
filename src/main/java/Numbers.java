import java.io.*;

public class Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nums = reader.readLine().split(" ");
        int[] numbers = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }

        System.out.println(countBigNum(numbers));

        reader.close();
        writer.close();
    }

    private static int countBigNum(int[] numbers) {
        int counter = 0;
        for (int i = 1; i < numbers.length-1; i++) {
            if (numbers[i] > numbers[i-1] && numbers[i] > numbers[i+1]){
                counter++;
            }
        }
        return counter;
    }
}
