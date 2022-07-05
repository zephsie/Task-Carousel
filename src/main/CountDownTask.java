package main;

public class CountDownTask implements Task{

    private int value;

    private boolean isFin = false;

    public CountDownTask(int value) {
        if (value > 0) {
            this.value = value;
        } else {
            this.value = 0;
            isFin = true;
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public void execute() {
        if (value != 0) {
            value--;
        } else isFin = true;

        System.out.println(value);
    }

    @Override
    public boolean isFinished() {
        return (value == 0);
    }
}
