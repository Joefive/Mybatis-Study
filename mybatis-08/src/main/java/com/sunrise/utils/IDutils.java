package com.sunrise.utils;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.jupiter.api.Test;

import java.util.UUID;

@SuppressWarnings("all") //防止警告
public class IDutils {
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Test
    public void test(){
        System.out.println(IDutils.getID());
        System.out.println(IDutils.getID());
        System.out.println(IDutils.getID());
    }

}
