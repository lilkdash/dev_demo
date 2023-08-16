package com.kzheng.boot.design_pattern;

import com.kzheng.boot.practice.design_pattern.strategic.CalculatorService;
import com.kzheng.boot.practice.design_pattern.strategic.CommandFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/8/1 20:45
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategicTest {
    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void test_CalculatorService(){
        int result = calculatorService.calculate("add", 1,2);
        System.out.println("result:" +  result);
    }

    @Autowired
    private CommandFactory commandFactory;
    @Test
    public void test_CommandFactory(){
        int result = commandFactory.calculate("addCommand", 1,2);
        System.out.println("result:" +  result);
    }

}
