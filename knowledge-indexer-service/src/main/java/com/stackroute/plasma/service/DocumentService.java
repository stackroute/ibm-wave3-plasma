package com.stackroute.plasma.service;

import com.stackroute.plasma.model.Document;

public interface DocumentService {
    public Document create(Document description);
    public Document update(Document description);
    public Document delete(long id);
    public Document delete(String timestamp);
    public Document delete(String concept, String domain);
}
