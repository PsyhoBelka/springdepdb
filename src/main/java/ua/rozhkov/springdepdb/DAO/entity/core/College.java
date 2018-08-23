package ua.rozhkov.springdepdb.DAO.entity.core;

import org.hibernate.annotations.GenericGenerator;
import ua.rozhkov.springdepdb.DAO.entity.CollegeSpeciality;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "college")
public class College {

    @Id
    @Column(name = "id", unique = true)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "collGenerator", strategy = "increment")
    @GeneratedValue(generator = "collGenerator")
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
    @Enumerated(EnumType.STRING)
    private OwnerShip ownerShip;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CollegeSpeciality> specialities = new HashSet<>();

    public College() {
    }

    public College(String name, String address, String director, String phone, OwnerShip ownerShip) {
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

    public OwnerShip getOwnerShip() {
        return ownerShip;
    }

    public void setOwnerShip(OwnerShip ownerShip) {
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
