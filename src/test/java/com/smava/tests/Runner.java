package com.smava.tests;

import com.appium.manager.ParallelThread;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sudhanva on 6/1/18
 * @project smava
 */
public class Runner {

    @Test(groups = {"Mobile"})
    public void testApp() throws Exception {
        ParallelThread parallelThread = new ParallelThread();
        List<String> list = new ArrayList<>();
        list.add("LoanSelectionTest");
        list.add("LoginTest");
        Boolean hasFailures = parallelThread.runner("com.smava.tests", list);

        Assert.assertFalse(hasFailures);
    }
}
