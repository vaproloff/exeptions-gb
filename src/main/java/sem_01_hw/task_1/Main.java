package sem_01_hw.task_1;

//    Задание 1.
//    Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

public class Main {
    public static void main(String[] args) {
        System.out.println(parseNumber("3rf4g54")); // NumberFormatException

        System.out.println(divideTwoNumbers(10, 0)); // ArithmeticException

        System.out.println(sumArrElements(new int[]{})); // ArrayIndexOutOfBoundsException
    }

    public static int parseNumber(String inputString) {
        return Integer.parseInt(inputString);
    }

    public static int divideTwoNumbers(int numA, int numB) {
        return numA / numB;
    }

    public static int sumArrElements(int[] arr) {
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
