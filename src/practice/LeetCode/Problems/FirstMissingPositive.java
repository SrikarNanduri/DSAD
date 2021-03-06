package practice.LeetCode.Problems;

/**
 * Created by srikar on 23-06-2021.
 */

/**
 * First Missing Positive
 *
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 *
 * */

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            nums[i] = 0;

            while (true) {
                if (x < 1 || x > n || x == nums[x - 1]) break;

                int y = nums[x - 1];
                nums[x - 1] = x;
                x = y;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                return i + 1;
        }

        return n + 1;
    }

    public static void main(String[] args) {
        int[] output1 = new int[]{7,8,9,11,12};
        int[] output2 = new int[]{1,2,0};
        int[] output3 = new int[]{3,4,-1,1};
        int[] output4 = new int[]{3,1,-1,-2,5};
        System.out.println(firstMissingPositive(output4));
    }
}


/** Explanation:
 * Question
 *     Given an unsorted integer array nums, find the smallest
 *     missing positive integer.
 *
 *     Constraints:
 *         - 0 <= nums.length <= 300
 *         - -2^31 <= nums[i] <= 2^31 - 1
 *
 * Thoughts Before Coding
 *     - The range of positive numbers is from 1 -> nums.length + 1
 *         - This means all of the positive numbers can fit inside the input array except
 *           for the last positive number 'nums.length + 1'
 *     - We can mark the indices that we have already found a number for
 *         - if we have found the integer 'x', which is in the range of '1 -> nums.length'
 *             - We can place the integer at index 'x - 1' to mark as seen
 *         - Then for all of the other integers, which are not within range
 *             - We can mark the index as 0
 *     - [3,4,-1,1]
 *         - [0, 4, 3, 1] (-1)
 *             - [0, 0, 3, 4] (1)
 *                 - [1, 0, 3, 4] (0)
 *     - [1, 2, 3, 4], then our missing number is equal to 'nums.length + 1'
 *
 * Answer
 *     - Create a variable 'n', which is the length of the input array
 *     - Iterate through the indices of 'nums', denoted as 'i'
 *         - Create a variable 'x' and set it to 'nums[i]'
 *         - Set 'nums[i]' to 0
 *         - While 'true'
 *             - if 'x' is less than 1 OR greater than 'n' OR 'x' is equal to 'nums[x - 1]'
 *                 - break from the loop
 *             - Create a variable 'y' and save 'nums[x - 1]'
 *             - Set 'nums[x - 1]' to 'x'
 *             - Set 'x' to 'y'
 *     - Iterate through the indices of 'nums', denoted as 'i'
 *         - If 'nums[i]' is equal to 0
 *             - Return 'i + 1'
 *     - Return 'n + 1'
 *
 * What is the Time and Space Complexity?
 *     - Time Complexity = O(n) + O(n) = O(n), where 'n' is the length of the input array
 *         - O(n), visit each index at most twice
 *         - O(n), find missing positive
 *     - Space Complexity = O(1)*/