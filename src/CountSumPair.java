import java.util.*;

public class CountSumPair {
    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(3, 4, 5, 6);
        List<Integer> nums2 = Arrays.asList(0, 15, 32, 2000, 15000);
        List<Integer> nums3 = Arrays.asList(1, 1, 10, 32, 41);
        List<Integer> nums4 = Arrays.asList(11, 10, 11, 20, 1, 15, 6);

        System.out.println(countPairs(nums1, 1));  // Expected output: 0
        System.out.println(countPairs(nums2, 15)); // Expected output: 1
        System.out.println(countPairs(nums3, 42)); // Expected output: 2
        System.out.println(countPairs(nums4, 21)); // Expected output: 3
    }

    /**
     * Returns the count of pairs in the list that sum up to X.
     *
     * @param nums The list of numbers.
     * @param X The target sum.
     * @return The count of pairs that sum up to X.
     */
    public static int countPairs(List<Integer> nums, int X) {
        // 'seen' set stores numbers we've processed so far.
        Set<Integer> seen = new HashSet<>();
        int count = 0;

        // For each number in the list
        for (int num : nums) {
            // If the complement of the current number (i.e., X - num) is in 'seen',
            // it means we have a pair that sums up to X.
            if (seen.contains(X - num)) {
                count++;
                // Remove the matched number to ensure it's not used again
                seen.remove(X - num);
            } else {
                // Add the current number to 'seen' as it's now processed.
                seen.add(num);
            }
        }
        // Return the total count of pairs found.
        return count;
    }
}
