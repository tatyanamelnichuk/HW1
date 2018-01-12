package com.epam.cdp.java_testng.tetiana_melnychuk.hw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DynString {

    String[] setOfStrings;

    DynString() {
        String[] setOfStrings;
    }

    DynString(DynString dynString) {
        this.setOfStrings = dynString.setOfStrings.clone();
    }

    public void getStringFromConsole() {

        //create dynamic list (no bounds)
        ArrayList<String> myStringList = new ArrayList<>();

        int i = 0;
        Scanner scannerString = new Scanner(System.in);
        System.out.println("Type your string (or stop to exit):");
        boolean stop = false;
        while (stop != true) {
            String inputString = scannerString.nextLine();
            if (inputString != null) {
                if ("stop".equals(inputString)) {
                    stop = true;
                } else {
                    myStringList.add(inputString);
                }
            }
        }

        //create result array
        this.setOfStrings = myStringList.toArray(new String[myStringList.size()]);
        System.out.println("The result string array is the following:" + Arrays.toString(this.setOfStrings));
    }

    public void findTheShortestAndLongestStr(DynString dynString) {

        String shortestString = dynString.setOfStrings[0];
        String longestString = dynString.setOfStrings[0];

        for (int i = 0; i < dynString.setOfStrings.length; i++) {
            if (dynString.setOfStrings[i].length() > longestString.length()) {
                longestString = dynString.setOfStrings[i];
            }
        }

        for (int i = 0; i < dynString.setOfStrings.length; i++) {
            if (dynString.setOfStrings[i].length() < shortestString.length()) {
                shortestString = dynString.setOfStrings[i];
            }
        }

        System.out.println("The shortest string is the following: " + shortestString + ". Their length is: " + shortestString.length());
        System.out.println("The longest string is the following: " + longestString + ". Their length is: " + longestString.length());
    }

    public int countStrAverageLength() {

        int length = 0;

        //count string length
        for (int i = 0; i < this.setOfStrings.length; i++) {
            length = length + this.setOfStrings[i].length();
        }

        //count average string
        int averageStrLength = length / this.setOfStrings.length;
        System.out.println("The average string length is: " + averageStrLength);

        return averageStrLength;
    }

    public void findStrWithLargerThanAverageLength(DynString dynString) {

        ArrayList<String> myStringList = new ArrayList<>();
        int averageStrLength = dynString.countStrAverageLength();

        //choose length longer than average
        for (int i = 0; i < dynString.setOfStrings.length; i++) {
            if (dynString.setOfStrings[i].length() > averageStrLength) {
                myStringList.add(dynString.setOfStrings[i]);
            }
        }

        //print results
        if (myStringList.size() != 0) {
            System.out.println("The strings larger than average are the following:");
            for (int i = 0; i < myStringList.size(); i++) {
                System.out.println(myStringList.get(i) + "; length=" + myStringList.get(i).length());
            }
        } else {
            System.out.println("There are no strings larger than average length.");
        }

    }

    public void findStrWithLessThanAverageLength(DynString dynString) {

        ArrayList<String> myStringList = new ArrayList<>();
        int averageStrLength = dynString.countStrAverageLength();
        //choose length less than average
        for (int i = 0; i < dynString.setOfStrings.length; i++) {
            if (dynString.setOfStrings[i].length() < averageStrLength) {
                myStringList.add(dynString.setOfStrings[i]);
            }
        }

        //print results
        if (myStringList.size() != 0) {
            System.out.println("The strings less than average are the following:");
            for (int i = 0; i < myStringList.size(); i++) {
                System.out.println(myStringList.get(i) + "; length=" + myStringList.get(i).length());
            }
        } else {
            System.out.println("There are no strings less than average length.");
        }

    }

    public void findArrWithMinNonRepeatedChars() {

        char[] charArray = null;
        int amountOfUniqueChar = 1;
        int minAmountOfUniqueChar = this.setOfStrings[0].length();
        int stringId = 0;

        for (int i = 0; i < this.setOfStrings.length; i++) {

            //create the char array from the element of the string array
            charArray = new char[this.setOfStrings[i].length()];
            for (int y = 0; y < this.setOfStrings[i].length(); y++) {
                charArray[y] = this.setOfStrings[i].charAt(y);
            }

            //sort the char array ascending
            Arrays.sort(charArray);

            //count the amount of unique chars in the char array
            for (int z = 1; z < charArray.length; z++) {
                if (charArray[z] != charArray[z - 1]) {
                    amountOfUniqueChar++;
                }
            }

            //find the char array with the minimum of the repeated chars in
            if (amountOfUniqueChar < minAmountOfUniqueChar) {
                minAmountOfUniqueChar = amountOfUniqueChar;
                stringId = i;
            }
            amountOfUniqueChar = 1;

        }
        System.out.println("The char array with the minimum of the repeated chars: " + this.setOfStrings[stringId]);
        System.out.println("It has " + minAmountOfUniqueChar + " unique chars.");
    }

    public void findWordConsistOfUniqueChars() {

        char[] charArray;

        for (int i = 0; i < this.setOfStrings.length; i++) {

            //create the char array from the element of the string array
            charArray = new char[this.setOfStrings[i].length()];
            for (int y = 0; y < this.setOfStrings[i].length(); y++) {
                charArray[y] = this.setOfStrings[i].charAt(y);
            }

            //sort the char array ascending
            Arrays.sort(charArray);

            //count the amount of unique chars in the char array
            for (int z = 0; z < charArray.length - 1; z++) {
                if (charArray[z] == charArray[z + 1]) {
                    z = charArray.length - 1;
                    break;
                } else if (z == charArray.length - 1) {
                    System.out.println("There is a first word which consist of unique chars:" + this.setOfStrings[i]);
                    i = this.setOfStrings.length;
                    break;
                }
            }
        }
    }

    public void findSecondWordConsistOfNumbersOnly() {

        char[] numberArray;
        int counter = 0;

        //create the number array from the element of the string array
        for (int i = 0; i < this.setOfStrings.length; i++) {
            numberArray = new char[this.setOfStrings[i].length()];
            for (int y = 0; y < this.setOfStrings[i].length(); y++) {
                if (Character.isDigit(this.setOfStrings[i].charAt(y))) {
                    numberArray[y] = this.setOfStrings[i].charAt(y);
                    if (y == this.setOfStrings[i].length() - 1) {
                        counter++;
                        if (counter == 2) {
                            System.out.println("The second word consists from numbers only is the following" + this.setOfStrings[i]);
                            break;
                        }
                    }
                }
                else {break;}
            }
            }
        if (counter != 2){
            System.out.println("There are no or less than two elements consists from numbers only");
        }
        }
    }
