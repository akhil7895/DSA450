import java.util.*;
public class Solution1 {
    public static void main(String[] args) {
        int[] arr = {2,5,3,6};
        int sum = 10;
        System.out.println(count(arr,sum));
        System.out.println(countDP(arr,sum));
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
    
}
