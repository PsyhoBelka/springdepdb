package ua.rozhkov.springdepdb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.rozhkov.springdepdb.DAO.entity.core.Speciality;
import ua.rozhkov.springdepdb.service.SpecialityService;

@Controller
@RequestMapping("/speciality")
public class SpecialityController {

    private SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @RequestMapping("/list")
    public String showListSpecialitiesPage(Model model) {
        model.addAttribute("specialities", specialityService.findAll());
        return "speciality/listSpeciality";
    }

    @RequestMapping("/add")
    public String showAddSpecialityPage(Model model) {
        Speciality newSpeciality = new Speciality();
        model.addAttribute("newSpeciality", newSpeciality);
        return "speciality/addSpeciality";
    }

    @RequestMapping("/addNewSpeciality")
    public String addNewSpeciality(@ModelAttribute Speciality newSpeciality) {
        specialityService.add(newSpeciality);
        return "redirect:/speciality/list";
    }

    @RequestMapping("/edit/{id}")
    public String showEditPage(@PathVariable long id, Model model) {
        Speciality specialityToUpdate = specialityService.findById(id);
        model.addAttribute("specialityToUpdate", specialityToUpdate);
        return "speciality/editSpeciality";
    }

    @RequestMapping("/updateSpeciality")
    public String updateSpeciality(@ModelAttribute Speciality specialityToUpdate) {
        specialityService.update(specialityToUpdate);
        return "redirect:/speciality/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteSpeciality(@PathVariable long id) {
        specialityService.deleteById(id);
        return "redirect:/speciality/list";
    }

}
