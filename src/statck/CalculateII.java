package statck;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 *
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 *
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * @author: zww
 * @date: 2021/3/11
 * @version: V1.0
 */
public class CalculateII {
    public static void main(String[] args) {
        CalculateII calculateII =new CalculateII();
//        System.out.println(calculateII.calculate("1+2*3-4+3+2*2-5*6-9/10-7"));
        System.out.println(calculateII.calculate(" 3/2 "));
        //A B C D - * + E F * -
    }
    public int calculate(String s){
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        char preOperate = '+';
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10+ c -'0';
            }
            if(!Character.isDigit(c) && c!=' ' || i == n-1){
                if(preOperate=='+'){
                    stack.push(num);
                }else if(preOperate=='-'){
                    stack.push(-num);
                }else if(preOperate=='*'){
                    stack.push(stack.pop()*num);
                }else if(preOperate=='/'){
                    stack.push(stack.pop()/num);
                }
                preOperate = c;
                num = 0;
            }
        }
        int ret = 0;
        while (!stack.isEmpty()){
            ret+=stack.pop();
        }
        return ret;
    }

//    public int calculate(String s) {
//        Deque<String> num = new LinkedList<>();
//        Stack<String> opera = new Stack<>();
//        int n = s.length();
//        for (int i = 0; i < n; i++) {
//            char c = s.charAt(i);
//            if(c == ' '){
//                continue;
//            }
//            if(c == '+' || c== '-' || c=='*' || c=='/' ){
//                String op = s.substring(i, i + 1);
//                while (!opera.isEmpty() && compare(opera.peek(), op)) {
//                    num.addLast(opera.pop());
//                }
//                opera.push(op);
//            }else if(c == '('){
//                opera.push(s.substring(i,i+1));
//            }else if(c == ')'){
//                while (!"(".equals(opera.peek())){
//                    num.addLast(opera.pop());
//                }
//                opera.pop();
//            } else {
//                long number = 0;
//                while ( i < n) {
//                    number = number * 10 + s.charAt(i) - '0';
//                    if( i+1 < n && !Character.isDigit(s.charAt(i+1))){
//                        break;
//                    }
//                    i++;
//                }
//                num.addLast(String.valueOf(number));
//            }
//        }
//        while (!opera.isEmpty()){
//            num.addLast(opera.pop());
//        }
//        Stack<Long> stack = new Stack<>();
//        while (!num.isEmpty()){
//            if(isOperate(num.peekFirst())){
//                stack.push(operate(num.pollFirst(), stack.pop(), stack.pop()));
//            }else {
//                stack.push(Long.parseLong(num.pollFirst()));
//            }
//        }
//        return stack.pop().intValue();
//    }
//
//    public boolean compare(String op1, String op2) {
//        if("(".equals(op1)){
//            return false;
//        }
//        return (!"*".equals(op2) && !"/".equals(op2)) || (!"+".equals(op1) && !"-".equals(op1));
//    }
//
//    public boolean isOperate(String s){
//        return "-".equals(s) || "+".equals(s) || "*".equals(s) || "/".equals(s);
//    }
//    public long operate(String operate,long b,long a ){
//        if("+".equals(operate)){
//            return a+b;
//        }else if("-".equals(operate)){
//            return a-b;
//        }else if("*".equals(operate)){
//            return a*b;
//        }else {
//            return a/b;
//        }
//
//    }
}
