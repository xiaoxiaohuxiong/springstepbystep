package com.xiaohuxiong.firstweek.junit.prime;

import org.junit.Assert;
import org.junit.Test;

public class PrimeUitlsTest {

    @Test
    public void testPrime1(){
        int[] expected={};
        Assert.assertArrayEquals(expected,PrimeUtil.getPrimes(2));
        Assert.assertArrayEquals(expected,PrimeUtil.getPrimes(0));
        Assert.assertArrayEquals(expected,PrimeUtil.getPrimes(-1));
    }

    @Test
    public void testPrime2(){
        //int[] expected={};
        Assert.assertArrayEquals(new int[]{2,3,5,7},PrimeUtil.getPrimes(9));
       // Assert.assertArrayEquals(new int[]{2,3,5,7,11,13},PrimeUtil.getPrimes(17));
    }
}
