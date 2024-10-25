import java.util.Scanner;
import java.util.Random;

public class MergeBubble {

    // Random integers
    public static int[] createRandomArray(int length) {
        int[] array = new int[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = rand.nextInt(101); // Numbers between 0 and 100
        }
        return array;
    }

    // Bubble Sort 
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements if wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Divide left and right
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge 
            merge(array, left, mid, right);
        }
    }

    // Helper function to merge two halves for Merge Sort
    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int length = scanner.nextInt();
        int[] randomArray = createRandomArray(length);

        System.out.println("Choose a sorting method:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Merge Sort");
        int choice = scanner.nextInt();

        if (choice == 1) {
            bubbleSort(randomArray);  // For Bubble Sort
            System.out.println("Array sorted using Bubble Sort.");
        } else if (choice == 2) {
            mergeSort(randomArray, 0, randomArray.length - 1);  // For Merge Sort
            System.out.println("Array sorted using Merge Sort.");
        } else {
            System.out.println("Choose either 1. or 2.");
        }

        System.out.println("Sorted array:");
        for (int num : randomArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();  
    }
}
