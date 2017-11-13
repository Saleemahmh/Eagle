package com.eagle.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "StudentPD")
public class StudentPD {


    @Id
    //specifies this field is primary key
    private String studentId;
    @Column
    //specifies the column
    private String name;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String dob;
    @Column
    //Time stored in milliseconds
    private Integer age;
    @Column
    private String parentName;
    @Column
    private String contactNo;
    @Column
    private String contactEmail;
    @Column
    private String bloodGrp;
    @Transient
    private MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public StudentPD() {

    }


    public StudentPD(String studentId, String name, String dob, Integer age, String parentName, String contactNo,
                     String contactEmail, String bloodGrp) {

        this.studentId = studentId;
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.parentName = parentName;
        this.contactNo = contactNo;
        this.contactEmail = contactEmail;
        this.bloodGrp = bloodGrp;
    }


    public String getStudentId() {
        return studentId;
    }


    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDob() {
        return dob;
    }


    public void setDob(String dob) {
        this.dob = dob;
    }


    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }


    public String getParentName() {
        return parentName;
    }


    public void setParentName(String parentName) {
        this.parentName = parentName;
    }


    public String getContactNo() {
        return contactNo;
    }


    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }


    public String getContactEmail() {
        return contactEmail;
    }


    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }


    public String getBloodGrp() {
        return bloodGrp;
    }


    public void setBloodGrp(String bloodGrp) {
        this.bloodGrp = bloodGrp;
    }


}
