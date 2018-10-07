import java.util.ArrayList;
import java.util.Comparator;

public class Subsets {

  int length;
  static   ArrayList<ArrayList<Integer>>arr;
    public  void gen(ArrayList<Integer>A,int n,ArrayList<Integer>B){
        if(n>=B.size()){
            arr.add(A);
        }
        else{
            ArrayList<Integer>a1=new ArrayList<>(A);
            ArrayList<Integer>a2=new ArrayList<>(A);
            a2.add(B.get(n));
            gen(a1,n+1,B);
            gen(a2,n+1,B);


        }
    }
    public  ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer>A){
        length=A.size();
        arr=new ArrayList<ArrayList<Integer>>();
        gen(new ArrayList<>(),0,A);

        arr.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size()==0)
                    return -1;
                if(o2.size()==0)
                    return 1;
                int i=0;
                while (i<o1.size()&&i<o2.size()){
                    if(o1.get(i).equals(o2.get(i))){
                        i++;
                        continue;
                    }
                    return o1.get(i)-o2.get(i);
                }
                if(i>=o1.size())
                    return -1;

                return 1;
            }
        });
        return arr;
    }

    public static void main(String args[]){
        ArrayList<Integer>A=new ArrayList<>();
        A.add(11);
        A.add(16);
        A.add(15);
        A.add(5);
        Subsets subsets=new Subsets();
        ArrayList<ArrayList<Integer>> B=subsets.getSubsets(A);
        for(ArrayList<Integer>i:B){
            for (int j:i)
                System.out.print(j+" ");
            System.out.println();
        }

    }
}
