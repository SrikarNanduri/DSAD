package SortingAlgorithms;

/**
 * Created by srikar on 04-06-2021.
 */


import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

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

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the order in which the sorting should be done (ASC or DESC): ");
        String order  = sc.nextLine();
        System.out.println("Size of array to sort: ");
        int n = sc.nextInt();
        int[] data = new int[n];
        System.out.println("Enter numbers to sort: ");
        for(int i=0; i<n; i++) {
            data[i] = sc.nextInt();
        }
        // call method using class name
        BubbleSort.bubbleSort(data, order.toLowerCase(Locale.ROOT));

        System.out.println("Sorted Array in Ascending Order:");
        System.out.println(Arrays.toString(data));
    }
}
