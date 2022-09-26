package com.edjavapractice.mortgagecalc;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        String principalInput = scanner.next();
        System.out.print("Annual Interest Rate: ");
        String interestInput = scanner.next();
        System.out.print("Period (Years): ");
        String yearsInput = scanner.next();
        int principal = Integer.parseInt(principalInput);
        float yearlyInterest = Float.parseFloat(interestInput);
        int periods = Integer.parseInt(yearsInput) * MONTHS_IN_YEAR;
        float monthlyInterestRate = yearlyInterest / PERCENT / MONTHS_IN_YEAR;
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