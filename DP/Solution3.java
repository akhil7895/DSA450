// nCr
public class Solution3 {
    //Naive Approach
    //TC :- O(n)  SC :- O(1)
    public static int nCr(int n ,int r){
        if(r>n) return 0;
        if(n==r || r==0) return 1;
        return nCr(n-1,r-1) + nCr(n-1,r);
    }

    //Using Factorial formula
    public static int nCr2(int n , int r){
        if(r>n) return 0;
        if(n==r || r==0) return 1;
        return (int)(fact(n) / (fact(r) *fact(n-r)));
    }
    public static long fact(int n){
        long res = 1;
        for(int i=2;i<=n;i++){
            res *=i;
        }
        return res;
    }
    

    //Binomial Cofficient Formula
    //TC :- O(r)  SC :- O(1)
    public static int nCr3(int n ,int r){
        double sum = 1;
        for(int i=1;i<=r;i++){
            sum = sum *(n-r+i)/i;
        }
        return  (int)sum;
    }


    public static void main(String[] args) {
        System.out.println(nCr(13, 7));
        System.out.println(nCr2(13, 7));
        System.out.println(nCr3(13, 7));
    }
    
}
