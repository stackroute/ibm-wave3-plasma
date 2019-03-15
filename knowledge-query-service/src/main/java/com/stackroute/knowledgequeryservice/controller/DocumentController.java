/*
package com.stackroute.knowledgequeryservice.controller;

import com.stackroute.knowledgequeryservice.model.Document;
import com.stackroute.knowledgequeryservice.model.Documents;
import com.stackroute.knowledgequeryservice.model.Tag;
import com.stackroute.knowledgequeryservice.service.DocumentService;
import com.stackroute.knowledgequeryservice.service.RabbitMQListener;
import com.stackroute.knowledgequeryservice.service.RabbitMQSender;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@Api(description = "Read operation on description nodes present in knowledge graph")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @Autowired
    RabbitMQListener rabbitMQListener;

    @Autowired
    RabbitMQSender rabbitMQSender;

    @GetMapping("get")
    public Documents concept(){
        Tag tag = rabbitMQListener.getTag();
        Documents sender = new Documents();
        sender.setDocuments(documentService.concept(tag.getTaggedConcept(),tag.getTaggedLevel()));
        sender.setUserId(tag.getUserId());
        sender.setJwt(tag.getJwt());
        sender.setRole(tag.getRole());
        rabbitMQSender.sender(sender);
        //return documentService.concept(tag.getTaggedConcept(),tag.getTaggedLevel());
        return sender;
    }
}
*/
