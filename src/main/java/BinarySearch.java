public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,5,6,7,8,9,10,11,12,16,17,18,19,20};
        int index = binarySearch(array, 11);
        System.out.println(index + ": " + array[index]);
    }

    public static int binarySearch(int[] array, int value){
        return binarySearch(array, value, 0, array.length-1);
    }

//    private static int binarySearch(int[] array, int value, int min, int max){
//        int midpoint;
//        if (min > max){
//            return -1;
//        } else {
//            midpoint = (max - min)/2 + min;
//        }
//
//        if (array[midpoint] < value){
//            return binarySearch(array, value, midpoint+1, max);
//        } else {
//            if (array[midpoint] > value){
//                return binarySearch(array, value, min, midpoint - 1);
//            }
//        }
//        return midpoint;
//    }

    private static int binarySearch(int[] array, int value, int min, int max){
        int midpoint;

        if (min > max){
            return -1;
        } else midpoint = (max + min)/2;

        if (array[midpoint] > value){
            return binarySearch(array, value, min, midpoint -1);
        } else if (array[midpoint] < value) {
            return binarySearch(array, value, midpoint + 1, max);
        }
        return midpoint;
    }
}
