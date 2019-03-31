package com.konarzewski.controler;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.konarzewski.domain.Article;
import com.konarzewski.domain.Profile;
import com.konarzewski.repository.ArticleRepository;
import com.konarzewski.repository.ProfileRepository;

@Controller
public class ManagerConferenceArticlesController {

	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	@RequestMapping("/manageArticles")
	public String manageArticles(Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
	
		List<Article> articles = new ArrayList<>(articleRepository.findAllArticles());
		List<Article> articlesOut = new ArrayList<>();
		for(Article a: articles) {
			if(a.getConference().getConferenceID() == user.getManagedConference().getConferenceID()) {
				articlesOut.add(a);
			}
		}
		
		model.addAttribute("articles", articlesOut);
		return "managerConferenceArticles";
	}
	
	@RequestMapping("/managerViewContent")
	public String managerViewContent(@RequestParam("articleID") Integer articleID, Model model) {
		Article art = articleRepository.findById(articleID).get();
		model.addAttribute("articles", art);
		return "managerConferenceArticlesContent";
	}

	@RequestMapping("/managerConferenceArticleDelete")
	public String 	managerConferenceArticleDelete(@RequestParam("articleID") Integer articleID, Model model) {
		Article art = articleRepository.findById(articleID).get();
		articleRepository.delete(art);
		return "redirect:/manageArticles?ArticleHasBeenDeleted";
	}

	@RequestMapping("/managerConferenceArticleAccept")
	public String 	managerConferenceArticleAccept(@RequestParam("articleID") Integer articleID, Model model) {
		Article art = articleRepository.findById(articleID).get();
		art.setAccepted(true);
		articleRepository.save(art);
		return "redirect:/manageArticles";
	}
}
