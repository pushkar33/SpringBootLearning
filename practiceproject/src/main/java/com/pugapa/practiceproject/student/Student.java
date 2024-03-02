package com.pugapa.practiceproject.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pugapa.practiceproject.school.School;
import com.pugapa.practiceproject.studentprofile.StudentProfile;
import jakarta.persistence.*;

@Entity
@Table(name = "student_table")
public class Student
{
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "f_name")
    private String firstname;

    @Column(name = "l_name")
    private String lastname;

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    private String email;

    private int age;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;

    public Student()
    {

    }

    public Student(String firstname, String lastname, String email, int age) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
