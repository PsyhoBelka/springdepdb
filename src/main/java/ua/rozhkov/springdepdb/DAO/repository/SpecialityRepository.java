package ua.rozhkov.springdepdb.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rozhkov.springdepdb.DAO.entity.core.Specialty;

public interface SpecialityRepository extends JpaRepository<Specialty, Long> {
    Specialty findSpecialityById(long id);

    Specialty findSpecialityByName(String specialityName);
}
