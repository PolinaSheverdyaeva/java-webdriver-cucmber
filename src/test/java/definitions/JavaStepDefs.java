package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.*;

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

        switch (site.toLowerCase()) {
            case "google":
                System.out.println("https://www.google.com/");
                break;
            case "youtube":
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
    public void iCallYour(String name) {
        switch (name) {
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
            System.out.printf("%d == %d\n", a, b);

        if (a != b)
            System.out.printf("%d != %d\n", a, b);

        if (a >= b)
            System.out.printf("%d >= %d\n", a, b);

        if (a <= b)
            System.out.printf("%d <= %d\n", a, b);

        if (a > b)
            System.out.printf("%d > %d\n", a, b);

        else if (a > b)
            System.out.printf("%d > %d\n", a, b);
    }



    // day 5 homework
    @Given("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String num) {
        int a = Integer.valueOf(num);
        if (a >= 0)
            System.out.println(a + " is positive number");
        else if (a <= 0)
            System.out.println(a + " is negative number");
    }



    //using arrays
    static String[] alldays = {"Monday","Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    @And("I print {string} days of week using array")
    public void iPrintDaysOfWeekUsingArray(String days) {
        int d = Integer.valueOf(days);

        if (d <= 0 || d > 7) {
            System.out.println(days + " invalid days of week number.");
        }
        for (int i=0; i<d; i++) {
            if(i>0) {
                System.out.print(", ");
            }
            System.out.print(alldays[i]);
        }
        System.out.println();
    }


    @Given("I work with arrays")
    public void iWorkWithArrays() {
        String[] fruits = {"apple", "plum", "kiwi", "orange"};


        System.out.println(fruits[0]);
//        System.out.println(fruits[1]);
//        System.out.println(fruits[3]);

        for (String fruit : fruits) {
            System.out.println(fruit);
        }


        List<String> myFruits = Arrays.asList("apple", "plum", "kiwi", "orange");
        for (String fruit : myFruits) {
            System.out.println(fruit);
        }

        int[] nums = {5, 2, 3, 2, 5};
        for (int number : nums) {
            System.out.println("num " + number);
        }
        List<Integer> myNums = Arrays.asList(5, 2, 3, 2, 5);
        for (int num : myNums) {
            System.out.println("num: " + num);
        }

//        List<String> list = new ArrayList<>();
        List<String> list = Arrays.asList("orange","pear","apple");
//        list.add("orange");
//        list.add("pear");
//        list.add("apple");

        for (String item : list) {
            System.out.println(item);
        }

        for (int i=0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


    }

    @Given("Trying to solve tasks")
    public void tryingToSolveTasks() {
        // Sorting array and moving zeros to the end of the array
        int[] nums = {0,1,0,3,12};
            int n = nums.length;
            int count = 0;
            // Traverse the array. If element encountered is non-zero, then
            // replace the element at index 'count' with this element
            for (int i = 0; i < n; i++){
                if (nums[i] != 0)
                // arr[count++] = arr[i]; // here count is incremented
                swapNumbers(nums,count++,i);
            }
            for (int j = 0; j < n; j++){
                if (j > 0)
                    System.out.print(",");
                System.out.print(nums[j]);
            }
            System.out.println();
        }

        public static void swapNumbers(int [] arr, int pos1, int pos2){
            int temp  = arr[pos2];
            arr[pos2] = arr[pos1];
            arr[pos1] = temp;
        }


    @And("I find element that appears once in array {string}")
    public void iFindElementThatAppearsOnlceInArray(String array) {
        // Return element that appears only once

//        static int findSingle(int nums[])
        {
            String[] elements = array.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
            int[] nums = new int[elements.length];
            for (int i=0; i < elements.length; i++) {
                try {
                    nums[i] = Integer.parseInt(elements[i]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            if (nums.length == 0)
//                return;
                throw new IllegalArgumentException("nums is empty");

            // Do XOR of all elements and return
            int res = nums[0];
            for (int i = 1; i < nums.length; i++) {
                res = res ^ nums[i];
            }

            System.out.println("Element appears once in array is " + res);
        }

    }



    @Given("I work with maps")
    public void iWorkWithMaps() {
        Map<String, String> user = Map.of(
                "username", "jdoe",
                "password", "welcome",
                "email", "john@doe.com"
        );
        Map<String, String> admin = Map.of(
                "username", "admin",
                "password", "pass1",
                "email", "admin@doe.com"
        );
        System.out.println(user);
        System.out.println(admin);
        System.out.println(user.get("username"));
        System.out.println(user.get("password"));
        System.out.println(user.get("email"));


//        homework6
        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName","John");
        info.put("middleName", "George");
        System.out.println("Swap of First Name and Middle Name");
        System.out.println("First Name: " + info.get("firstName"));
        System.out.println("Middle Name: " + info.get("middleName"));
        String s = info.get("firstName");
        info.put("firstName", info.get("middleName"));
        info.put("middleName", s);
        System.out.println("Result:");
        System.out.println("First Name: " + info.get("firstName"));
        System.out.println("Middle Name: " + info.get("middleName"));

    }


    @Given("I solve  coding challenges")
    public void iSolveCodingChallenges() {
        //test cases
        swap(3, 5);
        //boundaries
        isDivisibleBy3and4(9);
        isDivisibleBy3and4(8);
        isDivisibleBy3and4(12);
        isDivisibleBy3and4(17);
    }

    //solutions
    void isDivisibleBy3and4(int num){
        System.out.println("Is divisible func " + num);
        boolean isDivBy3 = num % 3 == 0;
        boolean isDivBy4 = num % 4 == 0;
        if (isDivBy3 && isDivBy4) {
            System.out.println("Div by 3 and 4");
        } else if (isDivBy3) {
            System.out.println("Div by 3");
        } else if (isDivBy4) {
            System.out.println("Div by 4");

//        if (num % 3 == 0 && num % 4 == 0){
//            System.out.println("Div by 3 and 4");
//        } else if (num % 3 == 0){
//            System.out.println("Div by 3");
//        } else if (num % 4 == 0){
//            System.out.println("Div by 4");
        } else {
            System.out.println("Not div by 3 and 4");
        }

    }

    void swap(int a, int b){
        System.out.println("Swap func");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a: " + a);
        System.out.println("b: " + b);

    }

    @And("I compute number of trailing zeros in factorials - {string}")
    public void iComputeNumberOfTrailingZerosInFactorials(String input) {
        int factorial = 1;
        for ( int counter = Integer.valueOf(input); counter >= 1; counter-- ) {
            factorial *= counter;
        }
        String sf = "" + factorial;
        int res = 0;
        for (int i = sf.length() - 1; i >= 0; i--) {
            if (sf.charAt(i) != '0') {
                break;
            }
            res++;
        }
        System.out.println("Factorial trailing zeros count: " + res);
    }
}