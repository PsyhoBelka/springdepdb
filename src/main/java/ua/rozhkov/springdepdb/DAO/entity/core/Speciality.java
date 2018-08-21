package ua.rozhkov.springdepdb.DAO.entity.core;

import ua.rozhkov.springdepdb.DAO.entity.CollegeSpeciality;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "speciality")
public class Speciality {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    @OneToMany(mappedBy = "speciality")
    private Set<CollegeSpeciality> colleges = new HashSet<>();

    public Speciality(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Speciality() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<CollegeSpeciality> getColleges() {
        return colleges;
    }

    public void setColleges(Set<CollegeSpeciality> colleges) {
        this.colleges = colleges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speciality that = (Speciality) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }
}
