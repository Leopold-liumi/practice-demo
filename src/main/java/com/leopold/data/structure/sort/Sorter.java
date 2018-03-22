package com.leopold.data.structure.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by LIUMI969 on 2018/3/16.
 */
public class Sorter {

    public static int[] originalBubbleSort(int[] elements){

        for (int i = 0; i < elements.length - 1; i++) {

            for (int a = i+1; a < elements.length; a++) {

                if(elements[i] > elements[a]){
                    swap(elements,i,a);
                }
            }
        }

        return elements;
    }


    public static int[] optimizedBubbleSort(int[] elements) {

        for (int i = 0; i < elements.length; i++) {

            for(int j = elements.length-1; j > i; j--){

                if(elements[j] < elements[j-1]){
                    swap(elements,j,j-1);
                }
            }
        }

        return elements;
    }


    public static int[] finalBubbleSort(int[] elements){

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



    public static int[] insertSort(int[] elements){

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




    public static void main(String[] args) {

        int[] elements = new int[10];
        for (int i = 0; i < 10; i++) {
            elements[i] = new Random().nextInt(50);
        }

        printArray(elements);

        printArray(originalBubbleSort(Arrays.copyOf(elements,elements.length)));

        printArray(optimizedBubbleSort(Arrays.copyOf(elements,elements.length)));

        printArray(finalBubbleSort(Arrays.copyOf(elements,elements.length)));

        printArray(insertSort(Arrays.copyOf(elements,elements.length)));
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
