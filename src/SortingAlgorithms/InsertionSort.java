package SortingAlgorithms;

/**
 * Created by srikar on 04-06-2021.
 */

// Insertion sort in Java

import Model.DataAndOrderModel;
import Utils.GenerateDataUtil;

import java.util.Arrays;

class InsertionSort {

    void insertionSort(int[] array, String order) {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];                  // key is the next element which is not sorted
            int previousIndex = step - 1;           // previousIndex can be the left elements which are assumed to be sorted.

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            if (order.equals("asc")) {
                while (previousIndex >= 0 && key < array[previousIndex]) {
                    array[previousIndex + 1] = array[previousIndex];
                    --previousIndex;
                }
            } else if (order.equals("desc")) {
                while (previousIndex >= 0 && key > array[previousIndex]) {
                    array[previousIndex + 1] = array[previousIndex];
                    --previousIndex;
                }
            }

            // Place key at after the element just smaller than it.
            array[previousIndex + 1] = key;
        }
    }

    // Driver code
    public static void main(String[] args) {
        //int[] data = { 9, 5, 1, 4, 3 };
        DataAndOrderModel dataAndOrderModel = GenerateDataUtil.getData();
        InsertionSort is = new InsertionSort();
        is.insertionSort(dataAndOrderModel.getData(), dataAndOrderModel.getOrder());
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(dataAndOrderModel.getData()));
    }
}
