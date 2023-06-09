package sem_03_cw.task_3;

public class MyZeroDividerEx extends Exception {
    public MyZeroDividerEx() {
        System.err.println("Zero divider");
    }
}
