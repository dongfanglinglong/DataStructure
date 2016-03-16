package com.df.datastructure.algorithms;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by dongfang on 2016/3/16.
 */
public class PolishExpressionTest {


    private PolishExpression polish = new PolishExpression();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testRPN() throws Exception {
        String string = "a+b*c";
        System.out.println(polish.RPN(string));
        string = "((a+b) + b) *4";
        System.out.println(polish.RPN(string));
        string = "1 + 3-2 * 4";
        System.out.println(polish.RPN(string));
        string = "1+(3-2)*4";
        System.out.println(polish.RPN(string));
    }
}