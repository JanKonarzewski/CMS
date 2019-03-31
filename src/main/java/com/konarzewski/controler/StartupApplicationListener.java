package com.konarzewski.controler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.konarzewski.domain.Accommodation;
import com.konarzewski.domain.Article;
import com.konarzewski.domain.Conference;
import com.konarzewski.domain.Profile;
import com.konarzewski.domain.Role;
import com.konarzewski.domain.Travel;
import com.konarzewski.enumeration.RoleType;
import com.konarzewski.repository.AccommodationRpository;
import com.konarzewski.repository.ArticleRepository;
import com.konarzewski.repository.ConferenceRepository;
import com.konarzewski.repository.ProfileRepository;
import com.konarzewski.repository.TravelRepository;

@Component
public class StartupApplicationListener {

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

	@EventListener(classes={ContextStartedEvent.class })
	public void onApplicationEvent() {
		System.out.print("Application initialization ");
		Profile user = new Profile();
		List<Role> userRoles = new ArrayList<>();
		Role userRole = new Role();
		userRole.setRole(RoleType.ROLE_ADMIN);
		userRoles.add(userRole);
		user.setfName("admin");
		user.setlName("admin");
		user.setEmail("admin");
		user.setPassword(encoder.encode("admin"));
		user.setRoles(userRoles);

		Profile user3 = new Profile();
		List<Role> userRoles3 = new ArrayList<>();
		Role userRole3 = new Role();
		userRole3.setRole(RoleType.ROLE_USER);
		userRoles3.add(userRole3);
		user3.setfName("user3");
		user3.setlName("user3");
		user3.setEmail("user3");
		user3.setPassword(encoder.encode("user3"));
		user3.setRoles(userRoles3);
		profileRepository.save(user3);

		Profile Reviewer = new Profile();
		List<Role> userRoles30 = new ArrayList<>();
		Role userRole30 = new Role();
		userRole30.setRole(RoleType.ROLE_REVIEWER);
		userRoles30.add(userRole30);
		Reviewer.setfName("reviewer");
		Reviewer.setlName("reviewer");
		Reviewer.setEmail("reviewer");
		Reviewer.setPassword(encoder.encode("reviewer"));
		Reviewer.setRoles(userRoles30);
		profileRepository.save(Reviewer);

		Profile user4 = new Profile();
		List<Role> userRoles4 = new ArrayList<>();
		Role userRole4 = new Role();
		userRole4.setRole(RoleType.ROLE_USER);
		userRoles4.add(userRole4);
		user4.setfName("user4");
		user4.setlName("user4");
		user4.setEmail("user4");
		user4.setPassword(encoder.encode("user4"));
		user4.setRoles(userRoles4);
		profileRepository.save(user4);

		Profile user5 = new Profile();
		List<Role> userRoles5 = new ArrayList<>();
		Role userRole5 = new Role();
		userRole5.setRole(RoleType.ROLE_USER);
		userRoles5.add(userRole5);
		user5.setfName("user5");
		user5.setlName("user5");
		user5.setEmail("user5");
		user5.setPassword(encoder.encode("user5"));
		user5.setRoles(userRoles5);
		profileRepository.save(user5);

		Profile user6 = new Profile();
		List<Role> userRoles6 = new ArrayList<>();
		Role userRole6 = new Role();
		userRole6.setRole(RoleType.ROLE_USER);
		userRoles6.add(userRole6);
		user6.setfName("user6");
		user6.setlName("user6");
		user6.setEmail("user6");
		user6.setPassword(encoder.encode("user6"));
		user6.setRoles(userRoles6);
		profileRepository.save(user6);

		Profile user7 = new Profile();
		List<Role> userRoles7 = new ArrayList<>();
		Role userRole7 = new Role();
		userRole7.setRole(RoleType.ROLE_USER);
		userRoles7.add(userRole7);
		user7.setfName("user7");
		user7.setlName("user");
		user7.setEmail("user7");
		user7.setPassword(encoder.encode("user7"));
		user7.setRoles(userRoles7);
		profileRepository.save(user7);

		Profile user8 = new Profile();
		List<Role> userRoles8 = new ArrayList<>();
		Role userRole8 = new Role();
		userRole8.setRole(RoleType.ROLE_USER);
		userRoles8.add(userRole8);
		user8.setfName("user8");
		user8.setlName("user8");
		user8.setEmail("user8");
		user8.setPassword(encoder.encode("user8"));
		user8.setRoles(userRoles8);
		profileRepository.save(user8);

		Profile speaker = new Profile();
		List<Role> userRoles9 = new ArrayList<>();
		Role userRole9 = new Role();
		userRole9.setRole(RoleType.ROLE_SPREAKER);
		userRoles9.add(userRole9);
		speaker.setfName("speaker");
		speaker.setlName("speaker");
		speaker.setEmail("speaker");
		speaker.setPassword(encoder.encode("speaker"));
		speaker.setRoles(userRoles9);
		profileRepository.save(speaker);

		Profile manager = new Profile();
		List<Role> userRoles1 = new ArrayList<>();
		Role userRole1 = new Role();
		userRole1.setRole(RoleType.ROLE_MANAGER);
		userRoles1.add(userRole1);
		manager.setfName("manager");
		manager.setlName("manager");
		manager.setEmail("manager");
		manager.setPassword(encoder.encode("manager"));
		manager.setRoles(userRoles1);
		profileRepository.save(user);
		profileRepository.save(manager);

		Conference conf = new Conference();
		conf.setName("konferencja");
		conf.setVenue("wroclaw");
		conf.setStart("12/13/2010");
		conf.setEnd("12/13/2009");
		conf.setManager(manager);
		conferenceRepository.save(conf);

		Conference conf3 = new Conference();
		conf3.setName("konferencja Warszawska");
		conf3.setVenue("Warszawa");
		conf3.setStart("12/13/2010");
		conf3.setEnd("12/13/2009");
		conferenceRepository.save(conf3);

		Conference conf4 = new Conference();
		conf4.setName("konferencja PWR");
		conf4.setVenue("PWR");
		conf4.setStart("12/13/2010");
		conf4.setEnd("12/13/2009");
		conferenceRepository.save(conf4);

		Accommodation ac1 = new Accommodation();
		ac1.setHeader("Luxury appartment");
		ac1.setContent("Appartment placed 10min from the conference main building");
		ac1.setConference(conf);
		ac1.setPrice("30");
		ac1.setAddres("ul.Wyspianskiego 34/3");
		Accommodation ac2 = new Accommodation();
		ac2.setHeader("Hostel");
		ac2.setContent("Cheap place to sleeps");
		ac2.setConference(conf);
		ac2.setPrice("0.5 (nk) novigradzkich koron");
		ac2.setAddres("ul.brucelee 34/1");
		accommodationRepository.save(ac1);
		accommodationRepository.save(ac2);

		Travel t1 = new Travel();
		t1.setHeader("Travel info 1");
		t1.setContent("Travel content 1");
		t1.setConference(conf);
		t1.setPrice("30");
		Travel t2 = new Travel();
		t2.setHeader("Travel info 1");
		t2.setContent("Travel content 1");
		t2.setConference(conf);
		t2.setPrice("40");
		travelRepository.save(t1);
		travelRepository.save(t2);

		Article art = new Article();
		art.setAccepted(false);
		art.setConference(conf);
		art.setContent("this is content");
		art.setProfile(user);
		art.setSubmitionDate(Calendar.getInstance().getTime().toString());
		art.setTitle("this is title");
		articleRepository.save(art);
	}

}
