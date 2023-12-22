package org.example;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        fun();
    }

    public static void fun() {
        List<Person> persons = new ArrayList<>();
        List<Department> departments = new ArrayList<>();
        String csvFilePath = "C:\\Users\\user\\AppData\\Local\\Temp\\untitled\\src\\main\\resources\\foreign_names.csv";

        try {
            CSVReader reader = new CSVReader(new FileReader(csvFilePath));
            String[] nextLine;
            reader.readNext();
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine != null) {
                    String nextLine1 = "";
                    for (int i = 0; i < nextLine.length; i++) {
                        nextLine1 += nextLine[i];
                    }
                    Person temp = getPersonByStr(nextLine1, departments);
                    persons.add(temp);
                }
            }

            printPersonsDB(persons);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printPersonsDB(List<Person> persons) {
        for (Person temp : persons) {
            System.out.println(temp.toString());
        }
    }

    public static Department founder(String str, List<Department> departments) {
        for (Department department : departments) {
            if (department.getName().charAt(0) == str.charAt(0)) {
                return department;
            }
        }
        Department newDepartment = new Department(str.charAt(0) - 'A', str);
        departments.add(newDepartment);
        return newDepartment;
    }

    private static Person getPersonByStr(String line1, List<Department> departments) throws ParseException {
        String separator = ";";
        String[] line = line1.split(separator);

        long id = Long.parseLong(line[0]);
        String lastName = line[1];
        String gender = line[2];
        String birthdayString = line[3];
        double salary = Double.parseDouble(line[5]);
        Department department = founder(line[4], departments);

        try {
            return new Person(id, lastName, gender, birthdayString, salary, department);
        } catch (ParseException e) {
            throw e;
        }
    }

}