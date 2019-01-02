package com.tf.tests;

import com.appium.manager.ParallelThread;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    @Test(groups = {"Mobile"})
    public void testApp () throws Exception {
        ParallelThread parallelThread = new ParallelThread();
        List<String> list = new ArrayList<>();
        list.add("LoginTest");
        Boolean hasFailures = parallelThread.runner("com.tf.tests", list);

        Assert.assertFalse(hasFailures);
    }
}
