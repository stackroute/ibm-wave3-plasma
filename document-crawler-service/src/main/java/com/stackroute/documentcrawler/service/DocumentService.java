package com.stackroute.documentcrawler.service;

import com.stackroute.documentcrawler.domain.Url;
import org.jsoup.nodes.Document;

import java.io.IOException;

public interface DocumentService {
//   Document getHtmlContent() throws IOException;

   Url getDocument() throws IOException;

}
