package com.konarzewski.controler;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.konarzewski.domain.Conference;
import com.konarzewski.domain.Profile;
import com.konarzewski.enumeration.RoleType;
import com.konarzewski.repository.ConferenceRepository;
import com.konarzewski.repository.ProfileRepository;

@Controller
public class AccountController {
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	ConferenceRepository conferenceRepository;

	@RequestMapping("/profileDetails")
	public String editProfile(Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		model.addAttribute("fName", user.getfName());
		model.addAttribute("lName", user.getlName());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("bDate", user.getbDate());
		return "editProfile";
	}
	
	@RequestMapping("/homeManager")
	public String homeManager() {
		return "homeMenager";
	}
	
	@RequestMapping("/homeUser")
	public String homeUser(Model model) {
		List<Conference> conferences = new ArrayList<>(conferenceRepository.findAllConferenceByName(""));
		model.addAttribute("conf", conferences);	
		return "homeUser";
	}

	@RequestMapping("/homeSpeaker")
	public String homeSpeaker(Model model) {
		List<Conference> conferences = new ArrayList<>(conferenceRepository.findAllConferenceByName(""));
		model.addAttribute("conf", conferences);	
		return "homeSpeaker";
	}
	
	@RequestMapping("/homeAdmin")
	public String homeAdmin(Model model) {
		List<Conference> conferences = new ArrayList<>(conferenceRepository.findAllConferenceByName(""));
		model.addAttribute("conf", conferences);	
		return "homeAdmin";
	}
	
	@RequestMapping("/homeReviewer")
	public String homeReviewer(Model model) {
		List<Conference> conferences = new ArrayList<>(conferenceRepository.findAllConferenceByName(""));
		model.addAttribute("conf", conferences);	
		return "homeReviewer";
	}
}
