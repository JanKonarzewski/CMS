package com.konarzewski.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ArticleGrade {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer articleGradeID;
	private Integer grade;
	private String comment;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	private Profile gader;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	private Article gradedArticle;
	
	
	
	public ArticleGrade() {
	}
	public Integer getArticleGradeID() {
		return articleGradeID;
	}
	public void setArticleGradeID(Integer articleGradeID) {
		this.articleGradeID = articleGradeID;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Profile getGader() {
		return gader;
	}
	public void setGader(Profile gader) {
		this.gader = gader;
	}
	public Article getGradedArticle() {
		return gradedArticle;
	}
	public void setGradedArticle(Article gradedArticle) {
		this.gradedArticle = gradedArticle;
	}
}
