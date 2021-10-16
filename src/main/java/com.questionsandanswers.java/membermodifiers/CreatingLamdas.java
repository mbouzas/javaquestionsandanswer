package com.questionsandanswers.java.membermodifiers;

public class CreatingLamdas {

    interface Gretting {
        public String sayHello (String g);
    }

    public void testGrettingString(String a , Gretting g) {

        String result = g.sayHello(a);
        System.out.println("Result "+ result);

       }


       public static void  main (String [] args){

        new CreatingLamdas().testGrettingString("Harry", (String a) -> "Hello " + a);

           new CreatingLamdas().testGrettingString("",
                   (String a) -> !a.isEmpty()? "Howdy "+ a:"Did you miss something?");

       }
}
