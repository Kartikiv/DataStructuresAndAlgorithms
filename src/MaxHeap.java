import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxHeap {
    public List<Integer> heapArray=new ArrayList<>();


    public Boolean  insert( int num){
           if(heapArray.isEmpty()){
               heapArray.add(num);
               return true;
           }
           else{
               heapArray.add(num);
               int i=heapArray.size()-1;
               while(i>0){
                   if(heapArray.get(i/2)<=heapArray.get(i)){
                       //int temp = heapArray.get(i/2);
                       Collections.swap(heapArray , i, i/2);
                   }
                   i=i/2;

               }

           }


    return true;}

    public int delete(){
        int rmv= 0;
        if(heapArray.size()>1) {
         rmv=heapArray.remove(0);
            heapArray.add(0, heapArray.get(heapArray.size()-1));
            heapArray.remove(heapArray.size()-1);
            int i=0;
            while(i<heapArray.size()/2){
                int swapIndex= (i+1)*2 < heapArray.size() ?
                        heapArray.indexOf(Math.max(heapArray.get((i+1)*2-1),
                                                          heapArray.get((i+1)*2) )):
                                               heapArray.indexOf(heapArray.get((i+1)*2-1));
               // System.out.println(rmv);
                if(heapArray.get(swapIndex)>= heapArray.get(i)) {
                    Collections.swap(heapArray, swapIndex, i);
                }
                i=swapIndex;

            }

        }
        else{
            rmv=heapArray.remove(0);
        }
        System.out.println(rmv);
   return rmv; }

    public List<Integer> sortedArray(List<Integer> arrayToBeSorted){
        for (int num : arrayToBeSorted){
            insert(num);
        }
        List<Integer> ans = new ArrayList<>();
        while (!heapArray.isEmpty()){
           ans.add( delete());
        }
    return ans;}
    public List<Integer> getHeapArray(){
        return heapArray;
    }

}
