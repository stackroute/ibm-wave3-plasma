package com.stackroute.plasma.controller;



import com.stackroute.plasma.domain.SearchOutput;
import com.stackroute.plasma.domain.Url;
import com.stackroute.plasma.service.DocumentService;
//import com.stackroute.plasma.service.RabbitMQSender;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DocumentController {
    private DocumentService documentService;
    private ResponseEntity<?> responseEntity;
    private Url url;



    @GetMapping("doc")
    public ResponseEntity<?> getContent() throws IOException {


        //rabbitMQSender.send((documentService.getHtml()));
        //return new ResponseEntity(documentService.getHtml(), HttpStatus.OK);
    }


}
