package com.vinsguru.util;

import com.vinsguru.flightreservation.model.FlightReservationTestData;
import com.vinsguru.vendorportal.model.VendorPortalTestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;


public class jsonUtil
{
    private static final Logger log= LoggerFactory.getLogger(jsonUtil.class);
    private static final ObjectMapper mapper=new ObjectMapper();
    public static <T> T getTesData(String path,Class<T> type){
       try(InputStream stream=ResourceLoader.getResource(path)){
           return mapper.readValue(stream,type);
       }catch (Exception e){
           log.error("unable to read test data file {}",path,e);
       }
       return null;
    }

}
