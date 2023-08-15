package com.kata.calculator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KataCalcApplication {
    
    static Calculator calculator; 

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression = reader.readLine();
        String[] expArr = expression.split(" ");

        if (expArr.length == 1)
            throw new Exception("т.к. строка не является математической операцией");

        if (expArr.length != 3)
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        int num1;
        int num2;

        if (expArr[0].matches("\\d+")) {
            if (expArr[2].matches("\\d+")) {
                calculator = new ArabicCalculator();
                num1 = Integer.parseInt(expArr[0]);
                num1 = Integer.parseInt(expArr[2]);
            }
            else if (expArr[2].matches("[IVXLCDM]+")) {
                throw new Exception("т.к. используются одновременно разные системы счисления");
            }
            else {
                throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        } else if (expArr[0].matches("[IVXLCDM]+")) {
            if (expArr[2].matches("[IVXLCDM]+")) {
                calculator = new RomeCalculator();
                num1 = RomeCalculator.rome2arabic(expArr[0]);
                num2 = RomeCalculator.rome2arabic(expArr[2]);
                
            }
            else if (expArr[2].matches("\\d+")) {
                throw new Exception("т.к. используются одновременно разные системы счисления");
            }
            else {
                throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

        } else {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

    }

    public int getAnswer(String operation, Calculator calc, int num1, int num2) {
        return switch (operation) {
            case "+" -> calc.sum(num1, num2);
            case "-" -> calc.sub(num1, num2);
            case "*" -> calc.mul(num1, num2);
            case "/" -> calc.div(num1, num2);
            default ->
                    throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        };
    }
}
