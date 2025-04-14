//This algorithm finds the missing int in a sorted and unsorted array
public class MissingInteger {
    public static void main(String[] args) {
        int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        // System.out.println("Missing num is: " + findMissingSorted(nums));
        System.out.println("Missing num is: " + findMissingUnsorted(nums));
    }

    // Sorted array [S1]
    static int findMissingSorted(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    static int binarySearch(int[] nums, int i, int j) {
        if (i > j) {
            return i + 1;
        }
        int mid = (i + j) / 2;
        if (nums[mid] == mid + 1) {
            return binarySearch(nums, mid + 1, j);
        } else {
            return binarySearch(nums, i, mid - 1);
        }
    }

    // Unsorted array [S2]
    static int findMissingUnsorted(int nums[]) {
        int[] correctIndex = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            correctIndex[nums[i]] = nums[i];
        }
        for (int i = 0; i < correctIndex.length; i++) {
            if (correctIndex[i] != i) {
                return i;
            }
        }
        return 0;
    }
}
