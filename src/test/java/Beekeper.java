import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Beekeper<T> {

    public  static <T>List<T> filterGeneral(List<T> collection, Predicate<T> filter){

        boolean match= false;
        List<T> result = new ArrayList<>();
        for ( T c : collection){

            if (filter.test(c)){
                result.add(c);
            }
        }
        return result;
    }


    @Test
    public void testFilter(){
        List <String> example = Arrays.asList("Beekeper", "Zurich", "Interview");
        Predicate <Integer> predicate = o -> o > 3;
        Predicate <String> predicate2 = o -> o.contains("B");

        List<String> result = Beekeper.filterGeneral(example, predicate2);
        Assert.assertEquals(1,result.size());

    }

}
