// A JAVA code that takes two array with user-inputs and merged them into one and also sort them , then find the median of the sorted,merged array


import java.util.Arrays;
import java.util.Scanner;

class MedianOfArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Merge the arrays
        int mergedSize = nums1.length + nums2.length;
        int[] mergedArray = new int[mergedSize];
        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);

        // Sort the merged array
        Arrays.sort(mergedArray);
        System.out.println("Sorted merged array: " + Arrays.toString(mergedArray));

        // Calculate the median
        double median;
        if (mergedSize % 2 == 0) {
            int mid1 = mergedSize / 2 - 1;
            int mid2 = mergedSize / 2;
            median = (mergedArray[mid1] + mergedArray[mid2]) / 2.0;
        } else {
            int mid = mergedSize / 2;
            median = mergedArray[mid];
        }
        return median;
    }
        public static void main(String[] args){
        MedianOfArray sl= new MedianOfArray();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the first array: ");
        int size1 = scanner.nextInt();
        int[] arr1 = new int[size1];
        System.out.println("Enter " + size1 + " elements for the first array:");
        for (int i = 0; i < size1; i++) {
            arr1[i] = scanner.nextInt();
        }

        // Input for the second array
        System.out.print("Enter the size of the second array: ");
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        System.out.println("Enter " + size2 + " elements for the second array:");
        for (int i = 0; i < size2; i++) {
            arr2[i] = scanner.nextInt();
        }
        
        System.out.print("The Median Of The Sorted Array Will Be : "+sl.findMedianSortedArrays(arr1,arr2));
        
        scanner.close();
        
    }
}