package sem_03_cw.task_2;


import java.io.IOException;

/*  Задание 2
    Создайте класс Счетчик, у которого есть метод add(),
    увеличивающий значение внутренней int переменной на 1.
    Сделайте так, чтобы с объектом такого типа можно было
    работать в блоке try-with-resources.
    Подумайте, что должно происходить при закрытии этого ресурса?
    Напишите метод для проверки, закрыт ли ресурс.
    При попытке вызвать add() у закрытого ресурса, должен выброситься IOException
*/
public class Main {

    public static void main(String[] args) throws Exception {
        try (MyCounter myCounter = new MyCounter(0)) {
            myCounter.add();
            myCounter.close();
            myCounter.add();
            System.out.println(myCounter);
        }
    }
}
