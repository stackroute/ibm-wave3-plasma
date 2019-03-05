package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.Url;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;


@Service
public interface DocumentService {
   public List<Url> getHtml() throws IOException;
}
