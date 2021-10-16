import java.util.*;

public class UseMainCode {



    public int  interNumber (int input1, int input2){


        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for ( Integer i=1 ; i<= input1; i++){
            map.put(i,list);
            map.get(i).add(i*5000);
        }

        for (Integer j = 1; j<=input1; j++){
            for (Integer i= 0; i<50; i++){
                list.add(list.get(list.lastIndexOf(list))+5000 + i+1);
                map.put(j,list);
            }
        }

        return UseMainCode.anyKeyForValue(map,input2).intValue();
    }



    static Integer anyKeyForValue(Map<Integer, List<Integer>> map, Integer value) {
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if(entry.getValue().contains(value)) return entry.getKey();
        }
        return null;
    }

}
