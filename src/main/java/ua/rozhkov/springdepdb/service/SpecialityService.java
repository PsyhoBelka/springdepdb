package ua.rozhkov.springdepdb.service;

import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.core.Specialty;
import ua.rozhkov.springdepdb.DAO.repository.SpecialityRepository;

import java.util.List;

@Service
public class SpecialityService implements BaseService<Specialty, Long> {
    private SpecialityRepository specialityRepository;

    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }


    @Override
    public Specialty findById(Long id) {
        return specialityRepository.findSpecialityById(id);
    }

    @Override
    public List<Specialty> findAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Specialty findByName(String name) {
        return specialityRepository.findSpecialityByName(name);
    }

    @Override
    public Long add(Specialty newSpecialty) {
        return specialityRepository.save(newSpecialty).getId();
    }

    @Override
    public Long update(Specialty updatedSpecialty) {
        return specialityRepository.save(updatedSpecialty).getId();
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
