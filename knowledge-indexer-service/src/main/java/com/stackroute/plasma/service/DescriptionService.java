package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Concept;
import com.stackroute.plasma.model.Description;

import java.sql.Timestamp;
import java.util.List;

public interface DescriptionService {
    public Description create(Description description);
    public Description update(Description description);
    public Description delete(long id);
    public Description delete(Timestamp timestamp);
    public Description delete(String concept, String domain);
}
