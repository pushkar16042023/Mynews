package com.example.mynews;

import com.example.mynews.models.Articles;

import java.util.List;

public interface onfetchdatalistener<newsapiresponse>{
    void onfetchdata(List<Articles> list, String message);
    void onerror (String manager);
}
