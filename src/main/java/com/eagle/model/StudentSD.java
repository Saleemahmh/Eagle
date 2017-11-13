package com.eagle.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "StudentSD")
public class StudentSD {

    @Id
    @Column
    private String studentId;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String dateofjoining;
    @Column
    private String presentkyu;
    @Column
    private String presentbelt;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String lastgradingdate;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String nextgradingdate;
    @Column
    private String katas;
    @Column
    private String combinations;
    @Column
    private String sparingtechniques;
    @Column
    private String level;
    @Column
    private String kbi;
    @Column
    private String open;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String feepaid;
    @Column
    private String pendingfee;


    public StudentSD() {

    }


    public StudentSD(String studentId, String dateofjoining, String presentkyu, String presentbelt,
                     String lastgradingdate, String nextgradingdate, String katas, String combinations, String sparingtechniques,
                     String level, String kbi, String open, String feepaid, String pendingfee) {

        this.studentId = studentId;
        this.dateofjoining = dateofjoining;
        this.presentkyu = presentkyu;
        this.presentbelt = presentbelt;
        this.lastgradingdate = lastgradingdate;
        this.nextgradingdate = nextgradingdate;
        this.katas = katas;
        this.combinations = combinations;
        this.sparingtechniques = sparingtechniques;
        this.level = level;
        this.kbi = kbi;
        this.open = open;
        this.feepaid = feepaid;
        this.pendingfee = pendingfee;
    }


    public String getStudentId() {
        return studentId;
    }


    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public String getDateofjoining() {
        return dateofjoining;
    }


    public void setDateofjoining(String dateofjoining) {
        this.dateofjoining = dateofjoining;
    }


    public String getPresentkyu() {
        return presentkyu;
    }


    public void setPresentkyu(String presentkyu) {
        this.presentkyu = presentkyu;
    }


    public String getPresentbelt() {
        return presentbelt;
    }


    public void setPresentbelt(String presentbelt) {
        this.presentbelt = presentbelt;
    }


    public String getLastgradingdate() {
        return lastgradingdate;
    }


    public void setLastgradingdate(String lastgradingdate) {
        this.lastgradingdate = lastgradingdate;
    }


    public String getNextgradingdate() {
        return nextgradingdate;
    }


    public void setNextgradingdate(String nextgradingdate) {
        this.nextgradingdate = nextgradingdate;
    }


    public String getKatas() {
        return katas;
    }


    public void setKatas(String katas) {
        this.katas = katas;
    }


    public String getCombinations() {
        return combinations;
    }


    public void setCombinations(String combinations) {
        this.combinations = combinations;
    }


    public String getSparingtechniques() {
        return sparingtechniques;
    }


    public void setSparingtechniques(String sparingtechniques) {
        this.sparingtechniques = sparingtechniques;
    }


    public String getLevel() {
        return level;
    }


    public void setLevel(String level) {
        this.level = level;
    }


    public String getKbi() {
        return kbi;
    }


    public void setKbi(String kbi) {
        this.kbi = kbi;
    }


    public String getOpen() {
        return open;
    }


    public void setOpen(String open) {
        this.open = open;
    }


    public String getFeepaid() {
        return feepaid;
    }


    public void setFeepaid(String feepaid) {
        this.feepaid = feepaid;
    }


    public String getPendingfee() {
        return pendingfee;
    }


    public void setPendingfee(String pendingfee) {
        this.pendingfee = pendingfee;
    }


}
