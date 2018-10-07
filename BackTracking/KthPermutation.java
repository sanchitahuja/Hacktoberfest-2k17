import java.util.ArrayList;

public class KthPermutation {
    int []factorial;
    public void generateFactorial(int n){
        factorial=new int[n+1];
        factorial[0]=1;factorial[1]=1;
        for (int i = 2; i <=n ; i++) {
            factorial[i]=i*factorial[i-1];
        }
    }
    public String getPermuation(ArrayList<Integer> num, int k){
        int n=num.size();
        if(n==0)
            return "";
        if(k>factorial[n])
            return "";
        int position=k/factorial[n-1];
        k=k%factorial[n-1];
        int x=num.remove(position);
        return String.valueOf(x)+getPermuation(num,k);
    }
    public String solve(int n,int k){
        generateFactorial(n);
        ArrayList<Integer>arr=new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            arr.add(i);
        }
        return getPermuation(arr,k-1);
    }
    public static void main(String args[]){
        KthPermutation k=new KthPermutation();
       System.out.println( k.solve(11,1));
    }

}
