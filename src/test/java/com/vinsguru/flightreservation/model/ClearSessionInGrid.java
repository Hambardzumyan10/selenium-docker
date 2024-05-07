package com.vinsguru.flightreservation.model;

import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ClearSessionInGrid {
    // ... (your existing code)

//    public void clearGridSessionsAfterSuite() {
//        String gridHubUrl = "http://localhost:4444/grid/admin/hub/cleanupSessions";
//
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            HttpDelete request = new HttpDelete(gridHubUrl);
//            CloseableHttpResponse response = httpClient.execute(request);
//
//            if (response.getCode() == 200) {
//                System.out.println("Cleared all sessions successfully");
//            } else {
//                System.out.println("Failed to clear sessions. Status code: " + response.getCode());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
