package string;

public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        StringBuilder[][] dp = new StringBuilder[str1.length() + 1][str2.length() + 1];
        dp[str1.length()][str2.length()] = new StringBuilder("");
        for (int i = str1.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            sb.append(str1.charAt(i));
            sb.append(dp[i + 1][str2.length()]);
            dp[i][str2.length()] = sb;
        }
        for (int i = str2.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2.charAt(i));
            sb.append(dp[str1.length()][i + 1]);
            dp[str1.length()][i] = sb;
        }
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str1.charAt(i));
                    sb.append(dp[i + 1][j + 1]);
                    dp[i][j] = sb;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str1.charAt(i));
                    if (dp[i + 1][j].length() < dp[i][j + 1].length()) {
                        sb.append(dp[i + 1][j]);
                    } else if (dp[i + 1][j].length() > dp[i][j + 1].length()) {
                        sb.append(dp[i][j + 1]);
                    } else {
                        sb.append(dp[i + 1][j]);
                    }
                    dp[i][j] = sb;

                }
            }
        }

        return dp[0][0].toString();

        // String ans = shortestCommonSupersequenceUtil(str1,str2,0,0,dp);
        // return ans;
    }

    public String shortestCommonSupersequenceUtil(String str1, String str2, int i, int j, String[][] dp) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (i == str1.length()) {
            return dp[i][j] = str2.substring(j, str2.length());
        }
        if (j == str2.length()) {
            return dp[i][j] = str1.substring(i, str1.length());
        }
        StringBuilder sb = new StringBuilder();
        if (str1.charAt(i) == str2.charAt(j)) {
            sb.append(str1.charAt(i));
            sb.append(shortestCommonSupersequenceUtil(str1, str2, i + 1, j + 1, dp));
            return dp[i][j] = sb.toString();
        } else {
            String s1 = str1.charAt(i) + shortestCommonSupersequenceUtil(str1, str2, i + 1, j, dp);
            String s2 = str2.charAt(j) + shortestCommonSupersequenceUtil(str1, str2, i, j + 1, dp);
            if (s1.length() < s2.length()) {
                return dp[i][j] = s1;
            }
            return dp[i][j] = s2;
        }
    }

    public static void main(String[] args) {
        String s1 = "abac";
        String s2 = "cab";
        ShortestCommonSupersequence s = new ShortestCommonSupersequence();
        System.out.println(s.shortestCommonSupersequence(s1, s2));
    }

}
