//
//package com.stackroute.plasma.service;
//
//
//import com.stackroute.plasma.domain.Url;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.IOException;
//
//import static org.junit.Assert.*;
//
//public class DocumentServiceTest {
//
//
//    DocumentServiceTest documentServiceTest;
//
//    DocumentServiceImpl documentServiceImpl = new DocumentServiceImpl();
//    Url url=new Url();
//
//
//
//
//    public DocumentServiceTest() throws IOException {
//    }
//
//
//
//
//    @Before
//    public void setUp() throws Exception {
//        documentServiceTest = new DocumentServiceTest();
//        url.setUrl("http://www.dustyfeet.com/");
//        url.setConcept("class");
//        url.setDomain("java");
//        url.setDoc("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">"+ "\n" +"<html>"+ "\n" +" <head> "+ "\n" +"  <title>Stuart Frankel's very small web site</title> "+ "\n" +"  <meta name=\"verify-v1\" content=\"1vLCRPR1SHmiCICnhWfD7jtpOOSHe79iILqzDkGBUg0=\"> "+ "\n" +" </head> "+ "\n" +" <body style=\"color: rgb(0, 0, 0); background-color: rgb(245, 204, 176); background-image: url(./images/gecback2.jpg);\" alink=\"#db70db\" link=\"red\" vlink=\"#2f2f4f\"> "+ "\n" +"  <br> "+ "\n" +"  <center> "+ "\n" +"   <table border=\"8\"> "+ "\n" +"    <tbody> "+ "\n" +"     <tr> "+ "\n" +"      <td bgcolor=\"#f5ccb0\"> <h1>My Small-But-Intense Home Page!</h1> </td> "+ "\n" +"     </tr> "+ "\n" +"    </tbody> "+ "\n" +"   </table> "+ "\n" +"  </center> "+ "\n" +"  <br> "+ "\n" +"  <center> "+ "\n" +"   <p>If you came here looking for information on human trafficking in East Africa, you actually want to go <a href=\"http://dustyfeetonline.com\">here</a>, since I don't know anything about it.</p> "+ "\n" +"   <p></p> "+ "\n" +"   <font size=\"5\">Welcome to my Small-But-Intense Home Page! There's not much here yet, but at least I'm avoiding those obnoxious <a href=\"notuncnj.html\" target=\"_top\">under construction</a> tags, so if there's a visible link it should give you something. </font>"+ "\n" +"  </center> "+ "\n" +"  <center> "+ "\n" +"   <p></p> "+ "\n" +"   <font size=\"4\">24 August 2006. About The Barney Affair: This is my little corner of the web, and the bullies can't have it. There's nothing more to it than that. There's a NYTimes article about it <a href=\"http://www.nytimes.com/2006/08/28/technology/28link.html?scp=6&amp;sq=%22stuart%20frankel%22&amp;st=cse\">here</a>.<br> </font>"+ "\n" +"  </center> "+ "\n" +"  <center> "+ "\n" +"   <table cellpadding=\"12\" cellspacing=\"12\" width=\"85%\"> "+ "\n" +"    <!--<tr><td valign=top><font size=\"5\"><a href=\"rescent.html\">Upgrades</a></font></td></tr>--> "+ "\n" +"    <tbody> "+ "\n" +"     <tr> "+ "\n" +"      <td valign=\"top\"> <font size=\"5\"><a href=\"diss.html\" target=\"_top\">Dissertation</a></font></td> "+ "\n" +"      <td valign=\"top\"> <font size=\"4\">The whole thing is here for downloading; also the abstract for reading online, if you're in a hurry. I'm accepting bids for the movie rights.</font></td> "+ "\n" +"     </tr> "+ "\n" +"     <tr> "+ "\n" +"      <td halign=\"right\" valign=\"top\"><font size=\"5\"><a href=\"mykeyboardbaby1.html\"> How to build a clavichord</a></font><br> <font size=\"4\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font></td> "+ "\n" +"      <td valign=\"top\"><font size=\"4\">The story of my clavichord, made by Owen Daly, after an 18th-century Portuguese model.</font></td> "+ "\n" +"     </tr> "+ "\n" +"     <tr> "+ "\n" +"      <td halign=\"right\" valign=\"top\"><font size=\"5\"><a href=\"./evil/evil.html\">Evil</a></font></td> "+ "\n" +"      <td valign=\"top\"><font size=\"4\">Bad odor</font></td> "+ "\n" +"     </tr> "+ "\n" +"     <tr> "+ "\n" +"      <td halign=\"right\" valign=\"top\"><font size=\"5\"><a href=\"./pangan/index.html\">Warung Seniman</a> </font></td> "+ "\n" +"      <td valign=\"top\"><font size=\"4\">Javanese recipes by a Javanese musician. Recipes by Wakidi Dwijamartono; text by K. Emerson.</font></td> "+ "\n" +"     </tr> "+ "\n" +"     <tr> "+ "\n" +"      <td halign=\"right\" valign=\"top\"><font size=\"5\"><a href=\"./santanyi_registration.html\">Spanish organ</a> </font></td> "+ "\n" +"      <td valign=\"top\"><font size=\"4\">Some practical information about registration in Spanish Baroque Organ music.</font></td> "+ "\n" +"     </tr> "+ "\n" +"    </tbody> "+ "\n" +"   </table> "+ "\n" +"   <br> "+ "\n" +"   <br> "+ "\n" +"   <a href=\"mailto:gecko@dustyfeet.com\">e-mail me if you want</a>"+ "\n" +"  </center> "+ "\n" +"  <br> "+ "\n" +"  <br>   "+ "\n" +" </body>"+ "\n" +"</html>");
//
//    }
//
//
//    @After
//    public void tearDown() throws Exception {
//        documentServiceTest = null;
//    }
//
//    @Test
//    public void getDoc() throws IOException {
//    assertNotNull(documentServiceImpl.getHtml());
//
//
//    }
//
//
//}
//
