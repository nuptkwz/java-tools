package com.javatools.javatools;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Description
 * Date 2021/2/8 0:02
 * Created by kwz
 */
public class MockBaseCaseTests {


    @Test
    public void testMock() {
        //创建ArrayList的Mock对象
        List mockList = mock(ArrayList.class);
        //pass
        Assert.assertTrue(mockList instanceof ArrayList);
        //当我们mockList调用方法去add("张三")的时候会返回true
        when(mockList.add("张三")).thenReturn(true);

        //当我们mockList调用方法size()的时候返回10
        when(mockList.size()).thenReturn(10);
        //pass
        Assert.assertTrue(mockList.add("张三"));
        //pass
        Assert.assertFalse(mockList.add("李四"));
        //pass
        Assert.assertEquals(mockList.size(), 10);
        //null
        System.out.println(mockList.get(0));
    }
}
