package com.stackroute.plasma.service;

import java.util.HashSet;
import java.util.List;


public interface NlpService {

    public HashSet<String> readStopWordCsvFile();
    public List<String> queryConverter(String query);
}




