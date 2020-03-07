package lv.accenture.bootcamp.webdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lv.accenture.bootcamp.webdemo.model.Cat;
import lv.accenture.bootcamp.webdemo.repository.CatRepository;

import org.springframework.ui.Model;
@Controller
public class CatController {
	
	@Autowired
	private CatRepository catRepository;

	@GetMapping("/cats")
	public String catIndex(Model model) {
		List <Cat> cats = catRepository.findAll();
		model.addAttribute("cats", cats);
		return "cats-index";

	}
	@GetMapping("/cats/add")
	public String addCatPage(Model model) {
		model.addAttribute("cat", new Cat());
		return "add-cat";
	}
	
	
	@PostMapping("/cats/add-cat")
	public String addCat(Cat catToAdd) {
		catRepository.add(catToAdd);
		return "redirect:/cats";
	}
	
	@GetMapping("cats/edit/{id}")
	public String editCatPage(@PathVariable Long id, Model model) {
		Cat catToEdit = catRepository.findById(id);
		model.addAttribute("cat", catToEdit);
		return "edit-cat";
	}
	
	@PostMapping("/cats/edit-cat/{id}")
	public String editCat(@PathVariable Long id, Cat editedCat) {
		editedCat.setId(id);
		System.out.println("Changed id: "+ editedCat.getId());
		System.out.println("Changed nnickname: "+ editedCat.getNickname());
		
		catRepository.update(editedCat);
		return "redirect:/cats";
	}
	@GetMapping("/cats/delete/{id}")
	public String deleteCat(@PathVariable Long id, Model model) {
		catRepository.delete(id);
		return "redirect:/cats";
	}

}
