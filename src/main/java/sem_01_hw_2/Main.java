package sem_01_hw_2;

//    Задание 2.
//    Посмотрите на код, и подумайте сколько разных
//    типов исключений вы тут сможете получить?

public class Main {
    public static void main(String[] args) {
        int arrSum;

        arrSum = sum2d(new String[][]{{"1", "2"}, {"3", "4"}});
        // Получаем ArrayIndexOutOfBoundsException из-за жесткого условия j < 5

        arrSum = sum2d(new String[][]{{"1a", "2b", "0", "6", "7"}, {"3", "4", "0", "6", "7"}});
        // Получаем NumberFormatException из-за отсутствия проверки на возможное нечисловое выражение

        arrSum = sum2d(new String[][]{{"3", "4", "0", "6", "7"}, null});
        // Получаем NullPointerException из-за передачи в качестве подмассива - null

        arrSum = sum2d(new String[][]{(String[]) new Object()});
        // Получаем ClassCastException из-за передачи в качестве аргумента - объект кастуемый

        System.out.println(arrSum);
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }
}
