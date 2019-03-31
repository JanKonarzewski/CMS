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
import com.konarzewski.domain.ArticleGrade;
import com.konarzewski.domain.Profile;
import com.konarzewski.domain.Role;
import com.konarzewski.enumeration.RoleType;
import com.konarzewski.repository.ArticleGradeRepository;
import com.konarzewski.repository.ArticleRepository;
import com.konarzewski.repository.ProfileRepository;

@Controller
public class ReviewerArticles {

	@Autowired 	
	ProfileRepository profileRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	ArticleGradeRepository articleGradeRepository;
	
	@RequestMapping("/reviewerArticles")
	public String reviewerArticles(Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		model.addAttribute("articles", user.getAssignArticles());
		return "ReviewerArticles";
	}
	
	@RequestMapping("/reviewerArticlesReview")
	public String reviewerArticlesReview(@RequestParam("articleID") Integer ID, Principal principal, Model model) {
		Article a = articleRepository.findById(ID).get();
		System.out.println("article: " + a.getTitle());
		model.addAttribute("article", a);
		return "reviewArticle";
	}
	
	@RequestMapping("/rewievArticleGrade")
	public String rewievArticleGrade(@RequestParam("articleID") Integer articleID, @RequestParam("grade") String grade,
			Principal principal, Model model) {
		boolean flag = false;
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		Article art = articleRepository.findById(articleID).get();
		ArticleGrade articleGrade = articleGradeRepository.findArticleGradeBy(art.getArticleId(), user.getProfileId());
		if(articleGrade == null) {
			ArticleGrade newArticleGrade = new ArticleGrade();
			newArticleGrade.setGader(user);
			newArticleGrade.setGrade(Integer.parseInt(grade));
			newArticleGrade.setGradedArticle(art);
			articleGradeRepository.save(newArticleGrade);
		}else if(articleGrade != null) {
			articleGrade.setGrade(Integer.parseInt(grade));
			articleGradeRepository.save(articleGrade);
		}
		
		if(art.isAccepted() == false) {
			boolean isFlag = false;
			List<ArticleGrade> allGrades = new ArrayList<>(articleGradeRepository.findAllArticleGrade(art.getArticleId()));
			int sum = 0;
			int counter = 0;
			for(ArticleGrade artigrad : allGrades) {
				sum += artigrad.getGrade();
				++counter;
				if((sum/counter) >= 3 && counter >= 3) {
					art.setAccepted(true);
					articleRepository.save(art);
					Profile owner = art.getProfile();
					List<Role> role = owner.getRoles();
					for(Role ro : role) {
						if(ro.getRole().getIntRole() > 1) {
							isFlag = true;
						}
					}
					if(isFlag == false) {
						role.clear();
						Role r = new Role();
						r.setRole(RoleType.ROLE_SPREAKER);
						role.add(r);
						owner.setRoles(role);
						profileRepository.save(owner);
					}
					break;
				}
				
			}
		}
		return "ReviewerArticles";
	}
	
}
