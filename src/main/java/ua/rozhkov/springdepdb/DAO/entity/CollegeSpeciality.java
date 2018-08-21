package ua.rozhkov.springdepdb.DAO.entity;

import ua.rozhkov.springdepdb.DAO.entity.core.Base;
import ua.rozhkov.springdepdb.DAO.entity.core.College;
import ua.rozhkov.springdepdb.DAO.entity.core.Speciality;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class CollegeSpeciality {

    @Embeddable
    public static class CollegeSpecialityId implements Serializable {

        @Column(name = "fk_college")
        private long colllegeId;

        @Column(name = "fk_speciality")
        private long specialityId;

        public CollegeSpecialityId(long colllegeId, long specialityId) {
            this.colllegeId = colllegeId;
            this.specialityId = specialityId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CollegeSpecialityId that = (CollegeSpecialityId) o;
            return colllegeId == that.colllegeId &&
                    specialityId == that.specialityId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(colllegeId, specialityId);
        }
    }

    @EmbeddedId
    private CollegeSpecialityId id;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fk_college", insertable = false, updatable = false)
    private College college;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "fk_speciality", insertable = false, updatable = false)
    private Speciality speciality;

    @Column(name = "student_count")
    private int studentsOnSpecialityInCollegeCount;

    @Column(name = "base")
    @Enumerated(EnumType.STRING)
    private Base base;

    public CollegeSpeciality(College college, Speciality speciality, int studentsOnSpecialityInCollegeCount, Base base) {
        //composite Id
        this.id = new CollegeSpecialityId(college.getId(), speciality.getId());
        this.college = college;
        this.speciality = speciality;
        this.studentsOnSpecialityInCollegeCount = studentsOnSpecialityInCollegeCount;
        this.base = base;

        //update relationships to assure referential integrity
        college.getSpecialities().add(this);
        speciality.getColleges().add(this);
    }

    public CollegeSpecialityId getId() {
        return id;
    }

    public void setId(CollegeSpecialityId id) {
        this.id = id;
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

    public int getStudentsOnSpecialityInCollegeCount() {
        return studentsOnSpecialityInCollegeCount;
    }

    public void setStudentsOnSpecialityInCollegeCount(int studentsOnSpecialityInCollegeCount) {
        this.studentsOnSpecialityInCollegeCount = studentsOnSpecialityInCollegeCount;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }
}
