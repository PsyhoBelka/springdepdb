package ua.rozhkov.springdepdb.DAO.entity.core;

import ua.rozhkov.springdepdb.DAO.entity.CollegeSpecialty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specialties")
public class Specialty {


    private Long id;
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @OneToMany(mappedBy = "primaryKey.specialty", cascade = CascadeType.ALL)
    public Set<CollegeSpecialty> getColleges() {
        return colleges;
    }

    public void setColleges(Set<CollegeSpecialty> colleges) {
        this.colleges = colleges;
    }

    public void addCollege(CollegeSpecialty collegeSpecialty) {
        this.getColleges().add(collegeSpecialty);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specialty)) return false;

        Specialty specialty = (Specialty) o;

        if (!name.equals(specialty.name)) return false;
        return code.equals(specialty.code);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }
}
