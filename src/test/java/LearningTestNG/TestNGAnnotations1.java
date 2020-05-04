package LearningTestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNGAnnotations1 {

        @BeforeSuite
        public void beforeSuite(){
            System.out.println("Starting TestNG");
        }

        @AfterSuite
        public void afterSuite(){
            System.out.println("Stoping TestNG");
        }


        @BeforeTest
        public void beforeTest(){
            System.out.println("Start Test Execution");
        }

    }
