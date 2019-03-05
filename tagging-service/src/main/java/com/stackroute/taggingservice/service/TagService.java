package com.stackroute.taggingservice.service;

import com.stackroute.taggingservice.domain.TagInput;
import com.stackroute.taggingservice.domain.TagOutput;


public interface TagService {
    public TagOutput tagger(TagInput lemma);

}
