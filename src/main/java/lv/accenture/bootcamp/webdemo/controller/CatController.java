package lv.accenture.bootcamp.webdemo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.accenture.bootcamp.webdemo.model.Cat;
import lv.accenture.bootcamp.webdemo.repository.CatRepository;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class CatController {

	@Autowired
	private CatRepository catRepository;

	@GetMapping("/cats")
	public String catIndex(Model model) {
		Iterable<Cat> cats = catRepository.findAll();
		model.addAttribute("cats", cats);
		return "cats-index";

	}

	@GetMapping("/cats/add")
	public String addCatPage(Model model) {
		model.addAttribute("cat", new Cat());
		return "add-cat";
	}

	@PostMapping("/cats/add-cat")
	public String addCat(@Valid Cat catToAdd, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "add-cat";
		}
		catRepository.save(catToAdd);
		return "redirect:/cats";
	}

	@GetMapping("cats/edit/{id}")
	public String editCatPage(@PathVariable Long id, Model model) {
		
		Optional<Cat> catToEdit = catRepository.findById(id);
		model.addAttribute("cat", catToEdit.get());
		return "edit-cat";
	}

	@PostMapping("/cats/edit-cat/{id}")
	public String editCat(@PathVariable Long id, @Valid Cat editedCat, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "edit-cat";
		}
		editedCat.setId(id);
		catRepository.save(editedCat);
		return "redirect:/cats";
	}

	@GetMapping("/cats/delete/{id}")
	public String deleteCat(@PathVariable Long id, Model model) {
		catRepository.deleteById(id);
		return "redirect:/cats";
	}

	@GetMapping("cats/search")
	public String searchCats(@RequestParam String catName, Model model) {
		List<Cat> machedCats = catRepository.findByNickname(catName);
		model.addAttribute("cats", machedCats);
		return "cats-index";
	}
}
