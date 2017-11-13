package com.eagle.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.eagle.model.ImageUrl;
import com.eagle.model.StudentPD;
import com.eagle.model.StudentSD;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ServiceI {

    //Student Personal Details Implementation

    List<StudentPD> getAllStudentPDs();

    // Get students based on ID
    StudentPD getStudentPDById(String studentId);

    boolean addStudentPD(StudentPD studentpd);

    void updateStudentPD(StudentPD studentpd);

    void deleteStudentPD(String studentId);

    //Student Syllabus Details Implementation

    List<StudentSD> getAllStudentSDs();

    // Get students based on ID
    StudentSD getStudentSDById(String studentId);

    boolean addStudentSD(StudentSD studentsd);

    void updateStudentSD(StudentSD studentsd);

    void deleteStudentSD(String studentId);


    //Image Service

    //Get All Cities
    String getStudentImages();

    //Get All the Image Url for given City
    List<ImageUrl> getStudentImageUrl(String studentId, HttpServletRequest request);

    //Get the image for given URL
    byte[] getImage(String studentId, String imagename) throws IOException;

}

