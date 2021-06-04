package SortingAlgorithms;

/**
 * Created by srikar on 04-06-2021.
 */

// Selection sort in Java

import Model.DataAndOrderModel;
import Utils.GenerateDataUtil;

import java.util.Arrays;

class SelectionSort {
    void selectionSort(int[] array, String order) {
        int size = array.length;

        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;

            for (int i = step + 1; i < size; i++) {


                // Select the minimum element in each loop.
                if (order.equals("asc")) {
                    if (array[i] < array[min_idx]) {
                        min_idx = i;
                    }
                } else if (order.equals("desc")) {
                    if (array[i] > array[min_idx]) {
                        min_idx = i;
                    }
                }
            }

            // put min at the correct position
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }

    // driver code
    public static void main(String[] args) {
        //int[] data = { 20, 12, 10, 15, 2 };
        DataAndOrderModel dataAndOrderModel = GenerateDataUtil.getData();
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(dataAndOrderModel.getData(), dataAndOrderModel.getOrder());
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(dataAndOrderModel.getData()));
    }
}