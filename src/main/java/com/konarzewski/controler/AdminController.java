package com.konarzewski.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.konarzewski.domain.Conference;
import com.konarzewski.domain.Profile;
import com.konarzewski.domain.Role;
import com.konarzewski.enumeration.RoleType;
import com.konarzewski.repository.AccommodationRpository;
import com.konarzewski.repository.ArticleRepository;
import com.konarzewski.repository.ConferenceRepository;
import com.konarzewski.repository.ProfileRepository;
import com.konarzewski.repository.TravelRepository;

@Controller
public class AdminController {
	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ConferenceRepository conferenceRepository;
	
	@Autowired
	private AccommodationRpository accommodationRepository;
	
	@Autowired
	private TravelRepository travelRepository;
	
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private ArticleRepository articleRepository;
	
	@RequestMapping("/AdminManageConference")
	public String CreateNewConferenceView(Model model) { 
		List<Conference> conferences = new ArrayList<>(conferenceRepository.findAllConferenceByName(""));
		model.addAttribute("conferences", conferences);
		return "CreateNewConference";
	}
	
	
	@RequestMapping("/CreateNewConference")
	public String CreateNewConference(@RequestParam("name") String name, @RequestParam("venue") String venue,
			@RequestParam("start") String start, @RequestParam("end") String end, Model model) { 
		Conference conference = new Conference();
		conference.setName(name);
		conference.setVenue(venue);
		conference.setStart(start);
		conference.setEnd(end);
		conferenceRepository.save(conference);
		return "redirect:/AdminManageConference?ConferenceCreatedSuccessfuly";
	}
	
	@RequestMapping("/AdminDeleteConference")
	public String AdminDeleteConference(@RequestParam("ConferenceID") Integer conferenceId, Model model) { 
		List<Conference> conferences = new ArrayList<>(conferenceRepository.findAllConferenceByName(""));
		conferenceRepository.deleteById(conferenceId);
		return "redirect:/AdminManageConference?ConferenceHasBeenSucessfullyDelete";
	}
	
	@RequestMapping("/AdminCreateManagerView")
	public String AdminCreateManagerView(@RequestParam("ConferenceID") Integer conferenceId, Model model) { 
		model.addAttribute("ConferenceID", conferenceId);
		return "CreateManager";
	}
	
	@RequestMapping("/AdminCreateManager")
	public String AdminCreateManager(@RequestParam("ConferenceID") Integer conferenceId,
			@RequestParam("fName") String fName, @RequestParam("lName") String lName, 
			@RequestParam("email") String email, 
			@RequestParam("password") String password, Model model) { 
		Conference conference = conferenceRepository.findById(conferenceId).get();
		Profile manager = new Profile();
		manager.setfName(fName);
		manager.setlName(lName);
		manager.setEmail(email);
		manager.setPassword(encoder.encode(password));
		List<Role> roles = new ArrayList<>();
		Role r = new Role();
		r.setRole(RoleType.ROLE_MANAGER);
		roles.add(r);
		manager.setRoles(roles);
		manager.setManagedConference(conference);
		profileRepository.save(manager);
		conference.setManager(manager);
		conferenceRepository.save(conference);
		return "redirect:/AdminManageConference?ManagerCreatedSucessfuly";
	}
}
