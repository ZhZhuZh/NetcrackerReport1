package task2;


public class Player {
    private int count;
    Player (int count) {
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void upCount() {
        count++;
    }
}