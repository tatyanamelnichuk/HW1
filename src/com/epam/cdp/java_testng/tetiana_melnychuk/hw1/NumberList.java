package com.epam.cdp.java_testng.tetiana_melnychuk.hw1;

import java.util.Scanner;

public class NumberList {

    int[] numbers;


    public NumberList() {

    }

    public void calculate() {

        int result;
        float floatResult;
        boolean stop = false;

        Scanner scanner = new Scanner(System.in);
        this.numbers = new int[2];

        while (stop != true) {
            for (int i = 0; i < 2; i++) {
                if (stop != true) {
                    switch (i) {
                        case 0:
                            System.out.println("Type the 1-st number: ");
                            this.numbers[i] = Integer.parseInt(scanner.nextLine());
                            break;
                        case 1:
                            System.out.println("Type the 2-nd number: ");
                            this.numbers[i] = Integer.parseInt(scanner.nextLine());
                            break;
                    }
                } else {
                    stop = true;
                }
            }

            if (stop != true) {
                System.out.println("Choose the math operation:");
                System.out.println("'+' to summarize");
                System.out.println("'-' to deduct");
                System.out.println("'*' to multiply");
                System.out.println("'/' to divide");
                System.out.println("'stop' to exit");
                String mathFunc = scanner.next();

                switch (mathFunc) {
                    case "+":
                        result = this.numbers[0] + this.numbers[1];
                        System.out.println("The sum equals: " + result);
                        break;
                    case "-":
                        result = this.numbers[0] - this.numbers[1];
                        System.out.println("The deduct equals: " + result);
                        break;
                    case "*":
                        result = this.numbers[0] * this.numbers[1];
                        System.out.println("The multiply equals: " + result);
                        break;
                    case "/":
                        floatResult = this.numbers[0] / this.numbers[1];
                        System.out.println("The divide equals: " + floatResult);
                        break;
                    case "stop":
                        stop = true;
                        break;
                    default:
                        System.out.println("There are no such a math operations.");
                        break;
                }
            }
        }
    }

}
