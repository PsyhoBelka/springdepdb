package ua.rozhkov.springdepdb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.rozhkov.springdepdb.DAO.entity.core.Base;
import ua.rozhkov.springdepdb.DAO.entity.core.College;
import ua.rozhkov.springdepdb.DAO.entity.core.OwnerShip;
import ua.rozhkov.springdepdb.DAO.entity.core.Specialty;
import ua.rozhkov.springdepdb.service.CollegeService;
import ua.rozhkov.springdepdb.service.CollegeSpecialityService;
import ua.rozhkov.springdepdb.service.SpecialityService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/college")
public class CollegeController {

    private CollegeService collegeService;
    private List<OwnerShip> collegeOwnerShips;
    private SpecialityService specialityService;
    private CollegeSpecialityService collegeSpecialityService;

    public CollegeController(CollegeService collegeService, SpecialityService specialityService, CollegeSpecialityService collegeSpecialityService) {
        this.collegeService = collegeService;
        collegeOwnerShips = Arrays.asList(OwnerShip.values());
        this.specialityService = specialityService;
        this.collegeSpecialityService = collegeSpecialityService;
    }

    @RequestMapping("/list")
    public String showListCollegesPage(Model model) {
        model.addAttribute("colleges", collegeService.findAll());
        return "college/listColleges";
    }

    @RequestMapping("/add")
    public String showAddCollegePage(Model model) {
        College newCollege = new College();
        model.addAttribute("ownerShips", collegeOwnerShips);
        model.addAttribute("newCollege", newCollege);
        List<Specialty> specialities = specialityService.findAll();
        model.addAttribute("specialities", specialities);
        return "college/addCollege";
    }

    @RequestMapping("/addNewCollege")
    public String addNewCollege(@ModelAttribute College newCollege,
                                @RequestParam("checkedSpecialities") List<String> checkedSpecialities) {
        List<Specialty> checkedSpecialtyList = new ArrayList<>();
        for (String id :
                checkedSpecialities) {
            checkedSpecialtyList.add(specialityService.findById(Long.parseLong(id)));
        }
        College tmpCollege = collegeService.findById(collegeService.add(newCollege));
        collegeSpecialityService.addSpecialitiesToCollege(tmpCollege, checkedSpecialities, 5, Base.NINE_CLASS);
        return "redirect:/college/list";
    }

    @RequestMapping("/edit/{id}")
    public String showEditPage(@PathVariable long id, Model model) {
        model.addAttribute("ownerShips", collegeOwnerShips);
        College collegeToUpdate = collegeService.findById(id);
        model.addAttribute("collegeToUpdate", collegeToUpdate);
        return "college/editCollege";
    }

    @RequestMapping("/updateCollege")
    public String updateCollege(@ModelAttribute College collegeToUpdate) {
        collegeService.update(collegeToUpdate);
        return "redirect:/college/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCollege(@PathVariable long id) {
        collegeService.deleteById(id);
        return "redirect:/college/list";
    }


}
