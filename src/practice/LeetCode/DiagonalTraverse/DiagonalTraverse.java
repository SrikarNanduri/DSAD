package practice.LeetCode.DiagonalTraverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by srikar on 20-06-2021.
 */

/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 *
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 * */

class DiagonalTraverse {

    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return null;

        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        int r = 0;
        int c = 0;

        for (int i = 0; i < res.length; i++) {
            res[i] = mat[r][c];

            if ((r + c) % 2 == 0) { // when sum of indexes is even, it walks up & right
                if (c == n-1) r++;      // case 3 (0,2) turn around
                else if (r == 0) c++;   // case 1 (0,0) turn around
                else {
                    r--;
                    c++;
                }
            } else {                // walks down & left
                if (r == m-1) c++;      // case 8 (2,1) turn around
                else if (c == 0) r++;   // case 4 (1,0) turn around
                else {
                    c--;
                    r++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] matrix2 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(Arrays.toString(findDiagonalOrder(matrix2)));
        System.out.println("\n******************");
       // System.out.println(Arrays.toString(findDiagonalOrderFromLastToFirst(matrix)));
    }
}