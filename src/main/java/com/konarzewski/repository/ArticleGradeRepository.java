package com.konarzewski.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.konarzewski.domain.Article;
import com.konarzewski.domain.ArticleGrade;

public interface ArticleGradeRepository extends JpaRepository<ArticleGrade, Integer> {
	@Query(value = "SELECT * FROM `articlegrade` WHERE `gader_profile_id` =  ?2 AND `gradedArticle_article_id` = ?1", nativeQuery = true)
	ArticleGrade findArticleGradeBy(Integer articleID, Integer revieverID);
	
	@Query(value = "SELECT * FROM `articlegrade` WHERE `gradedArticle_article_id` = ?1", nativeQuery = true)
	Collection<ArticleGrade> findAllArticleGrade(Integer articleID);


}