package com.hxqh.abb.common.util;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.util.Map;

/**
 * Created by Ocean lin on 2017/8/16.
 */
public class CglibUtil {


    public Object object = null;
    /**
     * 属性map
     */
    public BeanMap beanMap = null;

    public CglibUtil() {
        super();
    }

    @SuppressWarnings("unchecked")
    public CglibUtil(Map propertyMap) {
        this.object = generateBean(propertyMap);
        this.beanMap = BeanMap.create(this.object);
    }

    /**
     * 给bean属性赋值
     *
     * @param property 属性名
     * @param value    值
     */
    public void setValue(String property, Object value) {
        beanMap.put(property, value);
    }

    /**
     * 通过属性名得到属性值
     *
     * @param property 属性名
     * @return 值
     */
    public Object getValue(String property) {
        return beanMap.get(property);
    }

    /**
     * 得到该实体bean对象
     *
     * @return
     */
    public Object getObject() {
        return this.object;
    }

    @SuppressWarnings("unchecked")
    private Object generateBean(Map<String,Object> propertyMap) {
        BeanGenerator generator = new BeanGenerator();
//        Set keySet = new LinkedHashSet();
//        keySet = propertyMap.keySet();
//        for (Iterator i = keySet.iterator(); i.hasNext(); ) {
//            String key = (String) i.next();
//            generator.addProperty(key, (Class) propertyMap.get(key));
//        }
        for(Map.Entry<String,Object> map :propertyMap.entrySet())
        {
            generator.addProperty(map.getKey(), (Class) map.getValue());
        }
        return generator.create();
    }

}
