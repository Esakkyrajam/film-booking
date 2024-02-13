package com.film.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.film.entity.MovieDetailsEntity;



@Repository
public interface MovieREPO extends JpaRepository<MovieDetailsEntity, Long> {

}
