public class TwoPointers {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {1,2,3,4,5};
        int x = 7;
        System.out.println(pairs(a, b, x));
    }

    static int pairs(int[] a, int[] b, int x) {
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = m - 1;
        int count = 0;

        while (i < n && j >= 0) {
            if (a[i] + b[j] <= x) {
                count += j + 1;
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}
