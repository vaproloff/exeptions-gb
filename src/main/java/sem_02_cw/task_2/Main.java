package sem_02_cw.task_2;

//    Задание 2.
//    Обработайте возможные исключительные ситуации.
//    “Битые” значения в исходном массиве считайте нулями.
//    Можно внести в код правки, которые считаете необходимыми.

public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"1", "2"}, {"3", null}, {"1", "6"}};
        System.out.println(sum2d(arr));
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] != null) {
                        sum += tryParseInt(arr[i][j]);
                    }
                }
            }
        }
        return sum;
    }

    public static int tryParseInt(String a) {
        try {
            return Integer.parseInt(a);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
