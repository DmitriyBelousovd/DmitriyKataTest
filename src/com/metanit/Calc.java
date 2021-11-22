package com.metanit;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

class RomanArabianCalc {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main (String[] args) {
        System.out.println("Введите  выражение [2+2] или два римских числа от I до X:[V+V] + Enter ");
//      Считываем строку userInput которую ввёл пользователь
        String userInput = scanner.nextLine();
//      Создаём пустой символьный массив длиной 10 символов:  under_char
        char[] under_char = new char[10];
//      Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1].trim();
        String type1 = "";
        String type2 = "";

        try {
            Integer.parseInt(stable00);
            type1 = "АРАБ";
        } catch (Throwable e) {
            type1 = "РИМ";
        }
        try {
            Integer.parseInt(stable01);
            type2 = "АРАБ";
        } catch (Throwable e) {
            type2 = "РИМ";
        }

        number1 = romanToNumber(stable00);
        number2 = romanToNumber(stable01);

        if (number1 > 10 || number2 > 10) {
            throw new InputMismatchException("Неверное значение числа");
        }

        if (type1.equals("АРАБ") && type2.equals("АРАБ")) {
            result = calculated(number1, number2, operation);
            System.out.println("--Результат для арабских цифр----");
            System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
        } else if (type1.equals("РИМ") && type2.equals("РИМ")) {
            result = calculated(number1, number2, operation);
            if (result == 0) {
                throw new InputMismatchException("Нуля нет в римских цифрах");
            }
            String resultRoman = convertNumToRoman(result-1);
            System.out.println("---Результат для римских цифр----");
            System.out.println(stable00 + " " + operation + " " + stable01 + " = " + resultRoman);
        } else {
            throw new InputMismatchException("Арабские и римские числа не совместимы");
        }
    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = { "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }


    private static int romanToNumber (String roman) {
        try {
            return switch (roman) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                case "X" -> 10;
                default -> throw new InputMismatchException();
            };
        } catch (InputMismatchException e) {
            return Integer.parseInt(roman);
        }
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}
