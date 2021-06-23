package com.example.listossimage;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ListossimageApplicationTests {

    @Test
    void contextLoads() {
        int max = max(5, 4);
        System.out.println(max);
        int max1 = max(3, 1);
        System.out.println(max1);
    }

    public int max(int x, int y) {
        if (x > y) {
            return x;
        }else {
            return y;
        }
    }

}
