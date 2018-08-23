package ua.rozhkov.springdepdb.service;

import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.CollegeSpecialty;
import ua.rozhkov.springdepdb.DAO.entity.core.Base;
import ua.rozhkov.springdepdb.DAO.entity.core.College;
import ua.rozhkov.springdepdb.DAO.entity.core.OwnerShip;
import ua.rozhkov.springdepdb.DAO.entity.core.Specialty;
import ua.rozhkov.springdepdb.DAO.repository.CollegeRepository;
import ua.rozhkov.springdepdb.DAO.repository.SpecialtyRepository;

import java.util.List;

@Service
public class CollegeSpecialtyService {
    private CollegeRepository collegeRepository;
    private SpecialtyRepository specialtyRepository;

    public CollegeSpecialtyService(CollegeRepository collegeRepository, SpecialtyRepository specialtyRepository) {
        this.collegeRepository = collegeRepository;
        this.specialtyRepository = specialtyRepository;
    }

    public void addSpecialitiesToCollege(College college, List<String> specialityIds, int studentsCount, Base base) {
//        List<CollegeSpeciality> collegeWithSpecialityList = new ArrayList<>();

        College college1 = new College("222", "222", "222", "222", OwnerShip.COMMUN);
        Specialty specialty1 = new Specialty("333", "333");
        CollegeSpecialty tmpCollegeSpecialty = new CollegeSpecialty();
        tmpCollegeSpecialty.setSpecialty(specialty1);
        tmpCollegeSpecialty.setCollege(college1);
//        specialtyRepository.save(specialty1);
        collegeRepository.save(college1);

        /*for (String id : specialityIds) {
            Specialty specialty = specialtyRepository.findSpecialtyById(Long.parseLong(id));
            CollegeSpecialty tmpCollegeSpecialty = new CollegeSpecialty();
            tmpCollegeSpecialty.setCollege(college);
            tmpCollegeSpecialty.setSpecialty(specialty);

            college.addSpeciality(tmpCollegeSpecialty);
            specialty.addCollege(tmpCollegeSpecialty);

//            specialtyRepository.save(specialty);
            collegeRepository.save(college);
        }
//        collegeRepository.save(college);
//        Set<CollegeSpecialty> sp = college.getSpecialities();*/
    }
}
