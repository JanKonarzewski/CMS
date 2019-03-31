package com.konarzewski.controler;

import java.io.IOException;
import java.security.Principal;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.konarzewski.domain.Article;
import com.konarzewski.domain.Conference;
import com.konarzewski.domain.Profile;
import com.konarzewski.repository.ArticleRepository;
import com.konarzewski.repository.ConferenceRepository;
import com.konarzewski.repository.ProfileRepository;

@Controller
public class ArticleController {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	ConferenceRepository conferenceRepository;

	@RequestMapping("/submitArticleView")
	public String submitArticleView(@RequestParam("conferenceID") Integer conference, Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		model.addAttribute("ownerID", user.getProfileId());
		model.addAttribute("conferenceID", conference);
		System.out.println("conference Id: " +conference);
		return "submitArticle";
	}
	
	@RequestMapping("/OwnUserArticles")
	public String userArticles(Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		model.addAttribute("articles", user.getArticles());
		return "OwnUserArticles";
	}

	@RequestMapping("/OwnSpeakerArticles")
	public String OwnSpeakerArticles(Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		model.addAttribute("articles", user.getArticles());
		return "OwnSpeakerArticles";
	}
	
	@RequestMapping("/OwnReviewerArticles")
	public String OwnReviewerArticles(Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		model.addAttribute("articles", user.getArticles());
		return "OwnReviewerArticles";
	}


	@RequestMapping("/OwnManagerArticles")
	public String OwnManagerArticles(Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		model.addAttribute("articles", user.getArticles());
		return "OwnManagerArticles";
	}

	@RequestMapping("/submitArticle")
	public String submitArticleView(@RequestParam("conferenceID") Integer conferenceID,
			@RequestParam("ownerID") Integer ownerID,
			@RequestAttribute("file") MultipartFile file, Model model) {
		model.addAttribute("ownerID",  ownerID);
		model.addAttribute("conferenceID",conferenceID);
		String article = null;
		String title = null;
		if(file == null) {
			return "redirect:/submitArticle?error";		
		}
		try {
			article = new String(file.getBytes());
		} catch (IOException e) {
			return "redirect:/submitArticle?error";
		}	
		Conference con = conferenceRepository.findById(conferenceID).get();
		Profile pro = profileRepository.findById(ownerID).get();
		Article art = new Article();
		System.out.println("calendar" + Calendar.getInstance().toString());
		art.setProfile(pro);
		art.setConference(con);
		art.setSubmitionDate(Calendar.getInstance().getTime().toString());
		art.setTitle(file.getOriginalFilename());
		art.setContent(article);
		art.setAccepted(false);
		articleRepository.save(art);
		return "redirect:/submitArticleView?ArticleSucssesfullyUploaded";
	}
}
