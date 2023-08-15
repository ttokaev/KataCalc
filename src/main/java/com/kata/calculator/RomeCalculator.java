package com.kata.calculator;

public class RomeCalculator implements Calculator {

    private static final String[] romanThousand = {"", "M", "MM", "MMM"};
    private static final String[] romanHundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] romanTen = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] romanOne = {"", "I", "II", "III", "VI", "V", "VI", "VII", "VIII", "IX"};

    public RomeCalculator() {
    }

    @Override
    public int sum(int sum1, int sum2) {
        int res;
        res = sum1 + sum2;
        if (res > 3999)
            throw new RuntimeException("Значение вышло за пределы 3999");
        return res;
    }

    @Override
    public int sub(int reduced, int deductible) {
        int res;
        res = reduced - deductible;
        if (res < 0)
            throw new RuntimeException("т.к. в римской системе нет отрицательных чисел");
        return res;
    }

    @Override
    public int mul(int mul1, int mul2) {
        int res;
        res = mul1 * mul2;
        if (res > 3999)
            throw new RuntimeException("Значение вышло за пределы 3999");
        return res;
    }

    @Override
    public int div(int divisible, int divider) {
        int res;
        res = divisible / divider;
        return res;
    }

    public static int rome2arabic(String romanNum) {
        int result = 0;

        for (int i = 0; i < romanNum.length(); i++) {
            char currentChar = romanNum.charAt(i);
            int currentValue = getRomanValue(currentChar);

            if (i + 1 < romanNum.length()) {
                char nextChar = romanNum.charAt(i + 1);
                int nextValue = getRomanValue(nextChar);

                if (currentValue < nextValue) {
                    result -= currentValue;
                } else {
                    result += currentValue;
                }
            } else {
                result += currentValue;
            }
        }

        return result;
    }

    private static int getRomanValue(char romanChar) {
        return switch (romanChar) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    public static String arabic2rome(int num) {
        return String.format(romanThousand[num / 1000] + romanHundred[num % 1000 / 100] + romanTen[num % 100 / 10] + romanOne[num % 10]);
    }
}
