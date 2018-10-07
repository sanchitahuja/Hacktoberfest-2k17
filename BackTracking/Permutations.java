import java.util.ArrayList;

public class Permutations {

    public  void getPermutations(ArrayList<ArrayList<Integer>>arr,ArrayList<Integer>A){
        if(A.size()==0){
            arr.add(new ArrayList<>());
            System.out.println("Empty added");
            return;
        }

        int num=A.get(0);
        A.remove(0);
        getPermutations(arr,new ArrayList<>(A));
        int tempSize=arr.size();
        for (int i = 0; i <tempSize ; i++) {
            ArrayList<Integer>x=arr.get(i);

            int z=x.size();
            for (int j = 0; j <= z; j++) {
                x.add(j,num);
                arr.add(new ArrayList<>(x));
                x.remove(j);

            }

        }
        for (int i = 0; i < tempSize; i++) {
            arr.remove(0);
        }

    }

    public  ArrayList<ArrayList<Integer>> solve(ArrayList<Integer>A){
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        getPermutations(arr,A);
        return arr;
    }

    public static void main(String args[]){
        Permutations permutations=new Permutations();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        ArrayList<ArrayList<Integer>> arr= permutations.solve(A);
        for(ArrayList<Integer>i:arr){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
