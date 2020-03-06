package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class JavaStepDefs {
    @Given("I say hello world")
    public void iSayHelloWorld() {
         System.out.println("Hello World!");

         String var1;
          var1 = "Hello World!";
          System.out.println(var1);

          String firstName = "Slava";
          String lastName = "Skryabin";

        System.out.println("Full name: "+ firstName + " " + lastName);
        System.out.println(firstName.toUpperCase());
        System.out.println(firstName.length());


    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println("Simon says " + message);


    }

    @Given("I performe actions with {string} and {string}")
    public void iPerformeActionsWithAnd(String str1, String str2) {

        System.out.println("str1: " + str1);
        System.out.println("str1: " + str2);
        System.out.println("str1 upperCase: " + str1.toUpperCase());
        System.out.println("str2 upperCase: " + str2.toUpperCase());
        System.out.println("str1 length: " + str1.length());
        System.out.println("str2 length: " + str2.length());
        System.out.println("str1 equals str2? " + str1.equals(str2));
        System.out.println("str1 equals ignore case str2? " + str1.equalsIgnoreCase(str2));
        System.out.println("str1 contains str2? " + str1.contains(str2));


        String var = "hello";
        System.out.println(var.toUpperCase());

        int i = 5;
        System.out.println("var i = " + i);

        int j = 5;
        System.out.println("var i = " + j);
//        double d =3;
        System.out.println(10.0/3);
    }
}
