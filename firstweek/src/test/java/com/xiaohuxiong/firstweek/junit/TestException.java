package com.xiaohuxiong.firstweek.junit;

import org.junit.Assert;
import org.junit.Test;

public class TestException {

    @Test
    public void testEvaluateWrongExpression(){
        Calculator calculator = new Calculator();
        try {
            calculator.evaluate("10/0");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.fail("yichang");
    }
}
