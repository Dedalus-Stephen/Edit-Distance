public class EditDistance {
    public static void main(String[] args) {
        String s = "perturbation";
        String s1 = "urbanization";

        System.out.println("To make strings equal we need minimum " +
                editDistance(s, s1, s.length(), s1.length())
                + " editions");
    }

    private static int editDistance(String s, String s1, int n, int m) {
        //table to store the results in a bottom-up manner
        int[][] distance = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // if a string is empty, then we need to copy every char from the other string
                if(i == 0) distance[i][j] = j;
                else if(j == 0) distance[i][j] = i;

                // if chars are equal then no operation required
                // i.e we just need to call to the previous result
                else if(s.charAt(i-1) == s1.charAt(j-1)) distance[i][j] = distance[i-1][j-1];

                // if the chars are not equal, we need to take the minimum cost from the three possible operations:
                // 1) remove — distance[i-1][j]
                // 2) replace — distance[i-1][j-1]
                // 3) insert — distance[i][j-1]
                else distance[i][j] = 1 + Math.min(Math.min(distance[i-1][j], distance[i-1][j-1]), distance[i][j-1]);
            }
        }

        // return the builded result (last row, last column) for the full input strings with length n and m
        return distance[n][m];
    }
}

//Complexity: O(n*m)
