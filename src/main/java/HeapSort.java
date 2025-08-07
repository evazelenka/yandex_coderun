import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
//        int[] array = new int[] {7,4,5,6,2,9,1,3,10,8,15,13,12,11,14};
        int[] array = new int[] {3,4,7,3,7,9,0,6,5,12,34,56,9,21,14,5,6,8,9,0,2,4,37,8,90,100,5,56,77,8,89,21,1};
        sort(array);
        Arrays.stream(array, 0, array.length).forEach(a -> System.out.print(a + " "));
    }

//    public static void sort(int[] array){
//        for (int i = (array.length/2) - 1; i >= 0; i--) {
//            heapify(array, array.length, i);
//        }
//
//        for (int i = array.length-1; i >= 0; i--) {
//            int temp = array[0];
//            array[0] = array[i];
//            array[i] = temp;
//
//            heapify(array, i, 0);
//        }
//    }
//
//    private static void heapify(int[] array, int length, int i) {
//        int largest = i;
//        int leftChild = i * 2 + 1;
//        int rightChild = i * 2 + 2;
//
//        if (leftChild < length && array[leftChild] > array[largest]){
//            largest = leftChild;
//        }
//        if (rightChild < length && array[rightChild] > array[largest]){
//            largest = rightChild;
//        }
//        if (largest != i){
//            int temp = array[largest];
//            array[largest] = array[i];
//            array[i] = temp;
//            heapify(array, length, largest);
//
//        }
//
//    }

  public static void sort(int[] array){
      for (int i = array.length/2-1; i >= 0; i--) {
          heapify(array, array.length, i);
      }

      for (int i = array.length-1; i >=0; i--) {
          int temp = array[0];
          array[0] = array[i];
          array[i] = temp;
          heapify(array, i, 0);
      }
  }

  private static void heapify(int[] array, int heapSize, int root){
        int left = root*2 + 1;
        int right = root*2 + 2;
        int largest = root;

        if (left < heapSize && array[left] > array[largest]){
            largest = left;
        }

        if (right < heapSize && array[right] > array[largest]){
            largest = right;
        }

        if (largest != root){
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;
            heapify(array, heapSize, largest);
        }
  }
}
