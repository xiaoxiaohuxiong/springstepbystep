package com.xiaohuxiong.firstweek.junit;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testCalculator1(){
        Calculator calculator = new Calculator();
        int result = calculator.evaluate("10+20-5");
        Assert.assertEquals(25,result);
    }

}