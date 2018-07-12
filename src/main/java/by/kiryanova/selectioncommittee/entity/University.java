package by.kiryanova.selectioncommittee.entity;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int universityId;
    private String name;
    private List<Faculty> faculties;

    public University(int universityId, String name){
        this.universityId = universityId;
        this.name = name;
        faculties = new ArrayList<Faculty>();
    }

    public void addFaculty(Faculty faculty){
        faculties.add(faculty);
    }

    public void removeFaculty(Faculty faculty){
        faculties.remove(faculty);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public int getUniversityId() {
        return universityId;
    }

    public String getName() {
        return name;
    }
}
