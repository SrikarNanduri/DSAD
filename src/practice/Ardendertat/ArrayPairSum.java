package practice.Ardendertat;

import java.util.*;

/**
 * Created by srikar on 18-06-2021.
 */

/**
 * Array Pair Sum
 * http://www.ardendertat.com/2011/09/17/programming-interview-questions-1-array-pair-sum/
 * */
public class ArrayPairSum {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(1, 1, 2, 2, 3, 4);
        int k = 4;
// this is streams solution. I prefer the methods below than this solution.
        numberList.stream()
                .map(s -> k - s)
                .filter(s -> numberList.contains(s))
                .map(s -> "(" + Math.min(s, k - s) + "," + Math.max(s, k - s) + ")")
                .distinct()
                .forEach(s -> System.out.println(s));
        System.out.println(arrayPair(toIntArray(numberList), k).toString());
        System.out.println(arrayPairOofN(toIntArray(numberList), k).toString());
    }

/**
 *  sort the array and having two pointers to scan the array from the beginning and the end at the same time.
 *  If the sum of the values in left and right pointers equals to k, we output the pair.
 *  If the sum is less than k then we advance the left pointer, else if the sum is greater than k we decrement the right pointer,
 *  until both pointers meet at some part of the array. The complexity of this solution is O(NlogN) due to sorting
 **/
    public static List<String> arrayPair(int[] array, int sum) {
        List<String> pair = new ArrayList<>();
        if (array.length < 2) {
            throw new IllegalArgumentException("Size of the array is less than 2");
        }
        Arrays.sort(array);
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int currentSum = array[start] + array[end];
            if (currentSum == sum) {
                pair.add("(" + Math.min(array[start], array[end]) + "," + Math.max(array[start], array[end]) + ")");
                start++;
            } else if (currentSum < sum) {
                start++;
            } else {
                end--;
            }
        }
        return pair;
    }

/**
 * The O(N) algorithm uses the set data structure.
 * We perform a linear pass from the beginning and for each element we check whether k-element is in the set of seen numbers.
 * If it is, then we found a pair of sum k and add it to the output.
 * If not, this element doesn’t belong to a pair yet, and we add it to the set of seen elements.
 * The algorithm is really simple once we figure out using a set.
 * The complexity is O(N) because we do a single linear scan of the array,
 * and for each element we just check whether the corresponding number to form a pair is in the set or add the current element to the set.
 * Insert and find operations of a set are both average O(1), so the algorithm is O(N) in total.
 * */
    public static List<String> arrayPairOofN(int[] arr, int sum) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Size of the array is less than 2");
        }
        Set<Integer> seen = new HashSet<>();
        Set<String> output = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int target = sum-arr[i];
            if(seen.contains(target)) {
                output.add(("(" + Math.min(arr[i], target)+ "," + Math.max(arr[i], target) + ")"));
            } else {
                seen.add(arr[i]);
            }
        }
        return new ArrayList<>(output);
    }


    public static int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = list.get(i);
        return ret;
    }
}
