import java.io.*;

public class Simmetriya {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        int[] array = new int[c];
        for (int i = 0; i < c; i++) {
            array[i] = Integer.parseInt(str[i]);
        }
        checkSimm(array, 0, array.length);
        reader.close();
        writer.close();
    }

    private static void checkSimm(int[] array, int start, int end){
        int i = start;
        int length = end - 1;
        while (i < end && length >= 0 && array[i] == array[length] && i <= length){
            i++;
            length--;
        }
        if (i > length){

        }
    }

//    private static void checkSimm(int[] array, int start, int end){
//        if (start>=end){
//            System.out.println(start);
//        }else if (array[start] == array[array.length - 1 -start]){
//            checkSimm(array, start + 1, end-1);
//            System.out.print(array[start] + " ");
//        }else if (array[start] != array[array.length - 1 -start]){
//            checkSimm(array, start + 1, end);
//            System.out.print(array[start] + " ");
//        }
//    }
//    private static boolean checkSimm(int[] array){
//        for (int i = 0; i < array.length/2; i++) {
//            if (array[i] != array[array.length - 1 -i]){
//                return false;
//            }
//        }
//        return true;
//    }

}
