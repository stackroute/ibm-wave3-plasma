package com.stackroute.taggingservice.service;

import com.stackroute.taggingservice.domain.TagOutput;
import org.springframework.stereotype.Service;

@Service
public interface TagService {
    public TagOutput tagger(String lemma);

}
