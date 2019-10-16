package com.marco.st;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = GlobalValue.class)
@ActiveProfiles("test")
public class JavaPropsTest {

    @Test
    public void testMarcoValue() {
        Assertions.assertEquals("marco", GlobalValue.MARCO_VALUE);
    }
}

