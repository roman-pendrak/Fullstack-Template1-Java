package com.roman.java.template1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roman.java.template1.entities.Link;
import com.roman.java.template1.repositories.LinkRepository;
import java.util.List;

@Service
public class LinkService {

    private LinkRepository linkRepository;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }
}
