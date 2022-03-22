/* QuickSortDemo Project
 *
 * CSCI 112 - Spring 2020
 *
 * This code provides an example of quicksort.  The method partion() chooses the
 * middle element as a pivot, then splits a set of integers into a low end set
 * with each elelment <= the pivot and a high end set with
 * each element >=  the pivot.
 *
 * This process is repeated recusively for the left and right sets until all
 * elelments are in order.
 *
 * To pick a pivot randomly, change line 34 to be:
 *        pivot index = startIndex + (int)(Math.random() * ((EndIndex- StratIndex) + 1))
 *
 * last edited April 8, 2020 by C. Nelson
 */


package com.craiganelson;

public class Main

{  // Start Main Class

    public static void main(String[] args)

    {  // Start main(String[] args)

        QuickSortDemo ();


    }   // End main(String[] args)



    public static void  QuickSortDemo ()
    { // Start QuickSortDemo()


        /* a sample 20-element array is hardcoded here.
         * You can replace this with code to read data from a file
         */
        int[] a = {14, 22, 99, 50, 30, 46, 3, 60, 35, 42, 21, 38, 79, 58, 18, 27, 6, 49, 17, 47};

        // print the array before sorting
        // you might want to change this for long arrays
        System.out.println("Here is the array before sorting:");
        printtArray(a);

        // start the sort on the entire array -- a[0] to a[length-1]
        quickSort(a, 0, a.length - 1);

        // print the array after sorting
        // remove this for very large arrays
        System.out.println("Here is the array after sorting:");
        printtArray(a);

    } // QuickSortDemo
    //************************************************************************


    // a method to print the elements of an integer array on one line
    public static void printtArray(int[] a)
    { // Start printtArray(int[] a)

        // iterate and print the array on one line
        for (int i = 0; i < a.length; i++)
        {  // Start for (int i = 0; i < a.length; i++)

            System.out.print(a[i] + " ");

        }  // End for (int i = 0; i < a.length; i++)

        System.out.println();

    } // end printArray()
    //************************************************************************


    // the recursive quicksort method, which calls the partition method
    public static void quickSort(int[] a, int startIndex, int endIndex)
    {  // Start quickSort(int[] a, int startIndex, int endIndex)

        int pivotIndex;      // the index of pivot returned by the quicksort partition

        // if the set has more than one element, then partition
        if (startIndex < endIndex)
        {  // Start if (startIndex < endIndex)

            // partition and return the pivotIndex
            pivotIndex = partition(a, startIndex, endIndex);
            // quicksort the low set
            quickSort(a, startIndex, pivotIndex - 1);
            // quiclsort the high set
            quickSort(a, pivotIndex + 1, endIndex);

        } // Start if (startIndex < endIndex)

    } // End quickSort(int[] a, int startIndex, int endIndex)


    //************************************************************************

    // This method performs quicksort partitioning on a set of elements in an array.
    public static int partition(int[] a, int startIndex, int endIndex)
    { // Start partition(int[] a, int startIndex, int endIndex)


        int pivotIndex;             // the index of the chosen pivot element
        int pivot;                  // the value of the chosen pivot
        int midIndex = startIndex;  // boundary element between high and low sets

        // select the center element in the set as the pivot by integer averaging
        pivotIndex = (startIndex + endIndex) / 2;
        pivot = a[pivotIndex];

        // put the pivot at the end of the set so it is out of the way
        swap(a, pivotIndex, endIndex);

        // iterate the set, up to but not including last element
        for (int i = startIndex; i < endIndex; i++)
        { // Start for (int i = startIndex; i < endIndex; i++)

            // if a[i] is less than the pivot
            if (a[i] < pivot)
            {  // Start if (a[i] < pivot)


                // put a[i] in the low half and increment current Index
                swap(a, i, midIndex);
                midIndex = midIndex + 1;

            }  // End if (a[i] < pivot)

        } // End for (int i = startIndex; i < endIndex; i++)

        // partitioning complete -- move pivot from end to middle
        swap(a, midIndex, endIndex);

        // return index of pivot
        return midIndex;

    } // Start partition(int[] a, int startIndex, int endIndex)
    //************************************************************************

    // This method swaps two elements in an integer array
    public static void swap(int[] a, int first, int second)
    {  // Begin swap(int[] a, int first, int second)

        int c;  // a catalyst variable used for the swap

        c = a[first];
        a[first] = a[second];
        a[second] = c;

    }  // Begin swap(int[] a, int first, int second)
    //************************************************************************

} // End  Main Class


