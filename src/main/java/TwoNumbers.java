import java.util.*;

public class TwoNumbers {
    public static void main(String[] args) {
      int[] array = new int[]{3,5,6,2,1,9,0,4,8,1,-3};
      sort(array, "quick");
      Arrays.stream(array).forEach(v -> System.out.print(v + " "));
    }

    public static void sort(int[] array, String sort){
        if (sort.equals("quick")){
            // quick sort
            quickSort(array, 0, array.length-1);
        }

    }

    private static void quickSort(int[] array, int start, int end){
        int left = start;
        int right = end;
        int pivot = array[(start+end)/2];

        do {
            while (array[left] < pivot){
                left++;
            }

            while(array[right] > pivot){
                right--;
            }

            if (left <= right){
                if (left < right){
                    int temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                }
                left++;
                right--;
            }
        } while (left <= right);

        if (left < end){
            quickSort(array, left, end);
        }
        if (right > start){
            quickSort(array, start, right);
        }
    }


}
