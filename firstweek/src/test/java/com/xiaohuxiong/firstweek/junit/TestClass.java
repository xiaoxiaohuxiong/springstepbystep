package com.xiaohuxiong.firstweek.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Calculator.class
})
public class TestClass {

    @Test
    public void test1(){
/*        Assert.assertEquals(expected, actual);
        Assert.assertTrue(condition);
        Assert.assertNotNull(object);
        Assert.assertArrayEquals(expecteds, actuals);*/
    }
}
