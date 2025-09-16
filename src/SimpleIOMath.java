import java.util.Scanner;

/**
 * Asks the user questions and answers in Michael Jackson song
 * @version 09.17.2025
 * @author Kayla Cao
 */
public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;

    /**
     * Ask the user some questions using Scanner
     */
    public void promptUser() {
        Scanner in = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("Question 1: What is your name? ");
                String nameInput = in.nextLine().trim();
                if (nameInput.isEmpty()) {
                    System.out.println("Please enter a valid input");
                    continue;
                }
                name = nameInput;  // parse and store
                break;
            }
            catch(Exception e){
                System.out.println("Invalid input");
            }
        }

        while(true) {
            try {
                System.out.print("Question 2: How old are you? ");
                String ageInput = in.nextLine().trim();
                if (ageInput.isEmpty()) {
                    System.out.println("Please enter a value");
                    continue;
                }
                age = Integer.parseInt(ageInput);  // parse and store
                if (age > 0) {
                    break;
                }
                else {
                    System.out.println("Age must be greater than zero");
                }
            }
            catch(Exception e){
                System.out.println("Invalid input, enter a valid integer");
            }
        }

        while(true) {
            try {
                System.out.print("Question 3: What is your favorite number? ");
                String favNumInput = in.nextLine().trim();
                if (favNumInput.isEmpty()) {
                    System.out.println("Please enter a value");
                    continue;
                }
                favNumber = Integer.parseInt(favNumInput);  // parse and store
                break;
            }
            catch(Exception e){
                System.out.println("Invalid input, enter a valid integer");
            }
        }
    }

    private int firstPrimeFactor() {
        if (age == 1) {
            return -1;
        }
        if (age % 2 == 0) {
            return 2;
        }
        for  (int i = 3; i <= Math.sqrt(age); i += 2) {
            if (age % i == 0) {
                return i;
            }
        }
        return age; // age is prime
    }

    /**
     * Summarize the conversation
     */
    public void printInfo() {
        System.out.println("Your name is: "+name);
        System.out.println("Your age is: "+age);
        System.out.println("At your next birthday, you will turn "+(age+1) + ".");

        if  (firstPrimeFactor() == -1) {
            System.out.println("1 doesn't have any prime factors.");
        }
        else {
            System.out.println("The first prime factor of " + age + " is: " + firstPrimeFactor());
        }

        System.out.println("Your favorite number is: " + favNumber);
        System.out.println("Your favorite number squared is: " + favNumber * favNumber);
    }

    /**
     * Main method for class SimpleIOMath
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        System.out.println("* Sit yourself down, take a seat *\n" +
                "* All you gotta do is repeat after me *");
        SimpleIOMath simpleIOMath = new SimpleIOMath();
        simpleIOMath.promptUser();
        System.out.println("""
                I'm gonna teach you how to sing it out
                Come on, come on, come on
                Let me tell you what it's all about
                Reading, writing, arithmetic
                Are the branches of the learning tree""");
        simpleIOMath.printInfo();


    }
}