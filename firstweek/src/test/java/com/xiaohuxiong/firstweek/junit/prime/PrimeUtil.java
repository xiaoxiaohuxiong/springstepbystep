package com.xiaohuxiong.firstweek.junit.prime;

import java.util.Arrays;

public class PrimeUtil {

    public static int[] getPrimes(int sum) {
        int[] primes = new int[sum];
        if (sum < 2) {
            return new int[]{};
        } else {

            int size = 0;
            for (int prime = 2; prime < sum; prime++) {
                for (int j = 2; j < prime / 2 + 1; j++) {
                    if (prime % j == 0) {
                        break;
                    }
                    if (j == prime / 2 + 1) {
                        primes[size++] = prime;
                    }
                }
            }
            primes = Arrays.copyOf(primes, size);
            return primes;
        }

    }

}
