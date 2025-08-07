import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[] {3,4,7,3,7,9,0,6,5,12,34,56,9,21,14,5,6,8,9,0,2,4,37,8,90,100,5,56,77,8,89,21,1};
        quickSort(array);
        Arrays.stream(array, 0, array.length).forEach(a -> System.out.print(a + " "));
    }

    public static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
    }

//    private static void quickSort(int[] array, int start, int finish){
//        int left = start;
//        int right = finish;
//
//        int pivot = array[(left+right)/2];
//
//        do {
//            while (array[left]<pivot){
//                left++;
//            }
//            while (array[right] > pivot){
//                right--;
//            }
//            if (left <= right){
//                if (left<right){
//                    int temp = array[left];
//                    array[left] = array[right];
//                    array[right] = temp;
//                }
//                left++;
//                right--;
//            }
//
//        } while (left <= right);
//
//        if (left<finish){
//            quickSort(array, left, finish);
//        }
//        if (right>start){
//            quickSort(array, start, right);
//        }
//    }

   private static void quickSort(int[] array, int start, int finish){
        int left = start;
        int right = finish;
        int pivot = array[(left + right)/2];

        do {
            while (array[left] < pivot){
                left++;
            }
            while (array[right] > pivot){
                right--;
            }

            if (right>=left){
                if (right>left){
                    int temp = array[right];
                    array[right] = array[left];
                    array[left] = temp;
                }
                left++;
                right--;
            }
        } while (right>=left);

        if (right > start){
            quickSort(array, start, right);
        }
        if (left < finish){
            quickSort(array, left, finish);
        }
   }
}
