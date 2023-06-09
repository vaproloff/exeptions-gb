package sem_02_hw.task_1;

import java.util.Scanner;

/*
    Задание 1.
    Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
    вместо этого, необходимо повторно запросить у пользователя ввод данных.
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("Введено: " + askForNumber());
    }

    private static float askForNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите дробное число: ");
            String input = scanner.nextLine();
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Введено неверное значение!");
            }
        }
    }
}
