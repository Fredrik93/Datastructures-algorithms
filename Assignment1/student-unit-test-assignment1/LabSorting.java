import java.util.Arrays;

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
    throw new UnsupportedOperationException();
  }

  /**
   * Hands on session 2 Exercise 2 Insertion sort
   *
   * @param array The array to sort
   */
  public static void insertionSort(int[] array) {
    throw new UnsupportedOperationException();
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
    // Base case.
    if (begin >= end) {
      return;
    }
    // Use median as pivot
    if (useMedian) {

    }
    // Put the pivot item at begin index

    // int pivot = array[begin];

    // Partition the array.
    int pivotInd = parition(array, begin, end);

    // Now recursively quicksort the two partitions.
    throw new UnsupportedOperationException();
  }

  private static int partition(int[] array, int begin, int end) {
    // Assumes that the pivot is located att array[begin]
    int pivot = array[begin];

    // Move the pivot to the right place
    int pivotInd = 0;
    return pivotInd;
  }

  /**
   * Assignment 2 Question 5, Mergesort
   *
   * @param array the array to sort
   */
  public static void mergeSort(int[] array) {
    // Recursevily mergesort

    // Merge the left and right sub-arrays
    throw new UnsupportedOperationException();
  }

  /**
   * Private help method that merge two sorted arrays into one
   *
   * @param array How far we have got in the result array
   * @param left  How far we have got in the left array
   * @param right How far we have got in the right array
   */
  private static void merge(int[] array, int[] left, int[] right) {

    // Idea: repeatedly copy one element from either the left or right array to the
    // result array.
    throw new UnsupportedOperationException();
  }

  public static void main(String[] args) {
    // Put code here to try out your algorithms
    int[] arr = new int[] { 3, 5, 6, 4, 2, 1 };

    // Insertion sort
    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
