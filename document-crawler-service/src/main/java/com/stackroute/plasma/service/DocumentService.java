package com.stackroute.plasma.service;

import com.stackroute.plasma.domain.Url;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public interface DocumentService {
//   Document getHtmlContent() throws IOException;

   Url getDocument() throws IOException;

}
