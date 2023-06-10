package sem_03_hw;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private String birthday;
    private long phoneNumber;
    private char gender;

    private Person(String surname, String name, String patronymic, String birthday, long phoneNumber, char gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public Person(String[] inputArr) {
        this(inputArr[0], inputArr[1], inputArr[2], inputArr[3], Long.parseLong(inputArr[4]), inputArr[5].charAt(0));
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return surname + " " +
                name + " " +
                patronymic + " " +
                birthday + " " +
                phoneNumber + " " +
                gender;
    }
}
