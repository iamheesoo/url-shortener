package com.example.project.service;

import com.example.project.domain.UrlResponseDto;

public interface UrlService {
    UrlResponseDto urlToShort(String url);
    UrlResponseDto getExistData(String url);
    boolean isValidRandomNum(int num);
    String decimalToN(int randomNum);
    boolean isValidUrl(String url);
}
