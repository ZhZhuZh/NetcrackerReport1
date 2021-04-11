package task3;

public class Address {
    private String street;
    private int numberOfHouse;

    public Address (String street, int numberOfHouse) {
        this.street = street;
        this.numberOfHouse = numberOfHouse;
    }

    public int getNumberOfHouse() {
        return numberOfHouse;
    }


    public String getAddress() {
        return street;
    }
}