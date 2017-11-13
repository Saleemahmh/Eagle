package com.eagle.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.eagle.model.ImageUrl;
import com.eagle.model.StudentPD;
import com.eagle.model.StudentSD;
import com.eagle.service.ServiceI;

@CrossOrigin
@RestController
@RequestMapping("/eagle")
public class HomeController {

    //sample endpoint--- localhost:8080/rest/eagle

    @Autowired
    private ServiceI serviceI;


    // Route Controller

		/*
		 * @GetMapping--specifies GET method
		 * @PostMapping--specifies POST method
		 * @PutMapping--specifies PUT method
		 * @DeleteMapping--specifies DELETE method
		 */

    @GetMapping("/getStudentpdbyID/{id}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
    public ResponseEntity<StudentPD> getStudentPDById(@PathVariable("id") String id) {
        StudentPD studentpd = serviceI.getStudentPDById(id);
        return new ResponseEntity<StudentPD>(studentpd, HttpStatus.OK);
    }

    @GetMapping("/getAllStudentpd")
    public ResponseEntity<List<StudentPD>> getAllStudentPDs() {
        List<StudentPD> list = serviceI.getAllStudentPDs();
        return new ResponseEntity<List<StudentPD>>(list, HttpStatus.OK);
    }


    @PostMapping(value = "/addStudentpd")
    public ResponseEntity<Void> addStudentPD(@RequestBody StudentPD studentpd, UriComponentsBuilder builder) {
        boolean flag = serviceI.addStudentPD(studentpd);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/getStudentpdbyID/{id}").buildAndExpand(studentpd.getStudentId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/updateStudentpd")
    public ResponseEntity<StudentPD> updateStudentPD(@RequestBody StudentPD studentpd) {
        serviceI.updateStudentPD(studentpd);
        return new ResponseEntity<StudentPD>(studentpd, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/deleteStudentpd/{id}")
    public ResponseEntity<Void> deleteStudentPD(@PathVariable("id") String id) {
        serviceI.deleteStudentPD(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


    //Student Syllabus Details Controller

    @GetMapping("/getStudentsdbyID/{id}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
    public ResponseEntity<StudentSD> getStudentSDById(@PathVariable("id") String id) {
        StudentSD studentsd = serviceI.getStudentSDById(id);
        return new ResponseEntity<StudentSD>(studentsd, HttpStatus.OK);
    }

    @GetMapping("/getAllStudentsd")
    public ResponseEntity<List<StudentSD>> getAllStudentSDs() {
        List<StudentSD> list = serviceI.getAllStudentSDs();
        return new ResponseEntity<List<StudentSD>>(list, HttpStatus.OK);
    }

    @PostMapping("/addStudentsd")
    public ResponseEntity<Void> addStudentSD(@RequestBody StudentSD studentsd, UriComponentsBuilder builder) {
        boolean flag = serviceI.addStudentSD(studentsd);

        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/getStudentsdbyID/{id}").buildAndExpand(studentsd.getStudentId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/updateStudentsd")
    public ResponseEntity<StudentSD> updateStudentSD(@RequestBody StudentSD studentsd) {
        serviceI.updateStudentSD(studentsd);
        return new ResponseEntity<StudentSD>(studentsd, HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudentsd/{id}")
    public ResponseEntity<Void> deleteStudentSD(@PathVariable("id") String id) {
        serviceI.deleteStudentSD(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


    //Image Upload controller

    @GetMapping("/student")// Sample: localhost:8080/rest/studentimage
    public String getStudentImages() {
        String folders = serviceI.getStudentImages();
        return folders;
    }

    @GetMapping("/student/{studentId}") //Sample: localhost:8080/rest/city/Guindy
    public List<ImageUrl> getStudent(@PathVariable("studentId") String studentId, HttpServletRequest request) {
        List<ImageUrl> studentimages = serviceI.getStudentImageUrl(studentId, request);
        return studentimages;
    }

    @GetMapping(value = "/student/{studentId}/{image}")
    public byte[] getImage(@PathVariable("studentId") String studentId, @PathVariable("image") String image)
            throws IOException {
        byte[] images = serviceI.getImage(studentId, image);
        return images;
    }


}
