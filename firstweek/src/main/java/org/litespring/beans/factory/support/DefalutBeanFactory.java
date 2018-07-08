package org.litespring.beans.factory.support;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.utils.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class DefalutBeanFactory implements BeanFactory {

    public static final String ID_ATTRIBUTE = "id";
    public static final String CLASS_ATTRIBUTE = "class";
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>(64);

    public DefalutBeanFactory(String configFile) throws DocumentException, IOException {
        loadBeanDefinition(configFile);
    }

    private void loadBeanDefinition(String configFile) throws DocumentException, IOException {
        InputStream is = null;

        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        is = cl.getResourceAsStream(configFile);
        SAXReader reader = new SAXReader();
        Document doc = reader.read(is);
        Element rootElement = doc.getRootElement();
        Iterator<Element> iterator = rootElement.elementIterator();
        while (iterator.hasNext()){
            Element ele = (Element) iterator.next();
            String id = ele.attributeValue(ID_ATTRIBUTE);
            String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
            BeanDefinition bd = new GenericBeanDefinition(id,beanClassName);
            this.beanDefinitionMap.put(id,bd);
        }
        is.close();
    }

    public BeanDefinition getBeanDefinition(String petStore) {
        return beanDefinitionMap.get(petStore);
    }

    public Object getBean(String beanID) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        BeanDefinition bd = this.getBeanDefinition(beanID);
        if(bd==null){
            return null;
        }
        ClassLoader cl = ClassUtils.getDefaultClassLoader();
        String beanClassName = bd.getBeanClassName();
        Class<?> claz = cl.loadClass(beanClassName);
        return claz.newInstance();
    }
}
