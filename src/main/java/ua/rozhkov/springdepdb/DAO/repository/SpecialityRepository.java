package ua.rozhkov.springdepdb.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rozhkov.springdepdb.DAO.entity.core.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
    Speciality findSpecialityById(long id);

    Speciality findSpecialityByName(String specialityName);
}
