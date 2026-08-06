//nPr
public class Solution4 {
    //Using factorial formula
    public static long nPr(int n , int r){
        if(r>n) return 0;
        return fact(n) / fact(n-r);
    }
    public static long fact(int n){
        long res = 1;
        for(int i=2;i<=n;i++){
            res*=i;
        }
        return res;
    }
    //Multiply the required term directly
    public static long nPr2(int n , int r){
        if(r>n) return 0;
        long ans =1;
        for(int i=0;i<r;i++){
            ans *= (n-i);
        }
        return ans;

    }
    public static void main(String[] args) {
        System.out.println(nPr(13, 7));
        System.out.println(nPr2(13, 7));
    }
}
