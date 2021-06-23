package practice.LeetCode.Problems;

import java.util.Stack;

/**
 * Created by srikar on 20-06-2021.
 */

public class PostFix {

    public static int postFix(String tokens) {
        Stack<Integer> stack = new Stack<>();
        int num;
        for(char token: tokens.toCharArray()) {
            switch (token) {
                case '+':
                    stack.push(stack.pop() + stack.pop());
                    break;
                case '-':
                    stack.push(stack.pop() - stack.pop());
                    break;
                case '/':
                    num = stack.pop();
                    stack.push(stack.pop()/num);
                    break;
                case '*':
                    stack.push(stack.pop()*stack.pop());
                    break;
                default:
                    stack.push(Character.getNumericValue(token));
                    break;
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        System.out.println(postFix("21+3*"));
    }
}
