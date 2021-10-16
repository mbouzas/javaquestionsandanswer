import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DifferenceMaxMin {

    public static int differenceMaxMin(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set<Integer> set = new TreeSet<Integer>(list);

        return ((TreeSet<Integer>) set).last()-((TreeSet<Integer>) set).first();
    }

    public static int differenceMaxMin2(int[] arr) {
       Arrays.sort(arr);

        return arr[arr.length-1] -arr[0];
    }

    @org.junit.Test
    public  void difference(){

        int result = DifferenceMaxMin.differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21});
        System.out.println("Result: "+ result);

        int result2 = DifferenceMaxMin.differenceMaxMin2(new int[]{10, 4, 1, 4, -10, -50, 32, 21});
        System.out.println("Result2: "+ result2);

    }


}
