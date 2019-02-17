package com.stackroute.plasma.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
//import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class NlpServiceTest {


    //@InjectMocks
    @Autowired
    NlpServiceImpl nlpService=new NlpServiceImpl();
    String query;
   List<String> expectedQuery ;

    @Before
    public void setUp() throws Exception {

        //MockitoAnnotations.initMocks(this);
        query = "technologies";
         expectedQuery = Arrays.asList("technology");
        //expectedQuery.add("technologies");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testQueryConverter() {
       // nlpService.queryConverter(query);
        System.out.println(query);
        System.out.println(expectedQuery);
        //when(nlpService.queryConverter(query)).thenReturn(expectedQuery);
        Assert.assertEquals(expectedQuery, nlpService.queryConverter(query));

    }


//    when(trackRepository.save((Track)any())).thenReturn(track);
//    Track savedTrack = trackService.saveTrack(track);
//        Assert.assertEquals(track,savedTrack);
//
//    verify(trackRepository,times(1)).save(track);


//    @Mock
//    private TrackRepository trackRepository;
//
//    @InjectMocks
//    private TrackServiceImpl trackService;
//
//    List<Track> list = null;
//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//        track = new Track();
//        track.setTrackId(1);
//        track.setTrackName("terebin");
//        track.setComment("good");
//        list = new ArrayList<>();
//        list.add(track);
//    }

}