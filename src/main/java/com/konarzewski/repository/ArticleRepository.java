package com.konarzewski.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.konarzewski.domain.Accommodation;
import com.konarzewski.domain.Article;
import com.konarzewski.domain.Profile;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	@Query(value = "SELECT * FROM article", nativeQuery = true)
	Collection<Article> findAllArticles();

}