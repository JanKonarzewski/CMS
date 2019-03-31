package com.konarzewski.controler;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.konarzewski.domain.Conference;
import com.konarzewski.domain.Profile;
import com.konarzewski.domain.Role;
import com.konarzewski.enumeration.RoleType;
import com.konarzewski.repository.ConferenceRepository;
import com.konarzewski.repository.ProfileRepository;

@Controller
public class SessionController {

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ConferenceRepository conferenceRepository;

	@Autowired
	private PasswordEncoder encoder;

	@RequestMapping("/check")
	public String check() {
		System.out.println("check");
		return "home";
	}

	@RequestMapping("/signup")
	public String signup() {
		return "register";
	}

	@RequestMapping("/hello")
	public void hello() {
		System.out.println("hello");
	}

	@RequestMapping("/register")
	public String register(@RequestParam("fname") String fName, @RequestParam("lname") String lName,
			@RequestParam("username") String username, @RequestParam("email") String email,
			@RequestParam("password1") String password, @RequestParam("password2") String password2, Model model) {
		Profile profile = new Profile();
		Role role = new Role();
		profile.setEmail(email);
		profile.setfName(fName);
		profile.setlName(lName);
		profile.setPassword(encoder.encode(password));
		role.setRole(RoleType.ROLE_USER);
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		profile.setRoles(roles);
		profile.setActive(true);
		Profile check = profileRepository.findByEmail(email);
		model.addAttribute("email", email);
		if (check == null && password.equals(password2)) {
			profileRepository.save(profile);
			return "registerSucces";

		} else if (password.equals(password2) && !profileRepository.existsById(check.getProfileId())) {
			profileRepository.save(profile);
			return "registerSucces";
		} else {
			return "redirect:/?error";
		}
	}

	@RequestMapping("/")
	public String index(ModelMap model, HttpServletRequest request, Principal principal) {
		Map<String, String> links = new HashMap<>();
		if (request.isSecure()) {
			if (request.isUserInRole(RoleType.ROLE_ADMIN.getAuthority())) {
				return "Home/HomeAdmin";
			}

			if (request.isUserInRole(RoleType.ROLE_MANAGER.getAuthority())) {
				return "Home/HomeMenager";
			} else {
				List<Conference> conferences = new ArrayList<>(conferenceRepository.findAllConferenceByName(""));
				model.addAttribute("conf", conferences);

				if (request.isUserInRole(RoleType.ROLE_REVIEWER.getAuthority())) {
					links.put("/reviewerArticles", "Revieww articles");

				}
				if (request.isUserInRole(RoleType.ROLE_SPREAKER.getAuthority())) {
					links.put("/speakerAcceptedArticles", "speakerAcceptedArticles");
				}
				if (request.isUserInRole(RoleType.ROLE_USER.getAuthority())) {
					links.put("/OwnUserArticles", "Submited articles");
				}
				model.addAttribute("links", links);
				return "Home/HomePublisherSpeakerReviewer";
			}
		} else {
			return "home";
		}
	}

	@RequestMapping("/login")
	public String login(ModelMap model, HttpServletRequest request) {

		return "login";
	}

	@RequestMapping("/profile")
	public String profile(ModelMap model, HttpServletRequest request) {
		return "profile";
	}

}
