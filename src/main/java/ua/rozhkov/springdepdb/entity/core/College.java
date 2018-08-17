package ua.rozhkov.springdepdb.entity.core;

import ua.rozhkov.springdepdb.entity.CollegeSpeciality;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "college")
public class College {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "director", unique = true)
    private String director;

    @Column(name = "phone")
    private String phone;

    @Column(name = "ownerShip")
    private String ownerShip;

    @OneToMany(mappedBy = "college")
    private Set<CollegeSpeciality> specialities = new HashSet<CollegeSpeciality>();

    public College(String name, String address, String director, String phone, String ownerShip) {
        this.name = name;
        this.address = address;
        this.director = director;
        this.phone = phone;
        this.ownerShip = ownerShip;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOwnerShip() {
        return ownerShip;
    }

    public void setOwnerShip(String ownerShip) {
        this.ownerShip = ownerShip;
    }

    public Set<CollegeSpeciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<CollegeSpeciality> specialities) {
        this.specialities = specialities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        College college = (College) o;
        return Objects.equals(name, college.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
