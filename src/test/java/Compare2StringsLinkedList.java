import org.w3c.dom.Node;

import java.util.LinkedList;

public class Compare2StringsLinkedList {





    public static void main(String[] args) {

      /*  Input: list1 = g->e->e->k->s->a
        list2 = g->e->e->k->s->b
        Output: -1

        Input: list1 = g->e->e->k->s->a
        list2 = g->e->e->k->s
        Output: 1

        Input: list1 = g->e->e->k->s
        list2 = g->e->e->k->s
        Output: 0*/

        LinkedList list = new LinkedList();


        list.add("g");
        list.add("e");
        list.add("e");
        list.add("k");
        list.add("s");
        list.add("b");

        //System.out.println(list);


        LinkedList list2 = new LinkedList();

        list2.add("b");
        list2.add("a");
        list2.add("e");
        list2.add("k");
        list2.add("s");
        list2.add("a");

        if (list.size()==list2.size()) {
            if (list.equals(list2)) {
                System.out.println("0");
            }
           list.forEach(a->{ int i = compareString(list,list2,a);
               if (i== 1 || i== -1){
                   return;
               }}
           );
        }
        if (list.size()> list2.size()) {
            if (equals((new LinkedList(list.subList(0,list2.size()))), list2)){

              System.out.println("1");
            } else {
                list.forEach(a ->{
                    int i =compareString((LinkedList) list.subList(0,list2.size()),list2,a);
                    if (i== 1 || i== -1){
                        return;
                    }
                });

            }

        }
        if (list2.size()> list.size()) {
            if (equals(list, (new LinkedList(list2.subList(0,list.size()))))){

                System.out.println("-1");
            } else {
                list.forEach(a ->{
                   int i= compareString(list,(LinkedList) list2.subList(0,list.size()),a);
                    if (i== 1 || i== -1){
                        return;
                    }
                });

            }

        }

    }

    private static boolean equals(LinkedList list, LinkedList list2) {
        boolean equal = false;
        if (list.equals(list2)){
           equal = true;

        }
        return equal;
    }

    private static int compareString(LinkedList list, LinkedList list2, Object a) {
        int i = list.indexOf(a);
        if (list.get(i).toString().compareTo(list2.get(i).toString())>0)
        {
            System.out.println("-1");
            return -1;

        }else
        if (list.get(i).toString().compareTo(list2.get(i).toString())<0){
            System.out.println("1");
            return 1;
        }
        return 0;
    }
}
