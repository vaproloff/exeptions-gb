package sem_03_cw.task_4;

public class MyArraySizeException extends Exception {

    MyArraySizeException() {
        super("Размерность массива должна быть [4 x 4]\n");
    }
}
