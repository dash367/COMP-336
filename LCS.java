// find longest common subsequence between two strings using DP
public class LCS {

    public static void main(String[] args) {
        String s1 = "ABCBDAB";
        String s2 = "BDCABA";
        int[][] c = lcsTable(s1, s2);
        System.out.println("All possible LCSs:");
        printAllLCS(c, s1, s2, s1.length(), s2.length(), "");
        System.out.println();
        print2DArray(c);
    }

    static int[][] lcsTable(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] c = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c;
    }

    static void printAllLCS(int[][] c, String s1, String s2, int i, int j, String current) {
        if (i == 0 || j == 0) {
            System.out.println(current);
            return;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            printAllLCS(c, s1, s2, i - 1, j - 1, s1.charAt(i - 1) + current);
        } else {
            if (c[i - 1][j] >= c[i][j - 1]) {
                printAllLCS(c, s1, s2, i - 1, j, current);
            }
            if (c[i][j - 1] >= c[i - 1][j]) {
                printAllLCS(c, s1, s2, i, j - 1, current);
            }
        }
    }

    public static void print2DArray(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}