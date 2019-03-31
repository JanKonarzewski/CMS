package com.konarzewski.domain;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "article")
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private Integer articleId;
	@Column(name = "title", nullable = false, length = 50)
	private String title;
	@Column(name = "content", nullable = false, length = 500)
	private String content;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "conference_id")
	private Conference conference;
	
	private boolean accepted;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "owner_id")
	private Profile profile;
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Profile> reviewers;
	
	@Column(name="submition_date", length= 100)
	private String submitionDate;
	@OneToMany(mappedBy="gradedArticle")
	private Set<ArticleGrade> grades;
	
	public Article() {
	}

	
	public String getSubmitionDate() {
		return submitionDate;
	}


	public Set<ArticleGrade> getGrades() {
		return grades;
	}


	public void setGrades(Set<ArticleGrade> grades) {
		this.grades = grades;
	}


	public Set<Profile> getReviewers() {
		return reviewers;
	}


	public void setReviewers(Set<Profile> reviewers) {
		this.reviewers = reviewers;
	}


	public void setSubmitionDate(String submitionDate) {
		this.submitionDate = submitionDate;
	}


	public Conference getConference() {
		return conference;
	}

	public void setConference(Conference conference) {
		this.conference = conference;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
