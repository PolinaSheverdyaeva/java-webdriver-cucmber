package pages;

public class Snake extends Pet {

    @Override
    public void walk() {
        System.out.println(name + " is crawling!");
    }

    public void speak() {
        System.out.println(name + " is hissing!");
    }
}
