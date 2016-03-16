package com.df.datastructure.algorithms;

import com.df.datastructure.storage.Stack;

/**
 * <Em>波兰表达式</Em>
 * 波兰数学家Jan Lukasiewicz提出了另一种数学表示法。
 * <pre>
 * 它有两种表示形式：
 * 把运算符写在操作数之前，称为波兰表达式(Polish Expression)或前缀表达式(Prefix Expression)，如+AB；
 * 把运算符写在操作数之后，称为逆波兰表达式(Reverse Polish Expression)或后缀表达式(Suffix Expression)，如AB+；
 * <pre>
 *
 *
 * Created by dongfang on 2016/3/16.
 */
public class PolishExpression {
    /**
     * 逆波兰表达式（后缀表达式）
     *
     * @param string 中缀表达式
     * @return
     */
    public String RPN(String string) {

        if (string == null || string.length() == 0) {
            return null;
        }

        String str = string.replace(" ", "");

        StringBuilder sb = new StringBuilder();

        Stack stack = new Stack();

        char temp = 0;
        for (int i = 0, length = str.length(); i < length; i++) {
            temp = str.charAt(i);
            if ((47 < temp && temp < 58)
                    || (64 < temp && temp < 91)
                    || (96 < temp && temp < 123)
                    ) {
                sb.append(temp);
                continue;
            }

            if ('(' == temp) {
                stack.push((int) temp);
                continue;
            }
            else if (')' == temp) {
                while (!stack.isEmpty()) {
                    temp = (char) stack.pop();
                    if ('(' == temp)
                        break;
                    sb.append(temp);
                }
            }
            else if (stack.isEmpty() || precedence(temp) > precedence((char) stack.peek())) {
                stack.push((int) temp);
            }
            else {
                sb.append((char) stack.pop());
                stack.push((int) temp);
            }
        }

        while (!stack.isEmpty()) {
            sb.append((char) stack.pop());
        }

        return sb.toString();
    }

    /**
     * 返回优先级
     *
     * @param operator
     * @return
     */
    private int precedence(char operator) {
        switch (operator) {
        case '+':
        case '-':
            return 10;
        case '*':
        case '/':
            return 20;
        case '(':
        case ')':
        default:
            return 0;
        }
    }

}
