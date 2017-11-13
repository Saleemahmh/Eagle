package com.eagle.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.eagle.model.StudentPD;
import com.eagle.model.StudentSD;

@Transactional
@Repository
public class DaoImpl implements Dao {

    /*Entity Manager is used to access a database
    * it is used to create and remove persistent entity instances
    *to find entities by their primary key identity etc.
    *This interface is similar to the Session in Hibernate
    */
    @PersistenceContext
    private EntityManager entityManager;

    // Route DAO Implementation


    @Override
    public StudentPD getStudentPDById(String studentId) {
        return entityManager.find(StudentPD.class, studentId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<StudentPD> getAllStudentPDs() {
        String hql = "FROM StudentPD as std ORDER BY std.studentId";
        return (List<StudentPD>) entityManager.createQuery(hql).getResultList();

    }

    @Override
    public void addStudentPD(StudentPD studentpd) {
        entityManager.persist(studentpd);
    }

    @Override
    public void updateStudentPD(StudentPD studentpd) {
        StudentPD std = entityManager.find(StudentPD.class, studentpd.getStudentId());
        std.setName(studentpd.getName());
        std.setDob(studentpd.getDob());
        std.setAge(studentpd.getAge());
        std.setParentName(studentpd.getParentName());
        std.setContactNo(studentpd.getContactNo());
        std.setContactEmail(studentpd.getContactEmail());
        std.setBloodGrp(studentpd.getBloodGrp());
        entityManager.flush();
    }

    @Override
    public void deleteStudentPD(String studentId) {
        entityManager.remove(entityManager.find(StudentPD.class, studentId));
    }

    @Override
    public boolean studentExists(String name, String dob, Integer age, String parentName, String contactNo, String contactEmail, String bloodGrp) {
        String hql = "FROM StudentPD as std WHERE std.name = ? and std.dob = ? and std.age = ? and std.parentName = ? and std.contactNo = ?"
                + " and std.contactEmail = ? and std.bloodGrp = ? ";
        int count = entityManager.createQuery(hql).setParameter(1, name).setParameter(2, dob).setParameter(3, age).setParameter(4, parentName)
                .setParameter(5, contactNo).setParameter(6, contactEmail).setParameter(7, bloodGrp).getResultList()
                .size();
        return count > 0;
    }


    //Student Syllabus Details DAO Implementation

    @Override
    public StudentSD getStudentSDById(String studentId) {
        return entityManager.find(StudentSD.class, studentId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<StudentSD> getAllStudentSDs() {
        String hql = "FROM StudentSD as std ORDER BY std.studentId";
        return (List<StudentSD>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addStudentSD(StudentSD studentsd) {
        entityManager.persist(studentsd);
    }

    @Override
    public void updateStudentSD(StudentSD studentsd) {
        StudentSD std = entityManager.find(StudentSD.class, studentsd.getStudentId());
        std.setDateofjoining(studentsd.getDateofjoining());
        std.setPresentkyu(studentsd.getPresentkyu());
        std.setPresentbelt(studentsd.getPresentbelt());
        std.setLastgradingdate(studentsd.getLastgradingdate());
        std.setNextgradingdate(studentsd.getNextgradingdate());
        std.setKatas(studentsd.getKatas());
        std.setCombinations(studentsd.getCombinations());
        std.setSparingtechniques(studentsd.getSparingtechniques());
        std.setLevel(studentsd.getLevel());
        std.setKbi(studentsd.getKbi());
        std.setOpen(studentsd.getOpen());
        std.setFeepaid(studentsd.getFeepaid());
        std.setPendingfee(studentsd.getPendingfee());
        entityManager.flush();
    }

    @Override
    public void deleteStudentSD(String studentId) {
        entityManager.remove(entityManager.find(StudentSD.class, studentId));
    }

    @Override
    public boolean studentsdExists(String dateofjoinig, String presentkyu, String presentbelt, String lastgradingdate, String nextgradingdate, String katas, String combinations, String sparingtechniques,
                                   String level, String kbi, String open, String feepaid, String pendingfee) {
        String hql = "FROM StudentSD as std WHERE std.dateofjoining = ? and std.presentkyu = ? and std.presentbelt = ? and std.lastgradingdate = ? and std.nextgradingdate = ?"
                + " and std.katas = ? and std.combinations = ? and std.sparingtechniques = ? and std.level = ? and std.kbi = ? and std.open = ?"
                + "and std.feepaid = ? and std.pendingfee = ? ";
        int count = entityManager.createQuery(hql).setParameter(1, dateofjoinig).setParameter(2, presentkyu).setParameter(3, presentbelt)
                .setParameter(4, lastgradingdate).setParameter(5, nextgradingdate).setParameter(6, katas).setParameter(7, combinations)
                .setParameter(8, sparingtechniques).setParameter(9, level).setParameter(10, kbi).setParameter(11, open)
                .setParameter(12, feepaid).setParameter(13, pendingfee).getResultList()
                .size();
        return count > 0;
    }
}
