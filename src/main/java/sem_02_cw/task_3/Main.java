package sem_02_cw.task_3;

//    Задание 3.
//    Запишите в файл следующие строки:
//    Анна=4
//    Елена=5
//    Марина=6
//    Владимир=?
//    Константин=?
//    Иван=4
//    Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap).
//    В отдельном методе нужно будет пройти по структуре данных.
//    Если сохранено значение ?, заменить его на соответствующее число.
//    Если на каком-то месте встречается символ, отличный от числа или ?, бросить подходящее исключение.
//    Записать в тот же файл данные с замененными символами ?

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = readData("src/main/java/sem_02_cw/task_3/file.txt");
        System.out.println(map);
        writeData("src/main/java/sem_02_cw/task_3/file.txt", map);
    }

    public static void writeData(String FileName, HashMap<String, Integer> map) {
        try {
            File file = new File(FileName);
            FileWriter writer = new FileWriter(file);

            for (String name : map.keySet()) {
                int value = map.get(name);
                writer.write(name + "=" + value + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи!");
        }
    }

    public static HashMap<String, Integer> readData(String fileName) {
        HashMap<String, Integer> nameMap = new HashMap<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = "";

            while (line != null) {
                line = reader.readLine();

                if (line != null) {
                    String[] lineParts = line.split("=");
                    int nameLength = 0;
                    if (lineParts[1].equals("?")) {
                        nameLength = lineParts[0].length();
                    } else {
                        try {
                            nameLength = Integer.parseInt(lineParts[1]);
                        } catch (NumberFormatException e) {
                            throw new IllegalArgumentException("Неверный формат числа!" + line, e);
                        }
                    }
                    nameMap.put(lineParts[0], nameLength);
                }
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return nameMap;
    }
}
