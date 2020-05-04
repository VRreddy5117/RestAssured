package LearningTestNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotation2 {

        @BeforeClass
        public void beforeClass(){
            System.out.println("Initialize restAssured for Class 1");
        }

        @BeforeMethod
        public void beforeMethod(){
            System.out.println("Opening postman");
        }

        @Test
        public void test1(){
            System.out.println("Inside Test 1");
        }

        @Test
        public void test2(){
            System.out.println("Inside Test 2");
        }

        @AfterMethod
        public void afterMethod(){
            System.out.println("Closing postman");
        }


        @AfterClass
        public void afterClass(){
            System.out.println("Destroy restAssured for class 1");
        }
}

