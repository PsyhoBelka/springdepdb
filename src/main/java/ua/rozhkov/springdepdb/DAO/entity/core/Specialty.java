package ua.rozhkov.springdepdb.DAO.entity.core;

import org.hibernate.annotations.GenericGenerator;
import ua.rozhkov.springdepdb.DAO.entity.CollegeSpecialty;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "specialties")
public class Specialty {


    private Long id;
    private String name;
    private String code;
    private List<CollegeSpecialty> colleges = new LinkedList<>();

    public Specialty(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Specialty() {

    }

    @Id
    @Column(name = "specialty_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
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
    public List<CollegeSpecialty> getColleges() {
        return colleges;
    }

    public void setColleges(List<CollegeSpecialty> colleges) {
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
