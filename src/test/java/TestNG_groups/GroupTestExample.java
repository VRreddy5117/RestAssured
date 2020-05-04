package TestNG_groups;

import org.junit.Assert;
import org.testng.annotations.Test;

public class GroupTestExample {

    String message = ".com";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(groups = { "lockdown", "shhutdown" })

    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        message = ".com";
        Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test(groups = { "lockdown" })

    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "facebook" + ".com";
        Assert.assertEquals(message, messageUtil.salutationMessage());
    }

    @Test(groups = { "shutdown" })

    public void testingExitMessage() {
        System.out.println("Inside testExitMessage()");
        message = "www." + "facebook"+".com";
        Assert.assertEquals(message, messageUtil.exitMessage());
    }
}
