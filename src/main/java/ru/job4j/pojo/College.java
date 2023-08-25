package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroup("Группа 123");
        student.setDateOfAdmission(new Date());

        System.out.println("ФИО: " + student.getFullName() + System.lineSeparator()
                + "Группа: " + student.getGroup() + System.lineSeparator() + "Дата поступления: "
                + student.getDateOfAdmission());
    }
}
