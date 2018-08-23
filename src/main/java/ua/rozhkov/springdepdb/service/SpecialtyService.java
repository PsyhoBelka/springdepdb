package ua.rozhkov.springdepdb.service;

import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.core.Specialty;
import ua.rozhkov.springdepdb.DAO.repository.SpecialtyRepository;

import java.util.List;

@Service
public class SpecialtyService implements BaseService<Specialty, Long> {
    private SpecialtyRepository specialtyRepository;

    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }


    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findSpecialtyById(id);
    }

    @Override
    public List<Specialty> findAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty findByName(String name) {
        return specialtyRepository.findSpecialtyByName(name);
    }

    @Override
    public Long add(Specialty newSpecialty) {
        return specialtyRepository.save(newSpecialty).getId();
    }

    @Override
    public Long update(Specialty updatedSpecialty) {
        return specialtyRepository.save(updatedSpecialty).getId();
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
