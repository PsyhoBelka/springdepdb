package ua.rozhkov.springdepdb.service;

import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.core.College;
import ua.rozhkov.springdepdb.DAO.repository.CollegeRepository;

import java.util.List;

@Service
public class CollegeService implements BaseService<College, Long> {
    private CollegeRepository collegeRepository;

    public CollegeService(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @Override
    public College findById(Long id) {
        return collegeRepository.findCollegeById(id);
    }

    @Override
    public List<College> findAll() {
        return collegeRepository.findAll();
    }

    @Override
    public College findByName(String name) {
        return collegeRepository.findCollegeByName(name);
    }

    @Override
    public Long add(College newCollege) {
        return collegeRepository.save(newCollege).getId();
    }

    @Override
    public Long update(College updatedCollege) {
        return collegeRepository.saveAndFlush(updatedCollege).getId();
    }

    @Override
    public void deleteById(Long id) {
        collegeRepository.deleteById(id);
    }
}
