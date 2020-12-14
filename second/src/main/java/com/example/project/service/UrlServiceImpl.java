package com.example.project.service;

import com.example.project.domain.Url;
import com.example.project.domain.UrlRepository;
import com.example.project.domain.UrlResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UrlServiceImpl implements UrlService{
    @Autowired
    private UrlRepository urlRepository;

    @Override
    public UrlResponseDto urlToShort(String url){
        if(!isValidUrl(url)) return null;

        UrlResponseDto exist=getExistData(url);
        if(exist!=null) return exist;

        int randomNum=(int)(Math.random()*Integer.MAX_VALUE+1);
        while(!isValidRandomNum(randomNum)) randomNum=(int)(Math.random()*Integer.MAX_VALUE+1);
        System.out.println(randomNum);

        String shortenUrl="http://localhost:8080/"+decimalToN(randomNum);
        Url newUrl=new Url(url, shortenUrl, randomNum);
        urlRepository.save(newUrl);

        return new UrlResponseDto(newUrl);
    }

    @Override
    @Transactional
    public UrlResponseDto getExistData(String url){
        UrlResponseDto dto=urlRepository.findByOrigin(url);
        if(dto!=null) return dto;

        dto=urlRepository.findByShorten(url);
        return dto;
    }

    @Override
    public boolean isValidRandomNum(int num){
//        List<Url> data=urlRepository.findAll();
//        for(Url u:data){
//            if(u.getRandomNum()==num) return false;
//        }
        return urlRepository.findByRandomNum(num) == null;
//        return true;
    }

    @Override
    public String decimalToN(int randomNum){
        char[] map="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        int quotient=randomNum/62;
        int rest=randomNum%62;

        return quotient==0? map[rest]+"" : decimalToN(quotient)+map[rest];
    }

    @Override
    public boolean isValidUrl(String url){
        return url.startsWith("http://") || url.startsWith("https://");
    }
}
