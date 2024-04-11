// This JAVA program takes a user-inputed array and also take the target value . Then give the possibile combination of 2 elements from the array that gives the trgeted  value

import java.util.*;

public class TwoSumSolution {
    public static void main(String[] args) {

        //Taking Array Input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Array entered: " + Arrays.toString(array)); // convert inputs in an Array format

        //Taking Targeted Value
        System.out.println("Enter the target value : ");
        int target = sc.nextInt();

        sc.close();

        int[] indices = twoSum(array, target);
        System.out.println("Output: [" + indices[0] + "," + indices[1] + "]");
    }

    public static int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(array[i], i);
        }
        throw new IllegalArgumentException("The Given Target Is Not possible With The Given Array");
    }
}
