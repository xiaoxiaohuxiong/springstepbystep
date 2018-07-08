package com.xiaohuxiong.firstweek.spring.Test;

import org.dom4j.DocumentException;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.support.DefalutBeanFactory;
import org.litespring.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class BeanFactoryTest {

    @Test
    public void getBean() throws IOException, DocumentException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        BeanFactory beanFactory  = new DefalutBeanFactory("petstore-v1.xml");
        BeanDefinition bd =beanFactory.getBeanDefinition("petStore");
        /*      PetStoreService petStoreService = null;
        if(petStoreService instanceof BeanDefinition){

        }*/
        Assert.assertEquals("org.litespring.service.v1.PetStoreService",bd.getBeanClassName());

        PetStoreService petStoreService = (PetStoreService)beanFactory.getBean("petStore");

        Assert.assertNotNull(petStoreService);

    }
}
