import java.util.*;

public class Combinations {
    public void getCombinations(ArrayList<ArrayList<Integer>> arr,Integer[]data, int index,int n,int k,int i){
        if(index==k) {

           List<Integer> list= Arrays.asList(data);
            arr.add(new ArrayList<>(list));
            return;
        }
        if(i>n)
            return;
        data[index]=i;
        getCombinations(arr,data,index+1,n,k,i+1);
        getCombinations(arr,data,index,n,k,i+1);
    }

    public ArrayList<ArrayList<Integer>> solve(int n , int k){

        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();

        getCombinations(arr,new Integer[k],0,n,k,1);

        return arr;

    }
    public static void main(String args[]){
        Combinations combinations=new Combinations();
        ArrayList<ArrayList<Integer>> arr= combinations.solve(4,2);
        for(ArrayList<Integer>i:arr){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
