package ua.rozhkov.springdepdb.DAO.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.rozhkov.springdepdb.DAO.entity.CollegeSpeciality;
import ua.rozhkov.springdepdb.DAO.entity.core.College;
import ua.rozhkov.springdepdb.DAO.entity.core.Speciality;

import java.util.List;

public interface CollegeSpecialityRepository extends JpaRepository<CollegeSpeciality, CollegeSpeciality.CollegeSpecialityId> {
    List<College> findAllByCollege_Id(long collegeId);

    List<Speciality> findAllBySpeciality_Id(long specialityId);

}
