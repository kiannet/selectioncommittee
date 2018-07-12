package by.kiryanova.selectioncommittee.entity;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private int facultyId;
    private String name;
    private int universityId;////////////??????
    private List<Specialty> specialties;

    public Faculty(int facultyId, String name){
        this.facultyId = facultyId;
        this.name = name;
        specialties = new ArrayList<Specialty>();
    }

    public void addSpecialty(Specialty specialty){
        specialties.add(specialty);
    }

    public void removeSpecialty(Specialty specialty){
        specialties.remove(specialty);
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public int getFacultyId(){
        return facultyId;
    }

    public String getName() {
        return name;
    }
}
