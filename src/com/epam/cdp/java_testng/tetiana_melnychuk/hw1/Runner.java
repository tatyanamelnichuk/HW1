package com.epam.cdp.java_testng.tetiana_melnychuk.hw1;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {

        DynArray dynArray = new DynArray(20);
        System.out.println("Test massive is the following: " + (Arrays.toString(dynArray.myarray)));

        //replace the min positive and max negative elements
        DynArray dynArrayM = new DynArray(dynArray);
        System.out.println("Array where min positive & max negative values are replaced: " + Arrays.toString(dynArrayM.replaceMinAndMax().myarrayM));

        //find the sum of elements with even index in the array
        dynArrayM = new DynArray(dynArray);
        System.out.println("Sum of elements with even index in the array: " + dynArrayM.countSumOfElementsWithEvenIndex());

        //replace negative numbers with zero
        dynArrayM = new DynArray(dynArray);
        System.out.println("Array where negative elements are replaced with zero: " + Arrays.toString(dynArrayM.replaceNegElemWithZero().myarrayM));

        //triple element located before the negative one
        dynArrayM = new DynArray(dynArray);
        System.out.println("Array where element located before the negative one is tripled: " + Arrays.toString(dynArrayM.tripleElementsBeforeNegative().myarrayM));

        //find the difference between average value and min element value
        dynArrayM = new DynArray(dynArray);
        System.out.println("Difference between average value of elements in the array and the min element: " + dynArrayM.difBtwAvrAndMinValues());

        //find elements which have odd index and duplicates:
        dynArrayM = new DynArray(dynArray);
        System.out.println("Array of elements which have odd index and duplicates: " + Arrays.toString(dynArrayM.findElementsWithOddIndexAndDuplicates()));

        //replace odd elements in the array with zero
        dynArrayM = new DynArray(dynArray);
        System.out.println("Array where odd elements replaced with zero: " + Arrays.toString(dynArrayM.replaceOddElementsWithZero().myarrayM));

        //wait for the strings
        DynString dynString = new DynString();
        dynString.getStringFromConsole();

        //find the shortest and the longest strings and type their length
        dynString.findTheShortestAndLongestStr(dynString);

        //find strings which have length larger than average value
        dynString.findStrWithLargerThanAverageLength(dynString);

        //find strings which have length less than average value
        dynString.findStrWithLessThanAverageLength(dynString);

        //find the word in which minimal unique chars
        DynString dynWords = new DynString(dynString);
        dynWords.findArrWithMinNonRepeatedChars();

        //find the word which consists of only unique chars
        dynWords.findWordConsistOfUniqueChars();

        //find the word which consists of numbers only
        dynWords.findSecondWordConsistOfNumbersOnly();

        NumberList numberList = new NumberList();
        numberList.calculate();
    }
}

