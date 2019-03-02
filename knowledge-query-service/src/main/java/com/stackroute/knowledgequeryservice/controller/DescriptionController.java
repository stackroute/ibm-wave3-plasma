package com.stackroute.knowledgequeryservice.controller;

import com.stackroute.knowledgequeryservice.model.Description;
import com.stackroute.knowledgequeryservice.model.Descriptions;
import com.stackroute.knowledgequeryservice.model.Tag;
import com.stackroute.knowledgequeryservice.service.DescriptionService;
import com.stackroute.knowledgequeryservice.service.RabbitMQListener;
import com.stackroute.knowledgequeryservice.service.RabbitMQSender;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
@Api(description = "Read operation on description nodes present in knowledge graph")
public class DescriptionController {

    @Autowired
    DescriptionService descriptionService;

    @Autowired
    RabbitMQListener rabbitMQListener;

    @Autowired
    RabbitMQSender rabbitMQSender;

    /*
    @GetMapping("get")
    public List<Description> getAll(){
        return descriptionService.getAll();
    }
    */

    @GetMapping("get")
    public List<List<Description>> concept(){
        Tag tag = rabbitMQListener.getTag();
        Descriptions sender = new Descriptions();
        sender.setDescriptions(descriptionService.concept(tag.getTaggedConcept(),tag.getTaggedLevel()));
        rabbitMQSender.sender(sender);
        return descriptionService.concept(tag.getTaggedConcept(),tag.getTaggedLevel());
    }
}
