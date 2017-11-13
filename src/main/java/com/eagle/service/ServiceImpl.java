package com.eagle.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.eagle.dao.Dao;
import com.eagle.model.ImageUrl;
import com.eagle.model.StudentPD;
import com.eagle.model.StudentSD;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

//Service Implementation for route and bus service with the Annotation @Service
@Service
public class ServiceImpl implements ServiceI {

    @Autowired
    private Dao dao;

    // Student Personal Details Service Implementation

    @Override
    public StudentPD getStudentPDById(String studentId) {
        StudentPD obj = dao.getStudentPDById(studentId);
        return obj;
    }

    @Override
    public List<StudentPD> getAllStudentPDs() {
        return dao.getAllStudentPDs();
    }

    @Override
    public synchronized boolean addStudentPD(StudentPD studentpd) {
        if (dao.studentExists(studentpd.getName(), studentpd.getDob(), studentpd.getAge(), studentpd.getParentName(), studentpd.getContactNo(), studentpd.getContactEmail(), studentpd.getBloodGrp())) {
            return false;
        } else {
            dao.addStudentPD(studentpd);
            return true;
        }
    }

    @Override
    public void updateStudentPD(StudentPD studentpd) {
        dao.updateStudentPD(studentpd);
    }

    @Override
    public void deleteStudentPD(String studentId) {
        dao.deleteStudentPD(studentId);
    }


    //Student Syllabus Details Implementation


    @Override
    public StudentSD getStudentSDById(String studentId) {
        StudentSD obj = dao.getStudentSDById(studentId);
        return obj;
    }

    @Override
    public List<StudentSD> getAllStudentSDs() {
        return dao.getAllStudentSDs();
    }

    @Override
    public synchronized boolean addStudentSD(StudentSD studentsd) {
        if (dao.studentsdExists(studentsd.getDateofjoining(), studentsd.getPresentkyu(), studentsd.getPresentbelt(), studentsd.getLastgradingdate(), studentsd.getNextgradingdate(), studentsd.getKatas()
                , studentsd.getCombinations(), studentsd.getSparingtechniques(), studentsd.getLevel(), studentsd.getKbi(), studentsd.getOpen(), studentsd.getFeepaid(), studentsd.getPendingfee())) {
            return false;
        } else {
            dao.addStudentSD(studentsd);
            return true;
        }
    }

    @Override
    public void updateStudentSD(StudentSD studentsd) {
        dao.updateStudentSD(studentsd);
    }

    @Override
    public void deleteStudentSD(String studentId) {
        dao.deleteStudentSD(studentId);
    }


    @Override
    public String getStudentImages() {
        File file = new File("./src/main/resources/student");
        String[] directories = file.list(new FilenameFilter() {

            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }

        });

        return Arrays.toString(directories);


    }

    @Override
    public List<ImageUrl> getStudentImageUrl(String studentId, HttpServletRequest request) {
        File dir = new File("./src/main/resources/student/" + studentId);
        List<ImageUrl> list = new ArrayList<>();
        for (String a : dir.list()) {
            ImageUrl d = new ImageUrl();
            String url = request.getRequestURL().toString();
            d.setUrl(url + "/" + a);
            list.add(d);

        }

        return list;
    }

    @Override
    public byte[] getImage(String studentId, String image) throws IOException {
        BufferedImage buffIm = ImageIO
                .read(new File("./src/main/resources/student/" + studentId
                        + "/" + image + ".jpg"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(buffIm, "jpg", baos);
        byte[] imageData = baos.toByteArray();
        return imageData;
    }

//Image


}
