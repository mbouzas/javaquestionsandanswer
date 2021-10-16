import java.util.Arrays;
import java.util.List;

public class CaptureRook {

    public static boolean canCapture(String[] rooks) {
        List<String> a = Arrays.asList(rooks);
        boolean result = false;
        for (char i : a.get(0).toCharArray()){
            result = a.get(1).contains(String.valueOf(i));
            if (result== true)
            break;
        }
        return result;
}


    @org.junit.Test
    public  void capture(){

        System.out.println(canCapture(new String [] {"A8", "E8"}));
    }

}
