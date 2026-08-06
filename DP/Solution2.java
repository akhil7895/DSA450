import java.util.*;
// 0 - 1 Knapsack Problem
// Difficulty: MediumAccuracy: 31.76%Submissions: 606K+Points: 4
// Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively, and an integer W representing the maximum capacity of the knapsack (the total weight it can hold).
// The task is to put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.
// Note: You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. Each item is available only once.
// Examples :
// Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
// Output: 3
// Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
// Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] 
// Output: 0
// Explanation: Every item has a weight exceeding the knapsack's capacity (3).
// Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] 
// Output: 80
// Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.

public class Solution2 {

    public static int knapSack(int W , int val[] , int capa[]){
        int n = val.length;
        int [][] dp = new int[n+1][W+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);            
        }
        return knapSackMemo(W,val,capa,n,dp);
    }
    

    public static int knapSackMemo(int capa,int val[] , int wt[] , int i , int[][] dp){

        if(i==0 || capa == 0) return 0;
        if(dp[i][capa] != -1) return dp[i][capa];
        int pick = 0;

        if(wt[i-1] < capa) {
            pick = val[i-1] + knapSackMemo(capa-val[i-1], val, wt, i-1, dp);
        }
        int skip = knapSackMemo(capa, val, wt, i-1, dp);
        return dp[i][capa] = Math.max(pick,skip);


    }
    
    public static void main(String[] args) {
        int [] val = {1,2,3};
        int [] wt = {4,5,1};
        System.out.println(knapSack(4,val,wt ));
    }
}
