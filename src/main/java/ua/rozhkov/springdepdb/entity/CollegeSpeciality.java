package ua.rozhkov.springdepdb.entity;

import ua.rozhkov.springdepdb.entity.core.College;
import ua.rozhkov.springdepdb.entity.core.Speciality;

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

    @ManyToOne
    @JoinColumn(name = "fk_college", insertable = false, updatable = false)
    private College college;

    @ManyToOne
    @JoinColumn(name = "fk_speciality", insertable = false, updatable = false)
    private Speciality speciality;

    @Column(name = "student_count")
    private int studentsOnSpecialityInCollegeCount;

    public CollegeSpeciality(College college, Speciality speciality, int studentsOnSpecialityInCollegeCount) {
        //composite Id
        this.id = new CollegeSpecialityId(college.getId(), speciality.getId());

        this.college = college;
        this.speciality = speciality;
        this.studentsOnSpecialityInCollegeCount = studentsOnSpecialityInCollegeCount;

        //update relationships to assure referential integrity
        college.getSpecialities().add(this);
        speciality.getColleges().add(this);
    }
}
