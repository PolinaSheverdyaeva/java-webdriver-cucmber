package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.Collections;

public class JavaStepDefs {
    @Given("I say hello world")
    public void iSayHelloWorld() {
        System.out.println("Hello World!");

        String var1;
        var1 = "Hello World!";
        System.out.println(var1);

        String firstName = "Slava";
        String lastName = "Skryabin";

        System.out.println("Full name: " + firstName + " " + lastName);
        System.out.println(firstName.toUpperCase());
        System.out.println(firstName.length());


    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println("Simon says " + message);


    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {

        System.out.println(this);

//        Collections.copy(null, null);

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
        System.out.println(10.0 / 3);
    }

    @Given("I print url for {string} page")
    public void iPrintUrlForPage(String site) {

        switch (site.toLowerCase()){
            case "google":
                System.out.println("https://www.google.com/");
                break;
            case "yo utube":
                System.out.println("https://www.youtube.com/");
                break;
            case "yahoo":
                System.out.println("https://www.yahoo.com/");
                break;
            case "sample":
                System.out.println("https://skryabin.com/webdriver/html/sample.html");
                break;
                default:
//                    System.out.println("Not supported site! Actual: " + site);
                    throw new RuntimeException("Not supported site! Actual: " + site);



//
//        if (site.equalsIgnoreCase("google")) {
//            System.out.println("https://www.google.com/");
//        } else if (site.equalsIgnoreCase("sample")) {
//            System.out.println("https://skryabin.com/webdriver/html/sample.html");
//        } else
//            {
//            System.out.println("Not supported site! Actual: " + site);
        }
    }

    @And("I {string}")
    public void iTypeMyText(String myText) {

        System.out.println(myText);
    }


    @When("I count to {string}")
    public void iCountTo(String limit) {

        int lim = Integer.valueOf(limit); //conversion of string to integer
        for (int counter = 1; counter <= lim; counter++)
            System.out.printf("%d ", counter);

        System.out.println();
    }

    @When("I call you {string}")
    public void iCallYour(String name)
    {
        switch(name)
        {
            case "Polina":
                System.out.println("Hello, Polina!:)");
                break;
            case "Katya":
                System.out.println("Hello, Katya!:)");
                break;
                default:
                    throw new RuntimeException("I don't know you, " + name + "!");
        }
    }

    @Given("I perform actions with  numbers {string} and {string}")
    public void iPerformActionsWithNumbersAnd(String number1, String number2) {

        int a = Integer.valueOf(number1); //conversion of string to integer
        int b = Integer.valueOf(number2);

        if (a == b) // declare an if statement to determine if num1 and num2 equal
            System.out.printf( "%d == %d\n", a, b );

        if (a != b)
            System.out.printf( "%d != %d\n", a, b );

        if (a >= b)
            System.out.printf( "%d >= %d\n", a, b );

        if (a <= b)
            System.out.printf( "%d <= %d\n", a, b );

        if (a > b)
            System.out.printf( "%d > %d\n", a, b );

        else if (a > b)
        System.out.printf( "%d > %d\n", a, b );
    }
}