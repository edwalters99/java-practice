package com.edjavapractice.fizzbuzz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Number: ");
        Scanner scanner = new Scanner(System.in);
        int userNum = scanner.nextInt();
        if (userNum % 3 == 0 && userNum % 5 == 0)
            System.out.println("FizzBuzz");
        else if (userNum % 3 == 0)
            System.out.println("Buzz");
        else if (userNum % 5 == 0)
            System.out.println("Fizz");
        else
            System.out.println(userNum);
    }
}
