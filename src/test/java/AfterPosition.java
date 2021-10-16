import java.util.HashMap;
import java.util.Map;

public class AfterPosition {

    public static String afterPotion(String str) {
        Map<Integer, String> values = new HashMap<>();
        int i =0;
        for (char a : str.toCharArray()){
            if (a == 'A'){

                values.put(i,"A");
                i--;
            }
            if (a == 'B'){

                values.put(i,"B");
                i--;
            }
            i++;
        }



       String digits = str.replace("A","").replace("B","");
        Integer digits2 = Integer.valueOf(digits);

        StringBuilder sbl = new StringBuilder(str);



        //values.entrySet().stream().forEach(e->{

         //int value = str.charAt(e.getKey()-1) + (e.getValue().equals("A")? 1: -1 );
           //System.out.println( "hola" + str.replace(String.valueOf(str.charAt(e.getKey()-1)) , String.valueOf(value)));

        //});
       String str2 = str.replace("A","").replace("B","");

       System.out.println("Map" + values);
       char [] str3 = str2.toCharArray();
       int found = 0;

       for (int a =0 ; a < str2.length();a++ ){
           Object val = values.get(a+1);
            if (val != null && val.equals("A")){
               int value =Character.getNumericValue(str3[a])+1;
               str3[a]= (char)(value +'0');
               found++;
           }
           if (val != null && val.equals("B")){
               int value =Character.getNumericValue(str3[a])-1;
               str3[a]= (char)(value +'0');
               found++;
           }

       }

      // for (Integer j : values.entrySet())



       System.out.println(new String(str3));

       return new String(str3);

    }


    @org.junit.Test
        public  void afterPosition1()
        {
        String resullt = AfterPosition.afterPotion("3A78B51");
        String resullt2 = AfterPosition.afterPotion("9999B");

        //String resullt3 =AfterPosition.afterPotion("9A123");
    }

}
