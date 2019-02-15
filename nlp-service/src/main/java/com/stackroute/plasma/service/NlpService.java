package com.stackroute.plasma.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public interface NlpService {

    public HashSet<String> readStopWordCsvFile();
    public List<String> queryConverter(String query);
}




