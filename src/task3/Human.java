package task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;



public class Human {
    private Address address;
    private int age;
    private int yearOfBirth;
    private String name;
    private String last_name;


    public String getName() {
        return name;
    }

    public String getLastName() {
        return last_name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAddressForHuman(Address address) {
        this.address = address;
    }

    public void setLastName(String name) {
        this.last_name = name;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        this.age = 2021 - yearOfBirth;
    }

    public static void findByName(Human[] humans, String name) {
        for (Human human : humans) {
            if (human.getLastName().equals(name)) {
                System.out.println("Information for " + name + ": Year of birth=" + human.getYearOfBirth() + ", Address - " + human.getAddressOfHuman());
            }
        }
    }

    public static void findByAddress(Human[] humans, String address) {
        for (Human human : humans) {
            if (human.getAddressOfHuman().equals(address)) {
                System.out.println("Information for human with adress" + address + ": Year of birth=" + human.getYearOfBirth() + ", Name - " + human.getLastName());
            }
        }
    }

    public static void findOldest(Human[] humans) {
        String nameOfOldest = "";
        int ageOfOldest = 0;
        for (Human human : humans) {
            if (human.getAge() > ageOfOldest) {
                ageOfOldest = human.getAge();
                nameOfOldest = human.getLastName();
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
                nameOfYoungest = human.getLastName();
            }
        }
        System.out.println("The youngest human is " + nameOfYoungest + " and his age is " + ageOfYoungest);
    }

    public static void findByYears(Human[] humans, int firstYear, int lastYear) {
        for (Human human : humans) {
            if (human.getYearOfBirth() > firstYear & human.getYearOfBirth() < lastYear) {
                System.out.println("It's a " + human.getLastName() + " and he was born in " + human.getYearOfBirth());
            }
        }
    }

    public static void findHumansWithSameStreet(Human[] humans) {
        HashSet<Human> humansWithOneStreet = new HashSet<>();
        for (int i = 0; i<5; i++) {
            for (int j = i+1; j<4; j++) {
                if (humans[i].getAddressOfHuman().equals(humans[j].getAddressOfHuman())) {
                    humansWithOneStreet.add(humans[i]);
                    humansWithOneStreet.add(humans[j]);
                }
            }
            if (!humansWithOneStreet.isEmpty()) {
                System.out.println("On " + humans[i].getAddressOfHuman() + " street live this humans: ");
                for (Human human : humansWithOneStreet) {
                    System.out.println(human.getName() + " " + human.getLastName());
                }
                humansWithOneStreet.clear();
            }
        }
    }

    public static void menu(Human[] humans) throws IOException{
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

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
                findHumansWithSameStreet(humans);
                break;

            default:
                System.out.println("Incorrect command. Please try again");
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Human[] humans = new Human[5];
        for (int i = 0; i < 5; i++) {
            humans[i] = new Human();
            System.out.println("name " + (i + 1) + " ");
            humans[i].setName(scanner.readLine());
            System.out.println("Last name " + (i + 1) + " ");
            humans[i].setLastName(scanner.readLine());
            System.out.println("year of birth");
            humans[i].setYearOfBirth(Integer.parseInt(scanner.readLine()));
            System.out.println("street and number of house");
            Address address = new Address(scanner.readLine(), Integer.parseInt(scanner.readLine()));
            humans[i].setAddressForHuman(address);
        }
        for (int i = 0; i<7; i++) {
            menu(humans);
        }
    }
}
