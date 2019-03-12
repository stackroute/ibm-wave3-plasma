package com.stackroute.plasma.controller;


import com.stackroute.plasma.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1")
public class DocumentController {
    @Autowired
    private DocumentService documentService;
    private ResponseEntity<?> responseEntity;

    String docString;

    @GetMapping("/doc")
    public ResponseEntity<?> getContent() throws IOException {
        return new ResponseEntity<>(documentService.getHtml(),HttpStatus.OK);
    }

    @GetMapping("hello")
    public String hello(){
        return "this is https";
    }

}
