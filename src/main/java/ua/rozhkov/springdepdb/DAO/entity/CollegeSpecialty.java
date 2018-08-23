package ua.rozhkov.springdepdb.DAO.entity;

import ua.rozhkov.springdepdb.DAO.entity.core.Base;
import ua.rozhkov.springdepdb.DAO.entity.core.College;
import ua.rozhkov.springdepdb.DAO.entity.core.Specialty;

import javax.persistence.*;

@Entity
@Table(name = "colleges_specialties")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.college", joinColumns = @JoinColumn(name = "college_id")),
        @AssociationOverride(name = "primaryKey.specialty", joinColumns = @JoinColumn(name = "specialty_id"))})
public class CollegeSpecialty {
    private CollegeSpecialtyId primaryKey = new CollegeSpecialtyId();
    private int students;
    private Base base;

    @EmbeddedId
    public CollegeSpecialtyId getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    private College getCollege() {
        return getPrimaryKey().getCollege();
    }

    private void setCollege(College college) {
        getPrimaryKey().setCollege(college);
    }

    @Transient
    private Specialty getSpecialty() {
        return getPrimaryKey().getSpecialty();
    }

    private void setSpecialty(Specialty specialty) {
        getPrimaryKey().setSpecialty(specialty);
    }

    public void setPrimaryKey(CollegeSpecialtyId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Column(name = "students")
    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    @Column(name = "base")
    @Enumerated(EnumType.STRING)
    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }
}
