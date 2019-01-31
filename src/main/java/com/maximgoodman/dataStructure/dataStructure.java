package com.maximgoodman.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dataStructure {

    public static void main(String[] args){

        dataStructure a = new dataStructure();
        int[] randomArray = {10,20,30,40,0};
        //a.randomArray(10);
        //a.mergeSort(randomArray);

        System.out.println(Arrays.toString(randomArray));

        //System.out.println(a.fibonacci(1));

        a.quickSort(randomArray, 0, randomArray.length-1);
    }

    private int[] randomArray(int size){
        int[] randomArray = new int[size];

        for (int i = 0; i<size; i++){
            randomArray[i] = (int) (Math.random()*100);
        }

        return randomArray;
    }

    private void mergeSort(int[] randomList){

        System.out.println("The initial random Array is " + Arrays.toString(randomList));

        int listSize = randomList.length;

        if(listSize<2){
            //handle empty and size one lists. Base case
            return;
        }

        int mid = listSize/2;
        int[] left = new int[mid];
        int[] right = new int[listSize-mid];

        //populate subarrays
        for(int i =0; i<mid; i++){
            left[i] = randomList[i];
        }

        for(int i =0; i<(listSize-mid); i++){
            right[i] = randomList[mid+i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(randomList, left, right, mid, listSize-mid);

    }

    private void merge(int[] randomList, int[] left, int[] right, int leftLimit, int rightLimit){

        //start at the beginning of the arrays (left, right, and random pointers)
        int i = 0, j=0, k=0;

        while(i<leftLimit && j<rightLimit){
            if(left[i]<=right[j]){
                //if the value in the left array is lower than the right, assign the value to the randomList
                randomList[k] = left[i];
                k++;
                i++;
            }
            else{
                //in the case the right array is lower, assign it to the next available index of random
                randomList[k] = right[j];
                k++;
                j++;
            }
        }
        //cleans up extra fragments. Only one of these conditions should execute. It will assign the remaining to
        //the random array
        while(i<leftLimit){
            randomList[k]=left[i];
            k++;
            i++;
        }
        while(j<rightLimit){
            randomList[k]=right[j];
            k++;
            j++;
        }
        System.out.println("Left Array is: " + Arrays.toString(left));
        System.out.println("Right Array is: " + Arrays.toString(right));
        System.out.println("Sorted Array is: " + Arrays.toString(randomList));

    }

    private int fibonacci(int iterations){

        if(iterations<1){
            return 0;
        }
        else if(iterations == 1){
            return 1;
        }

        return fibonacci(iterations-1)+fibonacci(iterations-2);

    }

    private void quickSort(int[] array, int lowIndex, int highIndex){

        if(lowIndex<highIndex) {

            int partitionIndex = partition(array, lowIndex, highIndex);

            quickSort(array, lowIndex, partitionIndex - 1);
            quickSort(array, partitionIndex, highIndex);

            System.out.println("The partition value is: " +array[partitionIndex]);
        }
        System.out.println("final sort is: " + Arrays.toString(array));
    }

    private int partition(int[] array, int lowIndex, int maxIndex){

        int pivot = array[maxIndex];
        //the place where the swap will need to take place is always going to be one ahead of the lower index
        int lowerIndex = (lowIndex-1);
        int hold =0;

        for (int j=lowIndex; j<maxIndex; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (array[j] <= pivot)
            {
                //as the current value of array[j] is less than the pivot
                //increase the swap index
                lowerIndex++;

                // swap arr[i] and arr[j]
                hold = array[lowerIndex];
                array[lowerIndex] = array[j];
                array[j] = hold;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        hold = array[lowerIndex+1];
        array[lowerIndex+1] = array[maxIndex];
        array[maxIndex] = hold;

        return lowerIndex+1;

    }
}
