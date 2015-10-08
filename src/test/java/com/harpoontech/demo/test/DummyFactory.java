package com.harpoontech.demo.test;

import java.util.UUID;

import org.springframework.beans.factory.FactoryBean;

/**
 *
 */
public class DummyFactory implements FactoryBean<String> {

    @Override
    public String getObject() throws Exception {
        return UUID.randomUUID().toString();
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
