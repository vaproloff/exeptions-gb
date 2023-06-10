package sem_03_hw;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ViewController {
    private final String dirPath;

    public ViewController(String dirPath) throws IOException {
        this.dirPath = dirPath;
        Path path = Path.of(dirPath);
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }
    }

    public void run() {
        while (true) {
            String input = prompt("""
                    ---
                    Введите данные с формате:
                    Фамилия Имя Отчество ДатаРождения НомерТелефона Пол
                    или нажмите Enter для выхода из программы""");
            if (input.isBlank()) {
                return;
            }

            String[] inputArr = input.split(" ");
            switch (checkLength(inputArr)) {
                case -1 -> {
                    System.err.println("Вы ввели недостаточно данных");
                }
                case 1 -> {
                    System.err.println("Вы ввели что-то лишнее");
                }
                default -> {
                    try {
                        if (checkInput(inputArr)) {
                            Person newPerson = new Person(input.split(" "));
                            save(newPerson);
                            System.out.println("Данные записаны успешно");
                        }
                    } catch (InputPersonFormatException e) {
                        System.err.println(e.getMessage());
                    } catch (IOException e) {
                        System.err.println("Проблема записи файла");
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean checkInput(String[] inputArr) throws InputPersonFormatException {
        Pattern patternName = Pattern.compile("^[A-Z][a-z]*|[А-Я][а-я]*$");
        if (!patternName.matcher(inputArr[0]).matches()) {
            throw new InputPersonFormatException("Фамилия указана неверно");
        }
        if (!patternName.matcher(inputArr[1]).matches()) {
            throw new InputPersonFormatException("Имя указано неверно");
        }
        if (!patternName.matcher(inputArr[2]).matches()) {
            throw new InputPersonFormatException("Отчество указано неверно");
        }

        if (!checkDate(inputArr[3])) {
            throw new InputPersonFormatException("Неверный формат даты рождения");
        }

        Pattern patternPhone = Pattern.compile("^\\d+$");
        if (!patternPhone.matcher(inputArr[4]).matches()) {
            throw new InputPersonFormatException("Неверный формат телефона");
        }

        Pattern patternGender = Pattern.compile("^[fFmM]$");
        if (!patternGender.matcher(inputArr[5]).matches()) {
            throw new InputPersonFormatException("Неверно указан пол");
        }
        return true;
    }

    private int checkLength(String[] inputArr) {
        if (inputArr.length < 6) {
            return -1;
        } else if (inputArr.length > 6) {
            return 1;
        }
        return 0;
    }

    private boolean checkDate(String dateString) {
        try {
            LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void save(Person newPerson) throws IOException {
        String filePath = dirPath + newPerson.getSurname();
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(newPerson + "\n");
            writer.flush();
        } catch (IOException ex) {
            throw new IOException(ex);
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }
}
