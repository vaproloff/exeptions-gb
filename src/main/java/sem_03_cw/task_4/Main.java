package sem_03_cw.task_4;

/*  Задание 4
    Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

    Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
    должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

    В методе main() вызвать полученный метод, обработать возможные исключения
    MyArraySizeException и MyArrayDataException и вывести результат расчета
    (сумму элементов, при условии что подали на вход корректный массив).
*/

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] correctMatrix = {
                {"3", "7", "3", "1"},
                {"1", "6", "0", "4"},
                {"0", "5", "7", "2"},
                {"0", "2", "7", "8"}
        };
        String[][] wrongSizeMatrix = {
                {"1", "2", "0", "3"},
                {"6", "4", "1", "5"},
                {"9", "2", "7", "4"},
                {"0", "2"}
        };
        String[][] wrongCharMatrix = {
                {"1", "9", "2", "3"},
                {"6", "1", "5", "7"},
                {"2", "H", "7", "6"},
                {"1", "9", "4", "5"}
        };

        System.out.println(calculateSum(wrongCharMatrix));
    }

    public static int calculateSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        for (String[] strings : array) {
            if (array.length != 4 || strings.length != 4) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
}
