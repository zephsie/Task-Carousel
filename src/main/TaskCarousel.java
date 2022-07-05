package main;

import java.util.Arrays;

public class TaskCarousel {

    private final int capacity;

    private int position;
    private Task[] tasks;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        tasks = new Task[0];
    }

    public boolean addTask(Task task) {
        if (!task.isFinished() && tasks.length < capacity) {

            tasks = Arrays.copyOf(tasks, tasks.length + 1);
            tasks[tasks.length - 1] = task;
            return true;

        } return false;
    }

    public boolean execute() {
        if (isEmpty()) return false;

        position %= tasks.length;
        tasks[position].execute();

        if (tasks[position].isFinished()) {

            Task[] copyArray = new Task[tasks.length - 1];
            System.arraycopy(tasks, 0, copyArray, 0, position);
            System.arraycopy(tasks, position + 1, copyArray, position, tasks.length - position - 1);
            tasks = copyArray;

        } else position++;

        return true;
    }

    public boolean isFull() {
        return (tasks.length == capacity);
    }

    public boolean isEmpty() {
        return (tasks.length == 0);
    }
}
