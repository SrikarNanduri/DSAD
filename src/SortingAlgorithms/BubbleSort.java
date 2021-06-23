package SortingAlgorithms;

/**
 * Created by srikar on 04-06-2021.
 */


import SortingAlgorithms.Model.DataAndOrderModel;
import SortingAlgorithms.Utils.GenerateDataUtil;

import java.util.Arrays;

// Bubble sort in Java
public class BubbleSort {
    // perform the bubble sort
    static void bubbleSort(int[] array, String order) {
        int size = array.length;

        // loop to access each array element
        for (int i = 0; i < size - 1; i++)

            // loop to compare array elements
            for (int j = 0; j < size - i - 1; j++)

                // compare two adjacent elements
                // change > to < to sort in descending order
                if (order.equals("asc")) {
                    if (array[j] > array[j + 1]) {

                        // swapping occurs if elements
                        // are not in the intended order
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                } else if (order.equals("desc")){
                    if (array[j] < array[j + 1]) {

                        // swapping occurs if elements
                        // are not in the intended order
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
    }

    public static int bubbleSortSwapped(int[] array) {
        boolean swapped;
        int count = 0;
        for (int i=0; i< array.length; i++) {
            swapped = false;
            count++;
            for (int j = 0; j< array.length-i-1; j++) {
                if( array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }

        return count;

    }


    private int[] findKlargestElements(int[] arr, int k) {
        for(int i =0; i < k; i++) {
            for (int j=0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return Arrays.copyOfRange(arr, arr.length-k, arr.length);
    }

    public static void main(String[] args) {
        DataAndOrderModel dataAndOrderModel = GenerateDataUtil.getData();
        // call method using class name
        BubbleSort.bubbleSort(dataAndOrderModel.getData(), dataAndOrderModel.getOrder());
        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(dataAndOrderModel.getData()));
    }
}
