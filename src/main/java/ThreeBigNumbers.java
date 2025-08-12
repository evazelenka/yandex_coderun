import java.io.*;
import java.util.Arrays;

public class ThreeBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = reader.readLine().split(" ");
        int[] nums = new int[str.length];
        int minusCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
            if (nums[i] < 0){
                minusCounter++;
            }
        }
        if (nums.length == 3){
            for (int i = 0; i < 3; i++) {
                System.out.print(nums[i] + " ");
            }
        }else {
            Arrays.sort(nums);
            System.out.println(threeBigNums(nums, minusCounter));
        }
        reader.close();
        writer.close();
    }

    private static String threeBigNums(int[] nums, int minusCounter){
        if (minusCounter > 1){
            long minus = (long) nums[0] * nums[1] * nums[nums.length-1];
            long plus = (long) nums[nums.length - 2] * nums[nums.length-3] * nums[nums.length-1];
            if (minus > plus){
                return nums[0] + " " + nums[1] + " " + nums[nums.length-1];
            }
        }
        return nums[nums.length-3] + " " + nums[nums.length-2] + " " + nums[nums.length-1];
    }
}
