package LearningTestNG;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class AssertionExamples {

   /* @Listeners(Listener_Class.class)
    public class ForTest extends BaseClass {*/

        @Test
        public static void m1() {
            Assert.assertTrue(true);
            System.out.println("its m1");


        }

        @Test
        public static void m2() {
            RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
            Assert.assertTrue(true, "failed baby");
            System.out.println("its m2");


        }
    }


