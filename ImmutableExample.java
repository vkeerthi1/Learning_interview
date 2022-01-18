package com.java;

import java.util.HashMap;

/*
* As long as we dont provide security manager, private members of class can be accessible. To access private members of class you should set setAccessible(true), this will allow you to access private members. To restrict access private members Keep below line of code in your immutable class constructor.

System.setSecurityManager(new SecurityManager());

This will throw AccessControlException when you try to set setAccessible(true).*/
public class ImmutableExample {
    public static void main(String[] args) {

        // Getting immutable class only with required parameters
        Immutable immutableClass = new Immutable.ImmutableClassBuilder(1, "JAVA").build();

        HashMap<String,String> hm = new HashMap<String, String>();
        hm.put("Name", "JAVA");
        hm.put("City", "South Africa");
        // Getting immutable class with optional parameters
        Immutable immutableClass1 = new Immutable.ImmutableClassBuilder(1, "JAVA")
                .setCompany("Soth").setProperties(hm).build();

        //Testing immutability
        HashMap<String,String> hm1 = immutableClass1.getProperties();

        //lets modify the Object passed as argument or get from the Object
        hm1.put("test", "test");
        hm.put("test", "test");

        //check that immutable class properties are not changed
        System.out.println(immutableClass1.getProperties());
    }
}
