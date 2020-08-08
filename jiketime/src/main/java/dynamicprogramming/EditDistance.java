package dynamicprogramming;

/**
 * leetcode 72 edit distance
 * word1 -> word2经过增删改步骤（每次只能操作一个字符），最少需要变换多少次
 * 例如：horse -> ros ,删掉h,r,e三个字符就成功变化了
 */
public class EditDistance {
    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.minimumCount("horse", "ros"));
    }

    /**
     * 1.dp状态定义：dp[i][j]表示从字符串1的前i个字符替换成字符串2的前j个字符需要变化的最小次数
     * 2.dp状态方程：dp[i][j]= if str1[i] == str2[j]: dp[i-1][j-1], else :min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1
     * 其中str1[i] == str2[j]表示当前两字符相等，不用做变化，其它的情况分别对应增删改中的一种
     *
     * @param str1
     * @param str2
     * @return
     */
    private int minimumCount(String str1, String str2) {
        char[] strArray1 = str1.toCharArray();
        char[] strArray2 = str2.toCharArray();
        int[][] dp = new int[strArray1.length + 1][strArray2.length + 1];
        for (int i = 0; i <= strArray1.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= strArray2.length; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= strArray1.length; i++) {
            for (int j = 1; j <= strArray2.length; j++) {
                // strArray1[i-1]表示第i个字符，strArray2[j-1]表示第j个字符，对应dp[i][j]
                if (strArray1[i - 1] == strArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // dp[i-1][j]，dp[i][j-1]，dp[i-1][j-1]分别表示经过一次增、删、改得到的结果
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[strArray1.length][strArray2.length];
    }
}
