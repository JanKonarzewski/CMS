package com.konarzewski.controler;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.konarzewski.domain.Article;
import com.konarzewski.domain.Profile;
import com.konarzewski.domain.Role;
import com.konarzewski.enumeration.RoleType;
import com.konarzewski.repository.ArticleRepository;
import com.konarzewski.repository.ProfileRepository;

@Controller()
public class ManagerController {
	
	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	@RequestMapping("/manageAccount")
	public String manageAccount(Principal principal) {
//		String email = principal.getName();
//		Profile user = profileRepository.findByEmail(email);
//		
//		profileRepository.;
		return "manageAccount";
	}
	
	@RequestMapping("/userList")
	public String userList(Model model) {
		List<Profile> profiles = new ArrayList<>(profileRepository.findAllUsers());
		model.addAttribute("users", profiles);
		return "assignReviewer";
	}
	
	@RequestMapping("/assignReviewerArticles")
	public String assignReviewerArticles(@RequestParam("userID") Integer userID, Model model, Principal principal) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		
		List<Article> articles = new ArrayList<>(articleRepository.findAllArticles());
		List<Article> articlesOut = new ArrayList<>();
		for(Article a: articles) {
			if(a.getConference().getConferenceID()  == user.getManagedConference().getConferenceID()) {
				System.out.println("Article: " + a.getTitle());
				articlesOut.add(a);
			}
		}
		
		model.addAttribute("articles", articlesOut);
		model.addAttribute("userID", userID);
		System.out.println("here");
		return "assignReviewerArticles";
	}
	
	@RequestMapping("/assignReviewer")
	public String assignReviewer(@RequestParam("userID") Integer userID, @RequestParam("articleID") Integer articleID, 
			Model model) {
		boolean flag = false;
		Article art = articleRepository.findById(articleID).get();
		Profile pro = profileRepository.findById(userID).get();
		if(art.getProfile().getProfileId() == pro.getProfileId()) {
			return "redirect:/userList?ErrorArticleBelongsToUser";
		}
		for(Role r : pro.getRoles()) {
			if(r.getRole() == RoleType.ROLE_ADMIN || r.getRole() == RoleType.ROLE_REVIEWER) {
				flag = true;
			}
		}
		if(flag == false) {
			Role rol = new Role();
			rol.setRole(RoleType.ROLE_REVIEWER);
			List<Role> roles = new ArrayList<>();
			roles.add(rol);
			pro.setRoles(roles);
			profileRepository.save(pro);
		}
		Set<Profile> reviewers = art.getReviewers();
		reviewers.add(pro);
		art.setReviewers(reviewers);
		articleRepository.save(art);
		
		return "redirect:/userList?Reviewer_succesfully_Assign";
	}
		
}
	