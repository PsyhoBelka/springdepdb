package ua.rozhkov.springdepdb.service;

import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.CollegeSpeciality;
import ua.rozhkov.springdepdb.DAO.entity.core.Base;
import ua.rozhkov.springdepdb.DAO.entity.core.College;
import ua.rozhkov.springdepdb.DAO.entity.core.Speciality;
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
            Speciality speciality = specialityRepository.findSpecialityById(Long.parseLong(id));
            CollegeSpeciality tmpCollegeSpeciality = new CollegeSpeciality(college, speciality, studentsCount, base);
//            college.getSpecialities().add(tmpCollegeSpeciality);
            speciality.getColleges().add(tmpCollegeSpeciality);
//            collegeWithSpecialityList.add(tmpCollegeSpeciality);
//            specialityRepository.save(speciality);
        }
        collegeRepository.save(college);
        Set<CollegeSpeciality> sp = college.getSpecialities();
    }
}
