package ua.rozhkov.springdepdb.service;

import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.CollegeSpecialty;
import ua.rozhkov.springdepdb.DAO.entity.core.Base;
import ua.rozhkov.springdepdb.DAO.entity.core.College;
import ua.rozhkov.springdepdb.DAO.entity.core.Specialty;
import ua.rozhkov.springdepdb.DAO.repository.CollegeRepository;
import ua.rozhkov.springdepdb.DAO.repository.SpecialityRepository;

import java.util.List;
import java.util.Set;

@Service
public class CollegeSpecialityService {
    private CollegeRepository collegeRepository;
    private SpecialityRepository specialityRepository;

    public CollegeSpecialityService(CollegeRepository collegeRepository, SpecialityRepository specialityRepository) {
        this.collegeRepository = collegeRepository;
        this.specialityRepository = specialityRepository;
    }

    public void addSpecialitiesToCollege(College college, List<String> specialityIds, int studentsCount, Base base) {
//        List<CollegeSpeciality> collegeWithSpecialityList = new ArrayList<>();
        for (String id : specialityIds) {
            Specialty specialty = specialityRepository.findSpecialityById(Long.parseLong(id));
            CollegeSpecialty tmpCollegeSpeciality = new CollegeSpecialty(college, specialty, studentsCount, base);
//            college.getSpecialities().add(tmpCollegeSpeciality);
//            specialty.getColleges().add(tmpCollegeSpeciality);
//            collegeWithSpecialityList.add(tmpCollegeSpeciality);
//            specialityRepository.save(specialty);
        }
        collegeRepository.save(college);
        Set<CollegeSpecialty> sp = college.getSpecialities();
    }
}
