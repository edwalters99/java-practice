package com.edjavapractice.mortgagecalc;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        int principal;
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= 1_000 && principal <= 1_000_000) {
                break;
            }
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        Float yearlyInterest;
        float monthlyInterestRate;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            yearlyInterest = scanner.nextFloat();
            if (yearlyInterest > 0 && yearlyInterest <= 30) {
                monthlyInterestRate = yearlyInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }

        int years;
        int periods;
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextInt();
            if (years >= 1 && years <= 30) {
                periods = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }


        double mortgagePayment = principal *
                (
                        (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, periods)))
                /
                                ((Math.pow(1 + monthlyInterestRate, periods)) - 1)
        );
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String formattedMortgagePayment = currency.format(mortgagePayment);
        System.out.println("Mortgage: " + formattedMortgagePayment);
    }
}