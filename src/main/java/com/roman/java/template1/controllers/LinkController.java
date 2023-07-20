package com.roman.java.template1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import com.roman.java.template1.entities.Link;
import com.roman.java.template1.services.LinkService;
import java.util.List;

@RestController
@RequestMapping("/api/links")
public class LinkController {

    private LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping
    @ApiOperation(value = "Get all project info url links")
    public ResponseEntity<List<Link>> getAllLinks() {
        return ResponseEntity.status(HttpStatus.OK).body(linkService.getAllLinks());
    }
}

