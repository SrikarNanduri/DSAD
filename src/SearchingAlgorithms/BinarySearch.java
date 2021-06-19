package SearchingAlgorithms;

/**
 * Created by srikar on 04-06-2021.
 */

// Binary Search in Java

/**
 * Binary Search is a searching algorithm for finding an element's position in a sorted array.
 *
 * In this approach, the element is always searched in the middle of a portion of an array.
 *
 * Binary search can be implemented only on a sorted list of items. If the elements are not sorted already, we need to sort them first.
 * */

/**
 * Time Complexities
 *
 * Best case complexity: O(1)
 * Average case complexity: O(log n)
 * Worst case complexity: O(log n)
 * */

class BinarySearch {
    int binarySearch(int array[], int x, int low, int high) {

        // Repeat until the pointers low and high meet each other
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == x)
                return mid;

            if (array[mid] < x)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int array[] = { 3, 4, 5, 6, 7, 8, 9 };
        int n = array.length;
        int x = 10;
        int result = ob.binarySearch(array, x, 0, n - 1);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result);
    }


    int binarySearchRecursive(int array[], int x, int low, int high) {

        if (high >= low) {
            int mid = low + (high - low) / 2;

            // If found at mid, then return it
            if (array[mid] == x)
                return mid;

            // Search the left half
            if (array[mid] > x)
                return binarySearchRecursive(array, x, low, mid - 1);

            // Search the right half
            return binarySearchRecursive(array, x, mid + 1, high);
        }

        return -1;
    }
}
