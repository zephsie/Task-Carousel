package main;

public class CompleteByRequestTask implements Task {

    private boolean isReady = false;
    private boolean isFin = false;

    @Override
    public void execute() {
        if (isReady) isFin = true;
    }

    @Override
    public boolean isFinished() {
        return isFin;
    }

    public void complete() {
        isReady = true;
    }
}
