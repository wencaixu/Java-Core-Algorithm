package com.algorithm.reflection;

import com.algorithm.dp.MaxSum;
import org.junit.Test;

import java.lang.reflect.Field;

public class ReflectionClassTest {

    @Test
    public void runClass(){
        try {
            Class<MaxSum> maxSumClass = MaxSum.class;
            Field serialVersionUID = maxSumClass.getField("as");
            System.out.println(serialVersionUID.getChar(String.class));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
