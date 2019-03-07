//package com.stackroute.plasma.service;//package com.stackroute.plasma.service;
//
//import com.stackroute.plasma.domain.Evaluator;
//import com.stackroute.plasma.domain.Url;
//import org.json.simple.parser.ParseException;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.sql.Timestamp;
//import java.text.DecimalFormat;
//
//import static org.junit.Assert.assertEquals;
//
//
//
//public class EvalServiceImplTest {
//
//
//    Evaluator evaluator;
//
//    private Url url;
//    private EvaluatorService evalServiceImpl;
//    private Timestamp timestamp;
//    private String doc;
//    DecimalFormat df2 = new DecimalFormat("#.##");
//
//    public EvalServiceImplTest() throws IOException, ParseException {
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        evaluator=new Evaluator();
//        url=new Url();
//        url.setDomain("java");
//        url.setConcept("class");
//        url.setUrl("https://www.guru99.com/java-oops-class-objects.html");
//
//        url.setDoc("<html><head><title>encapsulation</title><meta name=\"description\" content=\"Encapsulation in java\"> <meta name=\"keywords\" content=\"encapsulation,in,java\"> </head><body><p>Encapsulation is one of the four fundamental OOP concepts. The other three are inheritance, polymorphism, and abstraction.\n" +
//                "\n" +
//                "Encapsulation in Java is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit. In encapsulation, the variables of a class will be hidden from other classes, and can be accessed only through the methods of their current class. Therefore, it is also known as data hiding.\n" +
//                "\n" +
//                "To achieve encapsulation in Java −\n" +
//                "\n" +
//                "Declare the variables of a class as private.\n" +
//                "\n" +
//                "Provide public setter and getter methods to modify and view the variables values.\n" +
//                "\n" +
//                "Example\n" +
//                "Following is an example that demonstrates how to achieve Encapsulation in Java −</p></body></html>");
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        evaluator=null;
//    }
//
//    @Test
//    public void getScore(){
//      evaluator=evalServiceImpl.getScore(url);
//     assertEquals("https://www.guru99.com/java-oops-class-objects.html",evaluator.getUrl());
//     assertEquals("Encapsulation in java".trim(),evaluator.getDescription().trim());
//     assertEquals("java",evaluator.getDomain());
//     assertEquals("class",evaluator.getConcept());
//     assertEquals("example",evaluator.getLevel());
//     assertEquals(df2.format(1),df2.format(evaluator.getConfidenceScore()));
//
//    }
//}