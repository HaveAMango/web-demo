package lv.accenture.bootcamp.webdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatController {

	@GetMapping("/cats")
	public String catIndex() {
		return "cats-index";

	}
}
