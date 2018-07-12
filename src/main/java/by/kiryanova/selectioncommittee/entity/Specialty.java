package by.kiryanova.selectioncommittee.entity;

public class Specialty {
    private int specialtyId;
    private String name;
    private int recruitmentPlan;

    public Specialty(int specialtyId, String name, int recruitmentPlan){
        this.specialtyId = specialtyId;
        this.name = name;
        this.recruitmentPlan = recruitmentPlan;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public String getName() {
        return name;
    }

    public int getRecruitmentPlan() {
        return recruitmentPlan;
    }
}
