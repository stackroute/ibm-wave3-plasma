package com.stackroute.plasma.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.plasma.domain.Url;
import com.stackroute.plasma.service.DocumentService;
import com.stackroute.plasma.service.RabbitMQSender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest(value = DocumentController.class)
public class DocumentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Url url;

    @MockBean
    private DocumentService documentService;
    @MockBean
    private RabbitMQSender rabbitMQSender;

    @InjectMocks
    private DocumentController documentController;
    private List<Url> list = null;


    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(documentController).build();
        url = new Url();
        url.setUrl("http://www.dustyfeet.com/");
        url.setConcept("class");
        url.setDomain("java");
        url.setDoc("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"+ "\n" +"<html>"+ "\n" +" <head> "+ "\n" +"  <title>Stuart Frankel's very small web site</title> "+ "\n" +"  <meta name=\"verify-v1\" content=\"1vLCRPR1SHmiCICnhWfD7jtpOOSHe79iILqzDkGBUg0=\"> "+ "\n" +" </head> "+ "\n" +" <body style=\"color: rgb(0, 0, 0); background-color: rgb(245, 204, 176); background-image: url(./images/gecback2.jpg);\" alink=\"#db70db\" link=\"red\" vlink=\"#2f2f4f\"> "+ "\n" +"  <br> "+ "\n" +"  <center> "+ "\n" +"   <table border=\"8\"> "+ "\n" +"    <tbody> "+ "\n" +"     <tr> "+ "\n" +"      <td bgcolor=\"#f5ccb0\"> <h1>My Small-But-Intense Home Page!</h1> </td> "+ "\n" +"     </tr> "+ "\n" +"    </tbody> "+ "\n" +"   </table> "+ "\n" +"  </center> "+ "\n" +"  <br> "+ "\n" +"  <center> "+ "\n" +"   <p>If you came here looking for information on human trafficking in East Africa, you actually want to go <a href=\"http://dustyfeetonline.com\">here</a>, since I don't know anything about it.</p> "+ "\n" +"   <p></p> "+ "\n" +"   <font size=\"5\">Welcome to my Small-But-Intense Home Page! There's not much here yet, but at least I'm avoiding those obnoxious <a href=\"notuncnj.html\" target=\"_top\">under construction</a> tags, so if there's a visible link it should give you something. </font>"+ "\n" +"  </center> "+ "\n" +"  <center> "+ "\n" +"   <p></p> "+ "\n" +"   <font size=\"4\">24 August 2006. About The Barney Affair: This is my little corner of the web, and the bullies can't have it. There's nothing more to it than that. There's a NYTimes article about it <a href=\"http://www.nytimes.com/2006/08/28/technology/28link.html?scp=6&amp;sq=%22stuart%20frankel%22&amp;st=cse\">here</a>.<br> </font>"+ "\n" +"  </center> "+ "\n" +"  <center> "+ "\n" +"   <table cellpadding=\"12\" cellspacing=\"12\" width=\"85%\"> "+ "\n" +"    <!--<tr><td valign=top><font size=\"5\"><a href=\"rescent.html\">Upgrades</a></font></td></tr>--> "+ "\n" +"    <tbody> "+ "\n" +"     <tr> "+ "\n" +"      <td valign=\"top\"> <font size=\"5\"><a href=\"diss.html\" target=\"_top\">Dissertation</a></font></td> "+ "\n" +"      <td valign=\"top\"> <font size=\"4\">The whole thing is here for downloading; also the abstract for reading online, if you're in a hurry. I'm accepting bids for the movie rights.</font></td> "+ "\n" +"     </tr> "+ "\n" +"     <tr> "+ "\n" +"      <td halign=\"right\" valign=\"top\"><font size=\"5\"><a href=\"mykeyboardbaby1.html\"> How to build a clavichord</a></font><br> <font size=\"4\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font></td> "+ "\n" +"      <td valign=\"top\"><font size=\"4\">The story of my clavichord, made by Owen Daly, after an 18th-century Portuguese model.</font></td> "+ "\n" +"     </tr> "+ "\n" +"     <tr> "+ "\n" +"      <td halign=\"right\" valign=\"top\"><font size=\"5\"><a href=\"./evil/evil.html\">Evil</a></font></td> "+ "\n" +"      <td valign=\"top\"><font size=\"4\">Bad odor</font></td> "+ "\n" +"     </tr> "+ "\n" +"     <tr> "+ "\n" +"      <td halign=\"right\" valign=\"top\"><font size=\"5\"><a href=\"./pangan/index.html\">Warung Seniman</a> </font></td> "+ "\n" +"      <td valign=\"top\"><font size=\"4\">Javanese recipes by a Javanese musician. Recipes by Wakidi Dwijamartono; text by K. Emerson.</font></td> "+ "\n" +"     </tr> "+ "\n" +"     <tr> "+ "\n" +"      <td halign=\"right\" valign=\"top\"><font size=\"5\"><a href=\"./santanyi_registration.html\">Spanish organ</a> </font></td> "+ "\n" +"      <td valign=\"top\"><font size=\"4\">Some practical information about registration in Spanish Baroque Organ music.</font></td> "+ "\n" +"     </tr> "+ "\n" +"    </tbody> "+ "\n" +"   </table> "+ "\n" +"   <br> "+ "\n" +"   <br> "+ "\n" +"   <a href=\"mailto:gecko@dustyfeet.com\">e-mail me if you want</a>"+ "\n" +"  </center> "+ "\n" +"  <br> "+ "\n" +"  <br>   "+ "\n" +" </body>"+ "\n" +"</html>");
        list = new ArrayList<>();
        list.add(url);
    }


    @Test
    public void getContent() throws Exception {

        when(documentService.getHtml()).thenReturn(Collections.singletonList(url));
        when(documentService.getHtml()).thenReturn(Collections.singletonList((url)));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/doc")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(url)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}