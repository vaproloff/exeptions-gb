package sem_01_hw.task_4;

//    Задание 4.
//    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
//    и возвращающий новый массив, каждый элемент которого равен частному элементов
//    двух входящих массивов в той же ячейке. Если длины массивов не равны,
//    необходимо как-то оповестить пользователя.
//    Важно: При выполнении метода единственное исключение, которое пользователь
//    может увидеть - RuntimeException, т.е. ваше.

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 0};
        int[] arr2 = {4, 2, 0};

        int[] arrDiv = getArrayDiv(arr1, arr2);
        if (arrDiv != null) {
            System.out.println("Массив частных:");
            for (int num : arrDiv) {
                System.out.print(num + " ");
            }
        }
    }

    public static int[] getArrayDiv(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            System.out.println("Длины массивов не совпадают!");
            return null;
        }

        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("Деление на ноль недопустимо");
            }
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }
}
