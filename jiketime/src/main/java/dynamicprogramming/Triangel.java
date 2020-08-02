package dynamicprogramming;

/**
 * 三角形最小路径和
 *        2                      2
 *      3   2                    3  2
 *   6    5    4       ====>>>>  6  5  4
 * 4   1   100  101              4  1  100  101
 * 1.状态定义：dp[i,j] 表示第i行第j列的值表示从底部到当前位置的最小路径和
 * 2.dp方程：dp[i,j] = triangel[i,j] + min(dp[i+1, j], dp[i+1, j+1])
 */
public class Triangel {
    public static void main(String[] args) {
        int[][] triangel = new int[][]{{2, 0, 0, 0}, {3, 2, 0, 0}, {6, 5, 4, 0}, {4, 1, 100, 101}};
        int row = triangel.length;
        int[][] dp = new int[row][row];
        System.out.println("最小路径和为：" + minPathSum(triangel, dp, row));
    }

    private static int minPathSum(int[][] triangel, int[][] dp, int row) {
        for (int i = row - 2; i >= 0; i--) {
            // 在此题中，当前行数和列数相同
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangel[i][j] + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0] + triangel[0][0];
    }
}
