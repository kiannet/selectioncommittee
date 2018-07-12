package by.kiryanova.selectioncommittee.entity;

public class Subject {
    private int subjectId;
    private String name;
    private int points;

    public Subject(int subjectId, String name, int points){
        this.subjectId = subjectId;
        this.name = name;
        this.points = points;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
}
