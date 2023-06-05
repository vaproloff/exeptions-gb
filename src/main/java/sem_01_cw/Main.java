package sem_01_cw;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 6, 3, 2, 4};
        List<Integer> nullsList = checkArray(arr);
        if (nullsList.size() > 0) {
            System.out.println("Массив сожержит null в ячейках: " + nullsList);
        } else {
            System.out.println("Массив не содержит null");
        }
    }

    /*  1. Реализуйте метод, принимающий в качестве аргумента
         целочисленный массив. Если длина массива меньше некоторого
         заданного минимума, метод возвращает -1 в качестве кода ошибки,
         иначе - длину массива.
    */
    public static int checkArrayLength(int[] array, int minLength) {
        if (array.length < minLength) {
            return -1;
        } else {
            return array.length;
        }
    }

    /*  2.1. Реализуйте метод, принимающий в качестве аргумента
        целочисленный массив и некоторое значение.
        Метод ищет в массиве заданное значение и возвращает его индекс.
        При этом, например:
        - если длина массива меньше некоторого заданного минимума,
          метод возвращает -1 в качестве кода ошибки.
        - если искомый элемент не найден, метод вернет -2 в качестве
          кода ошибки.
        - если вместо массива пришел null, метод вернет -3
        - придумайте свои варианты исключительных ситуаций и верните
          соответствующие коды ошибок.
    */
    public static int searchElement(int[] array, int minLength, int element) {
        if (array == null) {
            return -3;
        }

        if (array.length < minLength) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }

        return -2;
    }

    /*  2.2 Напишите метод, в котором реализуете взаимодействие с
        пользователем. То есть, этот метод запросит искомое число
        у пользователя, вызовет первый метод, обработает возвращенное
        значение и покажет читаемый результат пользователю.
        Например, если вернулся -2, пользователю выведется сообщение:
        “Искомый элемент не найден”.
    */
    public static void translateResult(int result) {
        switch (result) {
            case -1 -> System.out.println("Длина массива меньше заданного минимума");
            case -2 -> System.out.println("Искомый элемент не найден");
            case -3 -> System.out.println("Вместо массива пришёл null");
            default -> System.out.printf("Индекс искомого элемента: %d%n", result);
        }
    }

    /*  2. Реализуйте метод, принимающий в качестве аргумента
        целочисленный двумерный массив.
        Необходимо посчитать и вернуть сумму элементов этого массива.
        При этом накладываем на метод 2 ограничения: метод может
        работать только с квадратными массивами (кол-во строк =
        кол-ву столбцов), и в каждой ячейке может лежать только
        значение 0 или 1.
        Если нарушается одно из условий, метод должен бросить
        RuntimeException с сообщением об ошибке.
    */
    public static int sumElements(int[][] matrix) {
        for (int[] row : matrix) {
            if (matrix.length != row.length) {
                throw new RuntimeException("Массив не квадратный");
            }
        }

        for (int[] row : matrix) {
            for (int element : row) {
                if (element != 0 && element != 1) {
                    throw new RuntimeException("Могут быть только значения 0 и 1");
                }
            }
        }

        int sum = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
            }
        }

        return sum;
    }

    /*  4. Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
        Метод должен пройтись по каждому элементу и проверить
        что он не равен null.
        А теперь реализуйте следующую логику:
        Если в какой-то ячейке встретился null, то необходимо
        “оповестить” об этом пользователя
        Если null’ы встретились в нескольких ячейках, то идеально
        было бы все их “подсветить”
    */
    public static List<Integer> checkArray(Integer[] arr) {
        List<Integer> nullsList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                nullsList.add(i);
            }
        }
        return nullsList;
    }

    /*
        Привести код в порядок, исправить ошибки:
        https://github.com/sabinaIsm/test/blob/d2ebf811b85139783b1a0dcbe3714dbb28deee82/RandomExceptionsClass.java
    */
}
