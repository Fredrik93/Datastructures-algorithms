//Assignment2_group33
import java.util.Arrays;

import static java.util.Arrays.sort;

public class LabSorting {

    /**
     * Private help-method that swaps two elements in an array
     *
     * @param array the array in question
     * @param i     one of the elements to swap
     * @param j     the other element to swap
     */
    private static void swap(int[] array, int i, int j) {
        int x = array[i];
        array[i] = array[j];
        array[j] = x;
    }

    /**
     * Hands on session 2 Exercise 1 Bubble sort
     *
     * @param array the array to sort
     */
    public static void bubbleSort(int[] array) {
        boolean swapped = true;
        for (int i = 0; i < array.length && swapped != false; i++) {
            swapped = false;
            for (int j = 1; j < (array.length - i); j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j, j - 1);
                    swapped = true;
                }
            }
        }
    }

    /**
     * Hands on session 2 Exercise 2 Insertion sort
     *
     * @param array The array to sort
     */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {

            int input = array[i];
            int j = i - 1;

            //changes descending or ascending (<&> input )
            while (j >= 0 && array[j] > input) {

                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = input;

        }
    }

    /**
     * Hands on session 4 & Assignment 2 Question 5 Quicksort
     *
     * @param array the array to sort
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1, false);
    }

    public static void quickSortMedian(int[] array) {
        quickSort(array, 0, array.length - 1, true);
    }

    // Quicksort part of an array
    private static void quickSort(int[] array, int begin, int end, final boolean useMedian) {

        if (begin >= end) {
            return;
        }


        if(useMedian){
            int middle = (begin + end)/ 2;
            int pivot = (begin + end + (middle))/3;

            swap(array,pivot,begin);

        }

        int partitionIndex = partition(array, begin, end);

        quickSort(array, begin, partitionIndex-1,useMedian);
        quickSort(array, partitionIndex+1, end,useMedian);


    }


    private static int partition(int[] array, int begin, int end){

        int pivot = array[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            //sorts in in ascending order
            if (array[j] < pivot) {
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i+1];
        array[i+1] = array[end];
        array[end] = swapTemp;

        return i+1;

    }

    /**
     * Assignment 2 Question 5, Mergesort
     *
     * @param array the array to sort
     */
    public static void mergeSort(int[] array) {
        mergeSorting(array);
    }

    public static int[] mergeSorting(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return array;
        }
        int centre = array.length / 2;
        int[] leftTemp = new int[centre];
        for (int i = 0; i < centre; i++) {
            leftTemp[i] = array[i];
        }
        int[] rightTemp = new int[array.length - centre];
        for (int i = centre, j = 0; i < array.length; i++, j++) {
            rightTemp[j] = array[i];
        }
        leftTemp = mergeSorting(leftTemp);
        rightTemp = mergeSorting(rightTemp);
        array = merge(array, leftTemp, rightTemp);
        return array;
    }


    /**
     * Private help method that merge two sorted arrays into one
     *
     * @param array How far we have got in the result array
     * @param left  How far we have got in the left array
     * @param right How far we have got in the right array
     */
    private static int[] merge(int[] array, int[] left, int[] right) {
        int l = 0, r = 0, a = 0;
        while (a != array.length) {
            if (l == left.length) {
                array[a] = right[r];
                a++;
                r++;
            } else if (r == right.length) {
                array[a] = left[l];
                a++;
                l++;
            } else if (left[l] > right[r]) {
                array[a] = right[r];
                a++;
                r++;
            } else {
                array[a] = left[l];
                a++;
                l++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        // Put code here to try out your algorithms
        int[] actual = {5, 1, 6, 2, 3, 4, 8, 7, 5};

        // Insertion sort
        mergeSort(actual);
        System.out.println(Arrays.toString(actual));
    }
}
