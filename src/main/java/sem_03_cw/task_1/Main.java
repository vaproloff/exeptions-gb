package sem_03_cw.task_1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            doSomething();
        } catch (IOException e) {
            System.out.println("Исключение ввода-вывода");
        }
    }

    public static void doSomething() throws IOException {
        throw new IOException();
    }
}
