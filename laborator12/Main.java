package org.example;

import org.junit.Test;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {

        String classFilePath = "D:\\facultate\\An2Sem2\\JAVA\\laboratoare\\Laborator12\\target\\classes";

        MyClassLoader myClassLoader = new MyClassLoader();
        File path = new File(classFilePath);
        if (path.exists()) {
            URL url = path.toURI().toURL();
            myClassLoader.addURL(url);
        }

        String className = "org.example.ClassTest";
        Class classInfo = Class.forName(className);
        System.out.println(classInfo.getName());
        System.out.println(classInfo.getPackage());
        System.out.println(Arrays.toString(classInfo.getMethods()));
        System.out.println(classInfo.getSuperclass());

        int passed = 0, failed = 0;
        for (Method m : Class.forName(classInfo.getName()).getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }


       /* for (Method method : methods) {
            if (Modifier.isStatic(method.getModifiers()) && method.isAnnotationPresent(Test.class)) {
                try {
                    method.invoke(null);
                    System.out.println("ClassTest method invoked: " + method.getName());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    System.out.println("Failed to invoke test method: " + method.getName());
                    e.printStackTrace();
                }
            }
        }*/
    }