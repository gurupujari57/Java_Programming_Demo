package org.dsa.slidingWindow;

import java.util.*;

public class MaximumParamSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int window_size = 3;
        int[] result = getMax(arr, window_size);

        // Print the result
        System.out.println(Arrays.toString(result));
    }

    public static int[] getMax(int[] arr, int k) {
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();

        // Use Deque to store indices of elements
        Deque<Integer> deque = new LinkedList<>();

        // Loop to traverse the array
        while (j < arr.length) {
            // Remove elements from the back of the deque if they are smaller than the current element
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[j]) {
                deque.pollLast(); // Remove smaller elements as they can't be the max for the current window
            }

            // Add the current index to the deque
            deque.offerLast(j);

            // Once we have processed k elements (size of the window)
            if (j - i + 1 == k) {
                // Add the maximum element of the current window (front of the deque)
                list.add(arr[deque.peekFirst()]);

                // Slide the window by removing the element that is no longer in the window
                if (deque.peekFirst() == i) {
                    deque.pollFirst(); // Remove the element that is out of the window
                }

                // Move the start of the window
                i++;
            }

            // Expand the window by moving j
            j++;
        }

        // Convert list to array and return the result
        int[] result = new int[list.size()];
        for (int index = 0; index < list.size(); index++) {
            result[index] = list.get(index);
        }

        return result;
    }
}
