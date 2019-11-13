package stack_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 判断括号是否合法
 */
public class BracketIsValid {
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        char[] arr = str.toCharArray();
        for (char charac : arr) {
            // 如果是左括号，压栈
            if (map.containsKey(charac) == false) {
                stack.push(charac);
            } else {// 如果是右括号，就出栈和它匹配，栈为空或者不匹配都是不合法的
                char left = map.get(charac);
                if (stack.isEmpty() || stack.pop() != left) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()";  //true
        System.out.println(isValid(str));
        str = "()[]"; //true
        System.out.println(isValid(str));
        str = "([)]"; //false
        System.out.println(isValid(str));
        str = "((([]))"; //false
        System.out.println(isValid(str));
        str = "]][[";  //false
        System.out.println(isValid(str));
    }
}
