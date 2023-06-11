package sem_02_hw.task_4;

import java.util.Scanner;

/*
    Задание 4.
    Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
*/
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введен текст: " + askForInput());
    }

    private static String askForInput() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String input = scanner.nextLine();
        if (input.isBlank()) {
            throw new Exception("Пустую строку вводить нельзя");
        } else {
            return input;
        }
    }
}
