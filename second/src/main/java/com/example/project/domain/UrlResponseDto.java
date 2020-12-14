package com.example.project.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UrlResponseDto {
    private String origin;
    private String shorten;

    @Builder
    public UrlResponseDto(Url entity){
        this.origin=entity.getOrigin();
        this.shorten=entity.getShorten();
    }

}
