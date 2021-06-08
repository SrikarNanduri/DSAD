package practice.LeetCode.Problems;

import java.util.Scanner;

/**
 * Created by srikar on 05-06-2021.
 */

/**
On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

"G": go straight 1 unit;
"L": turn 90 degrees to the left;
"R": turn 90 degrees to the right.
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

Example 1:
Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
*/

public class RobotBoundedInCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the instructions");
        String instructions = sc.nextLine();
        System.out.println(isRobotBounded(instructions));
    }

    public static boolean isRobotBounded(String instructions) {
        int angle, x, y;
        angle = x = y = 0;

        if (!(instructions.contains("L") || instructions.contains("R"))) return false;

        char[] instr = instructions.toCharArray();

        do {
            for (int i = 0; i < instr.length; i++) {
                switch(instr[i]) {
                    case 'G':
                        if (angle % 360 == 0) x += 1;
                        else if (angle % 360 == 90) y += 1;
                        else if (angle % 360 == 180) x -= 1;
                        else if (angle % 360 == 270) y -= 1;
                        break;
                    case 'L':
                        angle += 270;
                        break;
                    case 'R':
                        angle += 90;
                        break;
                }
            }
        } while(angle % 360 != 0);

        return x == 0 && y == 0;
    }
}
