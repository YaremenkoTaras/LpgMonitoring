package com.yaremenko.lpgmonitoring.dao;

import com.yaremenko.lpgmonitoring.entities.User;

import java.lang.reflect.ParameterizedType;

/**
 * @author Taras
 * @since 11.05.2017
 */
public class Main {

    static class Nested<T>{

        Class<T> generic;

        @SuppressWarnings("unchecked")
        public void printclass(){

            generic = (Class<T>)
                    ((ParameterizedType)getClass()
                            .getGenericSuperclass())
                            .getActualTypeArguments()[0];

            System.out.println(generic);

        }
    }

    public static void main(String[] args) {


        Nested<User> userNested = new Nested<>();

        userNested.printclass();
    }
}
