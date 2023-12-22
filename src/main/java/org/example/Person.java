package org.example;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
    public class Person {
        private long id;
        private String lastName;
        private String gender;
        private Date birthday;
        private double salary;
        private Department department;

        public Person(long id, String lastName, String gender, String birthday, double salary, Department department) throws ParseException {
            this.id = id;
            this.lastName = lastName;
            this.gender = gender;
            this.birthday = new SimpleDateFormat("dd.MM.yyyy").parse(birthday);
            this.salary = salary;
            this.department = department;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        long getId(){
            return id;
        }
        String getLastName(){
            return lastName;
        }
        String getGender(){
            return gender;
        }

        Department getDepartment(){
            return department;
        }
        double getSalary(){
            return salary;
        }
        Date getBirthday(){
            return birthday;
        }

        public String toString(){
            return "id =    " + getId() + ", lastName=    " + getLastName() + ", gender=    " + getGender() + ", birthday=    " + getBirthday() + ", department=    " + getDepartment().getName() + ", salary=     " + getSalary();
        }
    }