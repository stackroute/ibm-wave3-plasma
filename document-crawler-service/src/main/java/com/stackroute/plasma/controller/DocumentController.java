package com.stackroute.plasma.controller;



import com.stackroute.plasma.domain.Url;
import com.stackroute.plasma.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class DocumentController {
    private DocumentService documentService;
    private ResponseEntity<?> responseEntity;
    private Url url;

    @Autowired
    public DocumentController(DocumentService documentService)
    {
        this.documentService = documentService;
    }


    @GetMapping("/doc")
    public ResponseEntity<?> getContent() throws IOException {
//        CustomResponse customResponse=new CustomResponse();
////        customResponse.setMessage(documentService.getHtmlContent().html());
//        customResponse.setObj(documentService.getDocument());
//        System.out.println(documentService.getDocument());
        return new ResponseEntity(documentService.getDocument(), HttpStatus.CREATED);

    }


}
