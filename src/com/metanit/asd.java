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
        for (int p = 0; p < userInp.length(); p++){
            switch (String.valueOf(userInp.charAt(p))){
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

        }
        number1 = Integer.parseInt(arrayUserInp[0]); // преобразую строку в целое число но по сути первому переменной присваиваю число с нулевым индексом
        number2 = Integer.parseInt(arrayUserInp[1]);
        result = calc(number1, number2, operation);
        System.out.println(result);
    }

    static int calc (int namber1, int namber2, String operator){
        return switch (operator) {
             case "+" -> namber1 + namber2;
             case "-" -> namber1 - namber2;
             case "*" -> namber1 * namber2;
             case "/" -> namber1 / namber2;
             default -> throw new InputMismatchException("не правельный ператор");
        };
    }
}
