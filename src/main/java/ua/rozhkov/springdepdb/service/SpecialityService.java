package ua.rozhkov.springdepdb.service;

import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.core.Speciality;
import ua.rozhkov.springdepdb.DAO.repository.SpecialityRepository;

import java.util.List;

@Service
public class SpecialityService implements BaseService<Speciality, Long> {
    private SpecialityRepository specialityRepository;

    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }


    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findSpecialityById(id);
    }

    @Override
    public List<Speciality> findAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality findByName(String name) {
        return specialityRepository.findSpecialityByName(name);
    }

    @Override
    public Long add(Speciality newSpeciality) {
        return specialityRepository.save(newSpeciality).getId();
    }

    @Override
    public Long update(Speciality updatedSpeciality) {
        return specialityRepository.save(updatedSpeciality).getId();
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
