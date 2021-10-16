import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsecutiveNumbers {


    public static boolean cons(int[] arr) {
        List<Integer> lst = IntStream.of(arr).boxed().collect(Collectors.toList());
        Collections.sort(lst);
        boolean consecutive = true;
        for (int i =0 ; i<lst.size()-1;i++){
            if(lst.get(i+1)- lst.get(i)!=1){
                consecutive= false;
            }
        }
        return consecutive;
    }



    @org.junit.Test
    public  void conse() {
        boolean result = ConsecutiveNumbers.cons(new int []{5, 1, 4, 3, 2});
        System.out.println(result);
       // cons([5, 1, 4, 3, 2, 8]);
       // cons([5, 6, 7, 8, 9, 9]);
    }
}
