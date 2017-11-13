package com.eagle.dao;


import java.util.List;

import com.eagle.model.StudentPD;
import com.eagle.model.StudentSD;

public interface Dao {

    //Student Personal Details DAO

    List<StudentPD> getAllStudentPDs();


    StudentPD getStudentPDById(String studentId);

    void addStudentPD(StudentPD studentpd);

    void updateStudentPD(StudentPD studentpd);

    void deleteStudentPD(String studentId);

    // Check whether student ID exists or not to create a new route to avoid
    // duplication
    boolean studentExists(String name, String dob, Integer age, String parentName, String contactNo, String contactEmail, String bloodGrp);

    //Student Syllabus Details DAO

    List<StudentSD> getAllStudentSDs();

    StudentSD getStudentSDById(String studentId);

    void addStudentSD(StudentSD studentsd);

    void updateStudentSD(StudentSD studentsd);

    void deleteStudentSD(String studentId);

    // Check whether student ID exists or not to create a new route to avoid
    // duplication
    boolean studentsdExists(String dateofjoinig, String presentkyu, String presentbelt, String lastgradingdate, String nextgradingdate, String katas, String combinations, String sparingtechniques,
                            String level, String kbi, String open, String feepaid, String pendingfee);

}
