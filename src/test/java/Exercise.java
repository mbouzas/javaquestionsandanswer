import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise {

/*
    Create a function that takes two dates andnd returns the number of days between the first and second date.
*/


   static void  getDays(  ){
       Date d = new Date();
       Date d1 =new Date("June 20, 2019");

    }


    /*Examples

    sharedLetters("house", "home") ➞ "eho"

    sharedLetters("Micky", "mouse") ➞ "m"

    sharedLetters("house", "villa") ➞ ""*/
    public static String sharedLetters(String str1, String str2) {
       List<String> result = new ArrayList<>();
        str1.chars().forEach(i-> {

            int find = str2.indexOf(i);
            if (find>0){

                result.add(String.valueOf(str2.charAt(find)));

            }

        } );

        return result.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining());

    }


    public static int[] solution2(int[] A, int F, int M) {
        // write your code in Java SE 8

        int numberToSplit= ((A.length + F) * M) - (Arrays.stream(A).sum());
        final int missingRoolls = F;

        final int quotient =numberToSplit / missingRoolls;
        final int remainder = numberToSplit % missingRoolls;

        int [] results = new int[missingRoolls];
        for( int i = 0; i < missingRoolls && (quotient>=1 ||quotient<=6); i++ ) {
            results[i] = i < remainder ? quotient + 1 : quotient;
        }
        return results [0]<=0 ? new int []{0}: results;

    }


    @Test
    public void solution () {

        int [] result = Exercise.solution2(new int[]{6,1},1,1);
        result[2]=0;
    }


    public static int solution3(int[] X, int[] Y) {
        // write your code in Java SE 11
        double [] fraction = new double[X.length];
       for (int i =0 ; i< X.length;i++){

                fraction[i] = (double) X[i]/Y[i];

       }

        int count = 0;

        for (int i = 0; i < fraction.length; i++)
            for (int j = i + 1; j < fraction.length; j++)
                if ((fraction[i] + fraction[j]) == 1.0)
                    count++;


         return count;
    }


    @Test
    public void solution31 () {

        int result = Exercise.solution3(new int[]{1,1,2},new int[]{3,2,3});
        result=0;
    }



    static int solution45(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

    @Test
    public void solution312 () {

        int result = Exercise.solution45(955);
        result=0;
    }

}





