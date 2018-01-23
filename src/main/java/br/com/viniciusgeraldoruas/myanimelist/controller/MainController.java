package br.com.viniciusgeraldoruas.myanimelist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.viniciusgeraldoruas.myanimelist.cliente.MALCliente;
import br.com.viniciusgeraldoruas.myanimelist.modelo.Anime;
import br.com.viniciusgeraldoruas.myanimelist.modelo.Manga;

@Controller
public class MainController {

	@Autowired
	private MALCliente cliente;
	
	@RequestMapping("pesquisa")
	public String pesquisa(@RequestParam String title, Model model) {
		Anime anime = cliente.pesquisaAnime(title);
		Manga manga = cliente.pesquisaManga(title);
		model.addAttribute("anime", anime);
		model.addAttribute("manga", manga);
		return "lista";
	}
}
