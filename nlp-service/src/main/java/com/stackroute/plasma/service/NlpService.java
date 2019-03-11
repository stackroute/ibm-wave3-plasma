package com.stackroute.plasma.service;

import com.stackroute.plasma.model.UserQuery;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;

@Service
public interface NlpService {

    public UserQuery save(UserQuery userQuery);
    public HashSet<String> readStopWordCsvFile();
    public List<String> queryConverter(String query);
}




