package task3;

import java.util.ArrayList;
import java.util.Scanner;

public class Human {
    private Adress adress;
    private int age;
    private int yearOfBirth;
    private String name;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getAdressOfHuman() {
        return adress.getAdress();
    }

    public void setAdressForHuman(Adress adress) {
        this.adress = adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        this.age = 2021 - yearOfBirth;
    }

    public static void findByName (Human[] humans, String name) {
        for (Human human : humans) {
            if (human.getName() == name){
                System.out.println("Information for " + name + ": Year of birth=" + human.getYearOfBirth() + ", Adress - " + human.getAdressOfHuman());
            }
        }
    }

    public static void findByAdress (Human[] humans, String adress) {
        for (Human human : humans) {
            if (human.getAdressOfHuman() == adress){
                System.out.println("Information for human with adress" + adress  + ": Year of birth=" + human.getYearOfBirth() + ", Name - " + human.getName());
            }
        }
    }
    public static void findOldest (Human[] humans) {
        String nameOfOldest = "";
        int ageOfOldest=0;
        for (Human human : humans){
            if (human.getAge()>ageOfOldest) {
                ageOfOldest = human.getAge();
                nameOfOldest = human.getName();
            }
        }
        System.out.println("The oldest human is " + nameOfOldest + " and his age is " + ageOfOldest);
    }

    public static void findYoungest (Human[] humans) {
        String nameOfYoungest = "";
        int ageOfYoungest = 200;
        for (Human human : humans){
            if (human.getAge()<ageOfYoungest) {
                ageOfYoungest = human.getAge();
                nameOfYoungest = human.getName();
            }
        }
        System.out.println("The youngest human is " + nameOfYoungest + " and his age is " + ageOfYoungest);
    }

    public static void findByYears (Human[] humans, int firstYear, int lastYear) {
        for (Human human : humans) {
            if (human.getYearOfBirth()>firstYear & human.getYearOfBirth()<lastYear) {
                System.out.println("It's a " + human.getName() + " and he was born in " + human.getYearOfBirth());
            }
        }
    }
    public static void findHumansWithSameAdress(Human[] humans) {
        for (Human human : humans) {

        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Human[] humans = new Human[5];
        for (int i=0; i<6; i++) {
            //System.out.println("Enter name, year of birth and adress for human " + (i+1) + ": ");
            System.out.println("name 1 ");
            humans[i].setName(scanner.nextLine());
            System.out.println("date");
            humans[i].setYearOfBirth(scanner.nextInt());
            Adress adress = new Adress(scanner.nextLine());
            System.out.println("adress");
            humans[i].setAdressForHuman(adress);
        }
        while (true) {
            System.out.println("Please choose one option and enter number of point:");
            System.out.println("1. Find human by name.");
            System.out.println("2. Find human by adress.");
            System.out.println("3. Find human who was born between years.");
            System.out.println("4. Find the oldest human");
            System.out.println("5. Find the youngest human");
            System.out.println("6. Find humans living on same adress");
            int point = scanner.nextInt();
            switch (point) {
                case 1:
                    System.out.println("Enter name for search: ");
                    findByName(humans, scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Enter adress for search: ");
                    findByAdress(humans, scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Enter first year and last year: ");
                    findByYears(humans, scanner.nextInt(), scanner.nextInt());
                    break;
                case 4:
                    findOldest(humans);
                    break;
                case 5:
                    findYoungest(humans);
                    break;
                case 6:
                    findHumansWithSameAdress(humans);
                    break;
            }
        }
    }
}
