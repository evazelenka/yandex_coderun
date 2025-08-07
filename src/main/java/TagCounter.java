import java.io.*;

public class TagCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int tasks = Integer.parseInt(reader.readLine());
        System.out.println(countTags(tasks));

        reader.close();
        writer.close();
    }

    private static int countTags(int tasks) {
        int counter = 0;
        if (tasks < 3){
            return tasks;
        } else if (tasks == 3){
            return 4;
        } else counter = 4;
        int[] tags = createArray(tasks);

        for (int i = 3; i < tasks; i++) {
            counter += tags[i];
        }
        return counter;
    }

    private static int[] createArray(int tasks){
        int[] array = new int[tasks];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i < tasks; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array;
    }
}
