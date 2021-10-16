import java.util.Arrays;

public class BinaryTest
{
    public static String sExpression(String nodes){
        char[] chars = nodes.toCharArray();

        Arrays.sort(chars);
        String sorted = new String(chars);
        String tirm = sorted.replace("(","").replace(")","").replace(",","").trim();

        System.out.println(tirm.trim());
        String finalResult;
        for (char i : tirm.toCharArray()) {
            long count = tirm.chars().filter(ch -> ch ==i).count();
            if (count > 2) {
                return "E1";
            }
            //finalResult = i
        }


        return "";
    }


    @org.junit.Test
    public  void sol()
    {
       String result = BinaryTest.sExpression("(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)");
       System.out.println(result);
    }
}