package LearningTestNG;

import org.testng.annotations.Test;

public class FirstPrirorityTestCase {

    @Test (priority = 1)
    public void setup(){
        System.out.println("open browser");
    }

    @Test (priority = 2)
    public void login(){
        System.out.println("This is for login");
    }

    @Test (priority = 3)
    public void shutdown() {
        System.out.println("close browser");
    }

}
