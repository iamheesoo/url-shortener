package com.example.project.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name="url")
public class Url {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String origin;

    @Column(length = 255, nullable = false)
    private String shorten;

    @Column(nullable = false)
    private int randomNum;

    @Builder
    public Url(String origin, String shorten, int randomNum){
        this.origin=origin;
        this.shorten=shorten;
        this.randomNum=randomNum;
    }
}
