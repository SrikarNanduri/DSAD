package practice.LeetCode.Problems;

import java.util.Arrays;

/**
 * Created by srikar on 22-06-2021.
 */

public class ReverseAnArrayToK {

    private static int[] reverseToKindex(int[] array, int k) {
        int temp;
        for (int i =0; i < k / 2; i++) {
            temp = array[ k - i - 1];
            array [k - i - 1] = array[i];
            array[i] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] arr =  reverseToKindex(new int[]{1,2,3,4,5,6}, 4);
        System.out.println(Arrays.toString(arr));
    }
}
