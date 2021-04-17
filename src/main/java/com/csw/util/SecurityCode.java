package com.csw.util;

import java.util.Arrays;

public class SecurityCode {
    public static String getSecurityCode() {
        return getSecurityCode(4, SecurityCodeLevel.Medium, false);
    }

    ;

    private static String getSecurityCode(int length, SecurityCodeLevel level,
                                          boolean isCanRepeat) {
        int len = length;
        char[] codes = {'2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'd',
                'e', 'f', 'g', 'h', 'm', 'n', 'q', 'y', 'A',
                'B', 'D', 'E', 'F', 'G', 'H', 'I', 'L', 'M', 'N', 'Q', 'R',
                'T', 'Y'};
        if (level == SecurityCodeLevel.Simple) {
            codes = Arrays.copyOfRange(codes, 0, 10);
        } else if (level == SecurityCodeLevel.Medium) {
            codes = Arrays.copyOfRange(codes, 0, 36);
        }
        int n = codes.length;
        if (len > n && isCanRepeat == false) {
            throw new RuntimeException(String.format(
                    "????SecurityCode.getSecurityCode(%1$s,%2$s,%3$s)????????"
                            + "??isCanRepeat?%3$s??????????%1$s???????%4$s",
                    len, level, isCanRepeat, n));
        }
        char[] result = new char[len];
        if (isCanRepeat) {
            for (int i = 0; i < result.length; i++) {
                int r = (int) (Math.random() * n);
                result[i] = codes[r];
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                int r = (int) (Math.random() * n);
                result[i] = codes[r];
                codes[r] = codes[n - 1];
                n--;
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(SecurityCode.getSecurityCode());
    }

    public enum SecurityCodeLevel {
        Simple, Medium, Hard
    }
}