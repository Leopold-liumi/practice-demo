package com.leopold.data.structure.sort;

import java.util.Arrays;
import java.util.Random;


public class Sorter {

    private static int[] originalBubbleSort(int[] elements){

        for (int i = 0; i < elements.length - 1; i++) {

            for (int a = i+1; a < elements.length; a++) {

                if(elements[i] > elements[a]){
                    swap(elements,i,a);
                }
            }
        }

        return elements;
    }


    private static int[] optimizedBubbleSort(int[] elements) {

        for (int i = 0; i < elements.length; i++) {

            for(int j = elements.length-1; j > i; j--){

                if(elements[j] < elements[j-1]){
                    swap(elements,j,j-1);
                }
            }
        }

        return elements;
    }


    private static int[] finalBubbleSort(int[] elements){

        boolean ascendedOrder = true;
        for (int i = 0; i < elements.length && ascendedOrder; i++) {

            ascendedOrder = false;
            for(int j = elements.length -1; j > i; j--){

                if(elements[j] < elements[j-1]){
                    swap(elements,j,j-1);
                    ascendedOrder = true;
                }
            }

        }

        return elements;
    }



    private static int[] insertSort(int[] elements){

        for (int i = 0; i < elements.length -1; i++) {

            int nextIndex = i + 1;

            if(elements[i] > elements[nextIndex]){

                int tmp = elements[nextIndex];
                elements[nextIndex] = elements[i];

                int minIndex;
                for(minIndex = i - 1; minIndex >= 0 && elements[minIndex] > tmp; minIndex--){
                    elements[minIndex+1] = elements[minIndex];
                }

                elements[minIndex+1] = tmp;
            }

        }

        return elements;
    }


    private static int[] selectSort(int[] elements){

        for (int i = 0; i < elements.length - 1; i++) {

            int minIndex = i;
            for (int a = i+1; a < elements.length; a++) {

                if(elements[i] > elements[a]){
                    minIndex = a;
                }
            }

            if(minIndex != i){
                swap(elements,i,minIndex);
            }
        }

        return elements;
    }


    private static void quickSort(int[] elements,int startIndex,int endIndex){

            int startIndexTemp = startIndex;
            int endIndexTemp = endIndex;
            int pivot = elements[startIndex];

            if(startIndex < endIndex){

                while (startIndex < endIndex){

                    while (startIndex < endIndex && elements[endIndex] > pivot){
                        endIndex --;
                    }
                    if(startIndex < endIndex){
                        elements[startIndex] = elements[endIndex];
                        startIndex ++;
                    }

                    while (startIndex < endIndex && elements[startIndex] < pivot){
                        startIndex ++;
                    }
                    if(startIndex < endIndex){
                        elements[endIndex] = elements[startIndex];
                        endIndex --;
                    }
                }

                elements[startIndex] = pivot;

                quickSort(elements,startIndexTemp,startIndex -1);
                quickSort(elements,startIndex+1,endIndexTemp);
            }

    }





    public static void main(String[] args) {

        int[] elements = new int[10];
        for (int i = 0; i < 10; i++) {
            elements[i] = new Random().nextInt(50);
        }

        printArray(elements);

/*        printArray(originalBubbleSort(Arrays.copyOf(elements,elements.length)));

        printArray(optimizedBubbleSort(Arrays.copyOf(elements,elements.length)));

        printArray(finalBubbleSort(Arrays.copyOf(elements,elements.length)));

        printArray(insertSort(Arrays.copyOf(elements,elements.length)));

        printArray(selectSort(Arrays.copyOf(elements,elements.length)));*/
        int[] quickSortArray = Arrays.copyOf(elements, elements.length);
        quickSort(quickSortArray,0,elements.length-1);
        printArray(quickSortArray);
    }

    public static void printArray(int[] elements){

        System.out.println("-------------------------------");
        for (int element : elements) {

            System.out.println(element);
        }
    }

    public static void swap(int[] elements,int i,int j){
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
