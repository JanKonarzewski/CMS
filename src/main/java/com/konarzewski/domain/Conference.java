package com.konarzewski.domain;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Conference {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "conference_id")
	private Integer conferenceID;
	@Column(name = "name")
	private String name;
	@Column(name = "venue")
	private String venue;
	@Column(name = "start")
	private String start;
	@Column(name = "end")
	private String end;
	@OneToOne()
	private Profile manager;
	@ManyToMany()
	private List<Profile> quests;
	@OneToMany(mappedBy = "conference")
	private List<Event> events;
	@OneToMany(mappedBy = "conference", fetch = FetchType.EAGER)
	private Set<Accommodation> accommodation;
	@OneToMany(mappedBy = "conference", fetch = FetchType.EAGER)
	private Set<Travel> travel;
	@OneToMany(mappedBy = "conference", fetch = FetchType.EAGER)
	private Set<Article> articles;

	public Conference() {
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public Set<Accommodation> getAccommodation() {
		return accommodation;
	}

	public Set<Travel> getTravel() {
		return travel;
	}

	public void setTravel(Set<Travel> travel) {
		this.travel = travel;
	}

	public void setAccommodation(Set<Accommodation> accommodation) {
		this.accommodation = accommodation;
	}

	public Profile getManager() {
		return manager;
	}

	public void setManager(Profile manager) {
		this.manager = manager;
	}

	public Integer getConferenceID() {
		return conferenceID;
	}

	public void setConferenceID(Integer conferenceID) {
		this.conferenceID = conferenceID;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public List<Profile> getQuests() {
		return quests;
	}

	public void setQuests(List<Profile> quests) {
		this.quests = quests;
	}

}
