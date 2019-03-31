package com.konarzewski.controler;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.konarzewski.domain.Article;
import com.konarzewski.domain.Profile;
import com.konarzewski.repository.ProfileRepository;

@Controller
public class ReviewerController {

	@Autowired
	ProfileRepository profileRepository;

	@RequestMapping("/reviewerAcceptedArticles")
	public String reviewerAcceptedArticles(Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		
		Set<Article> articles = user.getArticles();
		Set<Article> articlesOut = new HashSet<>();
		for(Article a : articles) {
			if(a.isAccepted() == true) {}
			articlesOut.add(a);
		}
		
		model.addAttribute("articles", articlesOut);
		return "ReviewerAcceptedArticles";
	} 
}
