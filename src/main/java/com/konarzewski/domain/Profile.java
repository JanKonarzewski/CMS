package com.konarzewski.domain;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NaturalId;

@Entity(name = "profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profile_id")
	private Integer profileId;

	@Column(name = "fname", nullable = false)
	private String fName;

	@Column(name = "lname", nullable = false)
	private String lName;
	@NaturalId
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "bDate", nullable = true)
	@Temporal(TemporalType.DATE)
	private Calendar bDate;
	@Column(name = "cDate", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar cDate;
	@Column(name = "active", nullable = true)
	private boolean active;
	@OneToOne(mappedBy="manager")
	private Conference managedConference;
	@OneToMany(mappedBy = "profile",  fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	private Set<Article> articles;
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "owner_id")
	private List<Role> roles;
	@ManyToMany(mappedBy="quests")
	private List<Conference> cenferences;
	@ManyToMany(mappedBy="reviewers",fetch=FetchType.EAGER)
	private Set<Article> assignArticles;
	@OneToMany(mappedBy="gader")
	private Set<ArticleGrade> gradedArticle;
	
	public Profile() {
	}
	

	public Set<ArticleGrade> getGradedArticle() {
		return gradedArticle;
	}


	public void setGradedArticle(Set<ArticleGrade> gradedArticle) {
		this.gradedArticle = gradedArticle;
	}


	public Set<Article> getAssignArticles() {
		return assignArticles;
	}


	public void setAssignArticles(Set<Article> assignArticles) {
		this.assignArticles = assignArticles;
	}


	public Conference getManagedConference() {
		return managedConference;
	}


	public void setManagedConference(Conference managedConference) {
		this.managedConference = managedConference;
	}


	public List<Conference> getCenferences() {
		return cenferences;
	}


	public void setCenferences(List<Conference> cenferences) {
		this.cenferences = cenferences;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getbDate() {
		return bDate;
	}

	public void setbDate(Calendar bDate) {
		this.bDate = bDate;
	}

	public Calendar getcDate() {
		return cDate;
	}

	public void setcDate(Calendar cDate) {
		this.cDate = cDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public Set<Article> getArticles() {
		return articles;
	}


	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	
}
