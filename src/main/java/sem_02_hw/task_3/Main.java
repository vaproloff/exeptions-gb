package sem_02_hw.task_3;

/*
    Задание 2.
    Дан следующий код, исправьте его там, где требуется:
    https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit
*/
public class Main {
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, null);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        } catch (NullPointerException ex) {
            System.out.println("Передан null в качестве аргумента");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Индекс за пределами массива!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws NullPointerException {
        System.out.println(a + b);
    }

}
