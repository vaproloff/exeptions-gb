package sem_03_cw.task_3;

/*  Задание 3
    Создайте класс исключения, который будет выбрасываться при делении на 0.
    Исключение должно отображать понятное для пользователя сообщение об ошибке.

    Создайте класс исключений, которое будет возникать при обращении к пустому
    элементу в массиве ссылочного типа. Исключение должно отображать понятное для пользователя сообщение об ошибке

    Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл.
    Исключение должно отображать понятное для пользователя сообщение об ошибке.
*/
public class Main {
    public static void main(String[] args) throws MyZeroDividerEx, DivisionByZeroException {
//        throwEx1();
        throwEx2();
    }

    public static void throwEx1() throws MyZeroDividerEx {
        throw new MyZeroDividerEx();
    }

    public static void throwEx2() throws DivisionByZeroException {
        throw new DivisionByZeroException();
    }
}
