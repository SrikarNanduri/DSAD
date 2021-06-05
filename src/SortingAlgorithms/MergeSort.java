package SortingAlgorithms;

import Model.DataAndOrderModel;
import Utils.GenerateDataUtil;

/**
 * Created by srikar on 04-06-2021.
 */

// Merge sort in Java

class MergeSort {

    // Merge two subarrays L and M into arr
    void merge(int[] arr, int start, int middle, int end) { // p = start, q = middle, and r = end

        // Create L ← A[p..q] and M ← A[q+1..r]
        int n1Size = middle - start + 1;
        int n2Size = end - middle;

        int[] L = new int[n1Size];
        int[] M = new int[n2Size];

        for (int i = 0; i < n1Size; i++)
            L[i] = arr[start + i];
        for (int j = 0; j < n2Size; j++)
            M[j] = arr[middle + 1 + j];

        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = start;

        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < n1Size && j < n2Size) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1Size) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2Size) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }

    // Divide the array into two subarrays, sort them and merge them
    void mergeSort(int[] arr, int start, int end) {
        if (start < end) {

            // m is the point where the array is divided into two subarrays
            int middle = (start + end) / 2;

            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);

            // Merge the sorted subarrays
            merge(arr, start, middle, end);
        }
    }

    // Print the array
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String[] args) {
        //int[] arr = { 6, 5, 12, 10, 9, 1 };
        DataAndOrderModel dataAndOrderModel = GenerateDataUtil.getData();
        MergeSort ob = new MergeSort();
        ob.mergeSort(dataAndOrderModel.getData(), 0, dataAndOrderModel.getData().length - 1);

        System.out.println("Sorted array:");
        printArray(dataAndOrderModel.getData());
    }
}