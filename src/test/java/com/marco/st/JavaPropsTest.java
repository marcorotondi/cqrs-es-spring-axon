package com.marco.st;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = GlobalValue.class)
@ActiveProfiles("test")
public class JavaPropsTest {

    @Test
    public void testMarcoValue() {
        Assert.assertEquals("marco", GlobalValue.MARCO_VALUE);
    }
}

