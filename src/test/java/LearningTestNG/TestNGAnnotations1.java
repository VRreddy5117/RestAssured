package LearningTestNG;




import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

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

        @BeforeClass
    }
