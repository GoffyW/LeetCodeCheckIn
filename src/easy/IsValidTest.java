package easy;

import java.util.Stack;

/**
 * @author guogoffy
 */
public class IsValidTest {
    public static void main(String[] args) {
        System.out.println(isValid("{[[{()}]]}"));
    }
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(stack.isEmpty()||c!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static boolean isValid2(String s){
        int len = s.length()/2;
        for (int i = 0; i < len; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }
        return s.length()==0;
    }
}
