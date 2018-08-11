package by.kiryanova.selectioncommittee.entity;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enrollee extends User{
    private int enrolleeId;
    private String passportId;
    private String surname;
    private String name;
    private String secondName;
    private String phone;
    private int certificate;
    private String specialty;
    private List<Integer> points;
    private List<Subject> subjects;
    private List<String> subjectNames;
    private Map<String, Integer> subjectPoint = new HashMap<>();

    public Enrollee(){

    }

    public Enrollee(int enrolleeId, String passportId, String surname, String name, String secondName, String phone, int certificate, String specialty, Subject subject1, Subject subject2, Subject subject3, String email, String username, String password, String role, String ban) {
        super(enrolleeId, email, username, password, role, ban);
        this.passportId = passportId;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.certificate = certificate;
        this.specialty = specialty;
        this.subjects = new ArrayList<Subject>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
    }

    public Map<String, Integer> getSubjectPoint(){
        return subjectPoint;
    }

    public List<Integer> getPoints() {
        return points;
    }

    public int getEnrolleeId() {
        return enrolleeId;
    }

    public String getPassportId() {
        return passportId;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public List<String> getSubjectNames() {
        return subjectNames;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhone() {
        return phone;
    }

    public int getCertificate() {
        return certificate;
    }

    public String getSpecialty(){
        return specialty;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setCertificate(int certificate) {
        this.certificate = certificate;
    }

    public void setEnrolleeId(int enrolleeId) {
        this.enrolleeId = enrolleeId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setSubject(Subject subject){
        subjects.add(subject);
    }

    public void setSubjectNames(List<String> subjectNames) {
        this.subjectNames = subjectNames;
    }

    public void setSubjectPoint(Map<String, Integer> subjectPoint){
        this.subjectPoint = subjectPoint;
    }

    public void setPoints(List<Integer> points) {
        this.points = points;
    }

    public int getSum(){
        int sum = 0;
        for (int i = 0; i < points.size(); i++){
            sum+=points.get(i);
        }
        return certificate + sum;
    }

    public void removeSubject(Subject subject){
        subjects.remove(subject);
    }
}
