package fr.janua.controller;

import fr.janua.model.Hero;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/heroes")
public class HeroController {

	private List<Hero> someHeroes = Arrays.asList(new Hero(1, "Ken"), new Hero(2, "Yannick"), new Hero(3, "Pieter"));

	@GetMapping
	public List<Hero> heroes() {
		return someHeroes;
	}

	@GetMapping("/{id}")
	public Hero hero(@PathVariable("id") String id) {
		return someHeroes.stream().filter(h -> Integer.toString(h.getId()).equals(id)).findFirst().orElse(null);
	}

}
