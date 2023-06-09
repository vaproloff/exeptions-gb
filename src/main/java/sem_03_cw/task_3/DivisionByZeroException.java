package sem_03_cw.task_3;

public class DivisionByZeroException extends Exception {
    public DivisionByZeroException() {
        super("Делить на ноль нельзя!");
    }
}
