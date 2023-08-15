package com.kata.calculator;

public class ArabicCalculator implements Calculator {

    public ArabicCalculator() {
    }

    @Override
    public int sum(int sum1, int sum2) {
        return sum1 + sum2;
    }

    @Override
    public int sub(int reduced, int deductible) {
        return reduced - deductible;
    }

    @Override
    public int mul(int mul1, int mul2) {
        return mul1 * mul2;
    }

    @Override
    public int div(int divisible, int divider) {
        return divisible / divider;
    }
}
