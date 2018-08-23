package ua.rozhkov.springdepdb.DAO.entity.core;

import ua.rozhkov.springdepdb.DAO.entity.CollegeSpecialty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "colleges")
public class College {


    private long id;
    private String name;
    private String address;
    private String director;
    private String phone;
    private OwnerShip ownerShip;
    private Set<CollegeSpecialty> specialities = new HashSet<>();

    public College() {
    }

    public College(String name, String address, String director, String phone, OwnerShip ownerShip) {
        this.name = name;
        this.address = address;
        this.director = director;
        this.phone = phone;
        this.ownerShip = ownerShip;
    }

    @Id
    @Column(name = "college_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "director", unique = true)
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "ownerShip")
    @Enumerated(EnumType.STRING)
    public OwnerShip getOwnerShip() {
        return ownerShip;
    }

    public void setOwnerShip(OwnerShip ownerShip) {
        this.ownerShip = ownerShip;
    }

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
    public Set<CollegeSpecialty> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<CollegeSpecialty> specialities) {
        this.specialities = specialities;
    }

    public void addSpeciality(CollegeSpecialty collegeSpeciality) {
        this.getSpecialities().add(collegeSpeciality);
    }
}
