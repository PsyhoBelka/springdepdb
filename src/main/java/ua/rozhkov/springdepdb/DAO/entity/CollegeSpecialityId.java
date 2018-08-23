package ua.rozhkov.springdepdb.DAO.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

//@Embeddable
public class CollegeSpecialityId implements Serializable {

    @Column(name = "fk_college")
    private long collegeId;

    @Column(name = "fk_speciality")
    private long specialityId;

    public CollegeSpecialityId() {
    }

    public CollegeSpecialityId(long collegeId, long specialityId) {
        this.collegeId = collegeId;
        this.specialityId = specialityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollegeSpecialityId that = (CollegeSpecialityId) o;
        return collegeId == that.collegeId &&
                specialityId == that.specialityId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(collegeId, specialityId);
    }
}
