import java.io.*;
public class TypeOfList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean isConst = true;
        boolean isWAsc = true;
        boolean isAsc = true;
        boolean isWDesc = true;
        boolean isDesc = true;
        int prev = Integer.parseInt(reader.readLine());
        int value;
        while(true){
            value = Integer.parseInt(reader.readLine());
            if (value == -2000000000){
                break;
            }
            if (prev != value) isConst = false;
            if (prev > value) isWAsc = false;
            if (prev >= value) isAsc = false;

            if (prev < value) isWDesc = false;
            if (prev <= value) isDesc = false;

            prev = value;
        }
        if (isConst){
            System.out.println("CONSTANT");
        } else if (isAsc) {
            System.out.println("ASCENDING");
        } else if (isDesc) {
            System.out.println("DESCENDING");
        } else if (isWAsc) {
            System.out.println("WEAKLY ASCENDING");
        } else if (isWDesc) {
            System.out.println("WEAKLY DESCENDING");
        } else System.out.println("RANDOM");

        System.out.println();
        reader.close();
        writer.close();
    }

}
