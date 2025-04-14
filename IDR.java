// given two strings, try to make str1 same as str2 with least possible moves (insert, delete, replace) using DP
public class IDR {
    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        int[][] c = idrTable(s1, s2);
        print2DArray(c);
        System.out.println("Edit Distance: " + c[s1.length()][s2.length()]);
    }

    static int[][] idrTable(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] c = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            c[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            c[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1];
                } else {
                    int insert = c[i][j - 1];
                    int delete = c[i - 1][j];
                    int replace = c[i - 1][j - 1];
                    c[i][j] = 1 + Math.min(Math.min(insert, delete), replace);
                }
            }
        }
        return c;
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