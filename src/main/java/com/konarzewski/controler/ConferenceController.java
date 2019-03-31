package com.konarzewski.controler;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.konarzewski.domain.Accommodation;
import com.konarzewski.domain.Article;
import com.konarzewski.domain.Conference;
import com.konarzewski.domain.Profile;
import com.konarzewski.domain.Role;
import com.konarzewski.domain.Travel;
import com.konarzewski.enumeration.RoleType;
import com.konarzewski.repository.AccommodationRpository;
import com.konarzewski.repository.ConferenceRepository;
import com.konarzewski.repository.ProfileRepository;
import com.konarzewski.repository.TravelRepository;

@Controller
public class ConferenceController {
	@Autowired
	private ConferenceRepository conferenceRepository;
	
	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	TravelRepository travelRepository;
	
	@Autowired
	AccommodationRpository accommodatioRepository;
	
	@RequestMapping("/addEvent")
	public String addEvent() {
		return "addEvent";
	}
	
	@RequestMapping("/ConferenceDetails")
	public String ConferenceDetails(@RequestParam("conferenceId") Integer id, Model model, Principal principal) {	
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		int bRolle = 0;
		for(Role r : user.getRoles()) {
			if(r.getRole().getIntRole() > bRolle) {
				bRolle = r.getRole().getIntRole();
			}
		}
		
		model.addAttribute("userRolle", RoleType.getRolleByInt(bRolle));
		Conference con = conferenceRepository.findById(id).get();
		model.addAttribute("conference", con);
		System.out.println("HERE conferenceID: " + id);
		return "info";
	}

	@RequestMapping("/searchConferencesByNameUser")
	public String searchConferencesByNameUser(@RequestParam("byName") String byName,HttpServletRequest request,
			Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		List<Conference> conferences = new ArrayList<>(conferenceRepository.findAllConferenceByName(byName));
		model.addAttribute("conf", conferences);	
		return "homeUser";
	}
	
	@RequestMapping("/searchConferencesByNameSpeaker")
	public String searchConferencesByNameSpeaker(@RequestParam("byName") String byName,HttpServletRequest request,
			Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		List<Conference> conferences = new ArrayList<>(conferenceRepository.findAllConferenceByName(byName));
		model.addAttribute("conf", conferences);	
		return "homeSpeaker";
	}
	
	@RequestMapping("/searchConferencesByNameReviewer")
	public String searchConferencesByNameReviewer(@RequestParam("byName") String byName,HttpServletRequest request,
			Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		List<Conference> conferences = new ArrayList<>(conferenceRepository.findAllConferenceByName(byName));
		model.addAttribute("conf", conferences);	
		return "homeReviewer";
	}
	
	@RequestMapping("/ad")
	public String ad() {
		return "add";
	}

	@RequestMapping("/addConference")
	public String addConference(@RequestParam("name") String name, @RequestParam("venue") String venue,
			Model model) {
		Conference con = new Conference();
		con.setName(name);
		con.setVenue(venue);
		conferenceRepository.save(con);
		return "homeUser";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}

	@RequestMapping(value="/accommodationInformation")
	public String accommodationInformation(@RequestParam("conferenceId") Integer id, Model model) {
		model.addAttribute("conferenceID", id);
		Conference conference = conferenceRepository.findById(id).get();
		model.addAttribute("accommodation", conference.getAccommodation());	
		return "accommodationInformation";
	}
	
	@RequestMapping(value="/conferenceArticles")
	public String conferenceArticles(@RequestParam("conferenceId") Integer id, Model model) {
		model.addAttribute("conferenceID", id);
		Conference conference = conferenceRepository.findById(id).get();
		Set<Article> articles = conference.getArticles();
		Set<Article> artilesOut = new HashSet<>();
		for(Article a: articles) {
			if(a.isAccepted() == true) {
				artilesOut.add(a);
			}
		}
		model.addAttribute("articles", artilesOut);	
		return "conferenceArticles";
	}
	
	
	@RequestMapping(value="/travelInformation")
	public String travelInformation(@RequestParam("conferenceId") Integer id, Model model) {
		model.addAttribute("conferenceID", id);
		Conference conference = conferenceRepository.findById(id).get();
		model.addAttribute("travel", conference.getTravel());	
		return "travelInformation";
	}

	@RequestMapping(value="/addConferenceDetails")
	public String addConferenceDetails(Model model) {
		return "AddConferenceDetails";
	}
	
	@RequestMapping(value="/addConferenceTravel")
	public String addConferenceTravel(@RequestParam("content") String content,@RequestParam("header") String header,
			@RequestParam("price") String price, Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		Conference conference = user.getManagedConference();
		Travel travel = new Travel();
		travel.setConference(conference);
		travel.setHeader(header);
		travel.setContent(content);
		travel.setPrice(price);
		travelRepository.save(travel);
		return "redirect:/addConferenceDetails?TravelInformationAddedSuccessfuly";
	}
	
	@RequestMapping(value="/addConferenceAccomnodation")
	public String addConferenceAccomnodation(@RequestParam("content") String content,@RequestParam("header") String header,
			@RequestParam("price") String price, @RequestParam("address") String address, Principal principal, Model model) {
		String email = principal.getName();
		Profile user = profileRepository.findByEmail(email);
		Conference conference = user.getManagedConference();
		Accommodation accommodation = new Accommodation();
		accommodation.setAddres(address);
		accommodation.setConference(conference);
		accommodation.setContent(content);
		accommodation.setHeader(header);
		accommodation.setPrice(price);
		accommodatioRepository.save(accommodation);
		return "redirect:/addConferenceDetails?AccommodationAddedSuccessfuly";
	}
}
