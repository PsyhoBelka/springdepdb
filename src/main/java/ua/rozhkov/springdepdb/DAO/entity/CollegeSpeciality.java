package ua.rozhkov.springdepdb.DAO.entity;

import ua.rozhkov.springdepdb.DAO.entity.core.Base;
import ua.rozhkov.springdepdb.DAO.entity.core.College;
import ua.rozhkov.springdepdb.DAO.entity.core.Speciality;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "college_speciality")
public class CollegeSpeciality implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @EmbeddedId
//    private CollegeSpecialityId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "college_id")
    private College college;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @Column(name = "students_count")
    private int studentsOnSpeciality;

    @Column(name = "base")
    @Enumerated(EnumType.STRING)
    private Base base;

    public CollegeSpeciality() {
    }

    public CollegeSpeciality(College college, Speciality speciality, int studentsOnSpeciality, Base base) {
//        this.id=new CollegeSpecialityId(college.getId(),speciality.getId());
        this.college = college;
        this.speciality = speciality;
        this.studentsOnSpeciality = studentsOnSpeciality;
        this.base = base;

        college.getSpecialities().add(this);
        speciality.getColleges().add(this);
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getStudentsOnSpeciality() {
        return studentsOnSpeciality;
    }

    public void setStudentsOnSpeciality(int studentsOnSpeciality) {
        this.studentsOnSpeciality = studentsOnSpeciality;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollegeSpeciality that = (CollegeSpeciality) o;
        return Objects.equals(college, that.college) &&
                Objects.equals(speciality, that.speciality);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, studentsOnSpeciality, base);
    }
}
