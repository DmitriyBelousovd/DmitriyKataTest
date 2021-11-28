package com.metanit;

import java.util.InputMismatchException;
import java.util.Scanner;

public class asd {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static String operation;
    static int result;

    public static void main (String[] args) {
        System.out.println("Ведите данные в формате '1+1' без пробелов и нажмите Enter, можно использовать арабские и римские числа до 10 включительно."); // вывожу на экран
        String userInp = scanner.nextLine(); // Ввелтип переменной Стринг с названием и определил его значение . все чтопосле знака равно это все значения
        for (int p = 0; p < userInp.length(); p++) {
            switch (String.valueOf(userInp.charAt(p))) {
                case "+" -> operation = "+";
                case "-" -> operation = "-";
                case "*" -> operation = "*";
                case "/" -> operation = "/";
            }
        }
        String[] arrayUserInp = userInp.split("[+-/*]");// сейчас программа понимает только строку,нам надоразбить сроку на элементы перевести ее в МАССИВ.каждый элемент будет строкой который я укажу  ['1','+','1']
        String type1 = "";
        String type2 = "";
        try {
            number1 = Integer.parseInt(arrayUserInp[0]);
            type1 = "АРАБ";
        } catch (Throwable e) {
            number1 = romanToArab(arrayUserInp[0]);
            type1 = "РИМ";
        }

        try {
            number2 = Integer.parseInt(arrayUserInp[1]);
            type2 = "АРАБ";
        } catch (Throwable e) {
            number2 = romanToArab(arrayUserInp[1]);
            type2 = "РИМ";
        }

        if (number1 > 10 || number2 > 10) {
            throw new InputMismatchException("не корректное число");
        }

        result = calc(number1, number2, operation);

        if (!type1.equals(type2)) {
            throw new InputMismatchException("Оба числа должны быть арабскими или римскими");
        } else if (type1.equals("РИМ")) {
            String resultRoman = convertNumToRoman(result - 1);
            System.out.println("Ответ: " + resultRoman);
        } else {
            System.out.println("Ответ: " + result);
        }

    }

    private static int romanToArab (String rom){
        return switch (rom) {
            case "I"-> 1;
            case "II"-> 2;
            case "III"-> 3;
            case "IV"-> 4;
            case "V"-> 5;
            case "VI"-> 6;
            case "VII"-> 7;
            case "VIII"-> 8;
            case "IX"-> 9;
            case "X"-> 10;
            default -> throw new InputMismatchException("не корректное число");
        };
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

    private static int calc (int namber1, int namber2, String operator){
        return switch (operator) {
             case "+" -> namber1 + namber2;
             case "-" -> namber1 - namber2;
             case "*" -> namber1 * namber2;
             case "/" -> namber1 / namber2;
             default -> throw new InputMismatchException("не правельный ператор");
        };
    }
}

