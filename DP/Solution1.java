import java.util.*;

// Coin Change (Count Ways)
// Solved
// Difficulty: MediumAccuracy: 43.1%Submissions: 325K+Points: 4
// Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ]. 
// Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
// Answers are guaranteed to fit into a 32-bit integer. 

// Examples:

// Input: coins[] = [1, 2, 3], sum = 4
// Output: 4
// Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].
// Input: coins[] = [2, 5, 3, 6], sum = 10
// Output: 5
// Explanation: Five Possible ways are: [2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5].
// Input: coins[] = [5, 10], sum = 3
// Output: 0
// Explanation: Since all coin denominations are greater than sum, no combination can make the target sum.
// Constraints:
// 1 <= sum <= 103
// 1 <= coins[i] <= 104
// 1 <= coins.size() <= 103

public class Solution1 {
    public static void main(String[] args) {
        int[] arr = {2,5,3,6};
        int sum = 10;
        System.out.println(count(arr,sum));
        System.out.println(countDP(arr,sum));
        System.out.println(countDpTabulation(arr,sum));
    }

    //Recursive Solution
    public static int count(int[] arr, int sum){
        int n = arr.length;
        return countRec(arr,n,sum);
    }

    public static int countRec(int[] arr, int i,int sum){
        if(sum == 0 ) return 1;
        if(sum<0 || i ==0) return 0;

        return countRec(arr, i, sum - arr[i-1]) + countRec(arr, i-1, sum);
    }

    //Memoization
    public static int countDP(int [] arr, int sum ){
        int n = arr.length;
        int[][] dp = new int[n][sum+1];
        for(int [] num : dp){
            Arrays.fill(num,-1);
        }
        return countDpHelper(arr,sum,dp,n);
    }
    public static int countDpHelper(int arr[] , int sum , int [][] dp,int i){
        if(sum ==0 ) return 1;
        if(sum <0 || i==0) return 0;
        if(dp[i-1][sum] !=  -1) return dp[i-1][sum];
        
        return dp[i-1][sum] = countDpHelper(arr, sum - arr[i-1], dp, i) + 
                            countDpHelper(arr, sum, dp, i-1);
    }

    public static int countDpTabulation(int [] arr , int sum){

        int n = arr.length;
        int [][] dp = new int[n+1][sum+1];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){

                //Add no of ways to make change without using current coin
                dp[i][j] += dp[i-1][j];

                if(j-arr[i-1] >= 0){
                    dp[i][j] += dp[i][j-arr[i-1]];
                }
            }
        }

        return dp[n][sum];
    }
    
}
