package com.example.project.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    UrlResponseDto findByOrigin(String origin);
    UrlResponseDto findByShorten(String shorten);
    UrlResponseDto findByRandomNum(int randomNum);

}
