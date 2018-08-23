package ua.rozhkov.springdepdb.DAO.entity.core;

import ua.rozhkov.springdepdb.DAO.entity.CollegeSpecialty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specialties")
public class Specialty {


    private long id;
    private String name;
    private String code;
    private Set<CollegeSpecialty> colleges = new HashSet<>();

    public Specialty(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Specialty() {

    }

    @Id
    @Column(name = "specialty_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @OneToMany(mappedBy = "primarykey.speciality", cascade = CascadeType.ALL)
    public Set<CollegeSpecialty> getColleges() {
        return colleges;
    }

    public void setColleges(Set<CollegeSpecialty> colleges) {
        this.colleges = colleges;
    }

    public void addCollege(CollegeSpecialty collegeSpecialty) {
        this.getColleges().add(collegeSpecialty);
    }
}
