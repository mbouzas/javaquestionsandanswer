package com.questionsandanswers.java;

class Base {
    public void foo() { System.out.println("Base"); }
}

class Derived extends Base {
    public void foo() { System.out.println("Derived"); }

    public static void main(String args[]) {
        Base b = new Derived();
        b.foo();
    }
}


