package practice.LeetCode.Problems.GFG;

/**
 * Created by srikar on 08-06-2021.
 */

/**
 * Method 2:
 * <p>
 * Approach: The approach is based on the pattern made by indices after rotating the matrix.
 * Consider the following illustration to have a clear insight into it.
 * <p>
 * Consider a 3 x 3 matrix having indices (i, j) as follows.
 * <p>
 * 00 01 02
 * 10 11 12
 * 20 21 22
 * <p>
 * After rotating the matrix by 90 degrees in clockwise direction, indices transform into
 * 20 10 00  current_row_index = 0, i = 2, 1, 0
 * 21 11 01 current_row_index = 1, i = 2, 1, 0
 * 22 12 02  current_row_index = 2, i = 2, 1, 0
 * <p>
 * <p>
 * <p>
 * <p>
 * Observation: In any row, for every decreasing row index i, there exists a constant column index j, such that j = current_row_index.
 * <p>
 * This pattern can be printed using 2 nested loops.
 * (This pattern of writing indices is achieved by writing the exact indices of the desired elements of
 * where they actually existed in the original array.)
 */

public class GFG2 {


    // Function to rotate the matrix 90 degree clockwise
    static void rotate90Clockwise(int[][] arr, int N) {
        // printing the matrix on the basis of
        // observations made on indices.
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    static void rotate90AntiClockwise(int[][] arr, int N) {
        // printing the matrix on the basis of
        // observations made on indices.
        for (int j = N - 1; j >= 0; j--) {
            for (int i = 0; i < N; i++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr2x2 = {{1, 2},{3, 4}};
        int n2x2 = 2;
        int[][] arr3x3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n3x3 = 3;
        int[][] arr4x4 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int n4x4 = 4;
        System.out.println("Matrix before rotating: ");
        GFG.printMatrix(arr4x4, n4x4);
        System.out.println("*********************************");
        rotate90Clockwise(arr4x4.clone(), n4x4);
        System.out.println("*********************************");
        rotate90AntiClockwise(arr4x4.clone(), n4x4);
    }
}
