package com.vinsguru.util;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.vinsguru.vendorportal.model.VendorPortalTestData;
import org.apache.commons.io.IOUtils;

public class Demo {
    public static void main(String[] args) throws Exception {
        System.setProperty("browser","firefox");  //browser@ poxuma firefxx
             Config.initialize();
//        System.out.println(Config.get("selenium.grid.hubHost"));

    }
}
