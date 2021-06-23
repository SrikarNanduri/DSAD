package SortingAlgorithms.Utils;

import java.util.Arrays;

/**
 * Created by srikar on 22-06-2021.
 */

public class Utils {

    public static int[] reverseArray(int[] array) {
        int size = array.length;
        int i, temp;
        for (i = 0; i < size / 2; i++) {
            temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
       int[] arr =  reverseArray(new int[]{1,2,3,4,5,6});
        System.out.println(Arrays.toString(arr));
    }
}
