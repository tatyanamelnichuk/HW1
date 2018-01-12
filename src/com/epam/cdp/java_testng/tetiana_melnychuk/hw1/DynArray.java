package com.epam.cdp.java_testng.tetiana_melnychuk.hw1;

import java.util.ArrayList;

public class DynArray {

    //declare class variables (exemplars);
    int[] myarray; // there is an initial array;
    int[] myarrayM; // there is an array with modifications

    //constructor for array objects
    DynArray(int arraySize) {
        int array[] = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) (Math.random() * 20 - 10);
        }
        this.myarray = array;
    }

    DynArray(DynArray dynArray) {
        this.myarrayM = dynArray.myarray.clone();
    }

    DynArray replaceMinAndMax() {

        int minOfPosValue = 0;
        int minOfPosValueIndex = 0;
        int maxOfNegValue = 0;
        int maxOfNegValueIndex = 0;

        for (int i = 0; i < myarrayM.length; i++) {
            if (myarrayM[i] > 0) {
                minOfPosValue = myarrayM[i];
                minOfPosValueIndex = i;
                break;
            }
        }

        //find the min element of positive values
        for (int i = 0; i < myarrayM.length; i++) {
            if (myarrayM[i] > 0) {
                minOfPosValue = myarrayM[i];
                minOfPosValueIndex = i;
                break;
            }
        }


        for (int i = 0; i < myarrayM.length; i++) {
            if (myarrayM[i] > 0) {
                if (myarrayM[i] < minOfPosValue) {
                    minOfPosValue = myarrayM[i];
                    minOfPosValueIndex = i;
                }
            }
        }
        System.out.println("Min element of positive values is:" + myarrayM[minOfPosValueIndex]);

        //find the max element of negative values
        for (int i = 0; i < myarrayM.length; i++) {
            if (myarrayM[i] < 0) {
                maxOfNegValue = myarrayM[i];
                maxOfNegValueIndex = i;
                break;
            }
        }

        for (int i = 0; i < myarrayM.length; i++) {
            if (myarrayM[i] < 0) {
                if (myarrayM[i] < maxOfNegValue) {
                    maxOfNegValue = myarrayM[i];
                    maxOfNegValueIndex = i;
                }
            }
        }
        System.out.println("Max element of negative values is:" + myarrayM[maxOfNegValueIndex]);

        //replace
        int temp = myarrayM[maxOfNegValueIndex];
        myarrayM[maxOfNegValueIndex] = myarrayM[minOfPosValueIndex];
        myarrayM[minOfPosValueIndex] = temp;
        return DynArray.this;
    }

    public int countSumOfElementsWithEvenIndex() {
        int sum = 0;
        for (int i = 0; i < myarrayM.length; i = i + 2) {
            sum = sum + myarrayM[i];
        }
        return sum;
    }

    DynArray replaceNegElemWithZero() {

        for (int i = 0; i < myarrayM.length; i++) {
            if (myarrayM[i] < 0) {
                myarrayM[i] = 0;
            }
        }
        return DynArray.this;
    }

    DynArray tripleElementsBeforeNegative() {

        for (int i = 1; i < myarrayM.length; i++) {
            if (myarrayM[i] < 0) {
                if (myarrayM[i - 1] >= 0 && i != 0) {
                    myarrayM[i - 1] = myarrayM[i - 1] * 3;
                }

            }
        }
        return DynArray.this;
    }

    public double difBtwAvrAndMinValues() {

        double avr = 0;
        int min = 0;
        //find average value
        for (int i = 0; i < myarrayM.length; i++) {
            avr += myarrayM[i];
        }
        avr = avr / myarrayM.length;

        //find min value
        min = myarrayM[0];
        for (int i = 1; i < myarrayM.length; i++) {
            if (myarrayM[i] < min) {
                min = myarrayM[i];
            }
        }

        //find difference
        double dif = avr - (double) min;
        return dif;
    }

    public Integer[] findElementsWithOddIndexAndDuplicates() {

        //create dynamic list (no bounds)
        ArrayList<Integer> myList = new ArrayList<Integer>();

        //find repeated elements with odd index and place them to the list
        for (int i = 0; i < myarrayM.length; i++) {
            if (i % 2 != 0) {
                for (int y = 0; y < myarrayM.length; y++) {
                    if (i != y) {
                        if (myarrayM[i] == myarrayM[y]) {
                            myList.add(myarrayM[i]);
                            break;
                        }
                    }
                }
            }
        }

        //create resultArray and place List's values to it
        Integer resultArray[] = new Integer[myList.size()];
        return myList.toArray(resultArray);
    }


    DynArray replaceOddElementsWithZero() {

        for (int i = 0; i < myarrayM.length; i++) {
            if (myarrayM[i] % 2 != 0) {
                myarrayM[i] = 0;
            }
        }
        return DynArray.this;
    }
}
