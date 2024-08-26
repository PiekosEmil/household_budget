package com.emilpiekos;

import java.util.Scanner;

public class UsersInOut {

    public static void printOptions() {
        System.out.println("==================");
        System.out.println("Choose option:");
        System.out.println("1 - Insert transaction");
        System.out.println("2 - Update transaction");
        System.out.println("3 - Delete transaction");
        System.out.println("4 - Show all income transactions");
        System.out.println("5 - Show all outgo transactions");
        System.out.println("6 - Exit");
        System.out.println("==================");
    }

    public static void printUpdatingOptions() {
        System.out.println("Choose option:");
        System.out.println("1 - Update id");
        System.out.println("2 - Update type");
        System.out.println("3 - Update description");
        System.out.println("4 - Update amount");
        System.out.println("5 - Update date");
    }

    public static int inputNumber() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static  String inputText() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static void printText(String text) {
        System.out.println(text);
    }
}
