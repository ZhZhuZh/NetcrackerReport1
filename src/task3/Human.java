package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Human {
    private Address address;
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

    public String getAddressOfHuman() {
        return address.getAddress();
    }

    public void setAddressForHuman(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        this.age = 2021 - yearOfBirth;
    }

    public static void findByName(Human[] humans, String name) {
        for (Human human : humans) {
            if (human.getName().equals(name)) {
                System.out.println("Information for " + name + ": Year of birth=" + human.getYearOfBirth() + ", Address - " + human.getAddressOfHuman());
            }
        }
    }

    public static void findByAddress(Human[] humans, String address) {
        for (Human human : humans) {
            if (human.getAddressOfHuman().equals(address)) {
                System.out.println("Information for human with adress" + address + ": Year of birth=" + human.getYearOfBirth() + ", Name - " + human.getName());
            }
        }
    }

    public static void findOldest(Human[] humans) {
        String nameOfOldest = "";
        int ageOfOldest = 0;
        for (Human human : humans) {
            if (human.getAge() > ageOfOldest) {
                ageOfOldest = human.getAge();
                nameOfOldest = human.getName();
            }
        }
        System.out.println("The oldest human is " + nameOfOldest + " and his age is " + ageOfOldest);
    }

    public static void findYoungest(Human[] humans) {
        String nameOfYoungest = "";
        int ageOfYoungest = 200;
        for (Human human : humans) {
            if (human.getAge() < ageOfYoungest) {
                ageOfYoungest = human.getAge();
                nameOfYoungest = human.getName();
            }
        }
        System.out.println("The youngest human is " + nameOfYoungest + " and his age is " + ageOfYoungest);
    }

    public static void findByYears(Human[] humans, int firstYear, int lastYear) {
        for (Human human : humans) {
            if (human.getYearOfBirth() > firstYear & human.getYearOfBirth() < lastYear) {
                System.out.println("It's a " + human.getName() + " and he was born in " + human.getYearOfBirth());
            }
        }
    }

    public static void findHumansWithSameAddress(Human[] humans) {
        for (Human human : humans) {
        // не успела :(
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Human[] humans = new Human[5];
        for (int i = 0; i < 5; i++) {
            humans[i] = new Human();
            System.out.println("name " + (i + 1) + " ");
            humans[i].setName(scanner.readLine());
            System.out.println("date");
            humans[i].setYearOfBirth(Integer.parseInt(scanner.readLine()));
            System.out.println("address");
            Address address = new Address(scanner.readLine());
            humans[i].setAddressForHuman(address);
        }

        System.out.println("Please choose one option and enter number of point:");
        System.out.println("1. Find human by name.");
        System.out.println("2. Find human by address.");
        System.out.println("3. Find human who was born between years.");
        System.out.println("4. Find the oldest human");
        System.out.println("5. Find the youngest human");
        System.out.println("6. Find humans living on same address");
        int point = Integer.parseInt(scanner.readLine());
        switch (point) {
            case 1:
                System.out.println("Enter name for search: ");
                findByName(humans, scanner.readLine());
                break;
            case 2:
                System.out.println("Enter address for search: ");
                findByAddress(humans, scanner.readLine());
                break;
            case 3:
                System.out.println("Enter first year and last year: ");
                findByYears(humans, Integer.parseInt(scanner.readLine()), Integer.parseInt(scanner.readLine()));
                break;
            case 4:
                findOldest(humans);
                break;
            case 5:
                findYoungest(humans);
                break;
            case 6:
                findHumansWithSameAddress(humans);
                break;
        }

    }
}
