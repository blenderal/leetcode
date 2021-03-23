package statck;

import java.util.Stack;

/**
 * @description:
 * 224. 基本计算器
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * @author: zww
 * @date: 2021/3/10
 * @version: V1.0
 */
public class Calculate {
    public static void main(String[] args) {
        System.out.println(calculate("11 + 1"));
    }
    public static int calculate(String s) {
        Stack<Integer> ops = new Stack<>();
        ops.push(1);
        int n = s.length();
        int i = 0;
        int sign = 1;
        int ret = 0;
        while (i<n){
            char c = s.charAt(i);
            if(c == ' '){
                i++;
            }else if(c == '+'){
                sign = ops.peek();
                i++;
            }else if(c=='-'){
                sign = -ops.peek();
                i++;
            }else if(c=='('){
                ops.push(sign);
                i++;
            }else if(c==')'){
                ops.pop();
                i++;
            }else {
                long num = 0;
                while (i < n && Character.isDigit(c = s.charAt(i))){
                    num = num * 10 + c - '0';
                    ++i;
                }
                ret += num*sign;
            }
        }
        return ret;
    }
}
