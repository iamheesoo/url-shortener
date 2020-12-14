package com.example.project;

import com.example.project.domain.Url;
import com.example.project.domain.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public void run(String... args) throws Exception{
//        urlRepository.save(new Url("temp", "changed", 2));
//        urlRepository.save(new Url("temp2", "changed2", 3));
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

}
