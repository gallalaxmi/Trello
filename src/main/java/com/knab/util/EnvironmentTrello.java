package com.knab.util;

import static java.lang.System.getProperty;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import io.restassured.response.Response;

public class EnvironmentTrello {
    private static Logger log = LogManager.getLogger(EnvironmentTrello.class.getName());
    static FileInputStream fs;
    static Properties property;
    public static final String env="config";//System.getProperty("config");
    public static String outputPath;

    //To load the properties file based on env variable
    public static void loadProperties() throws IOException {
        fs=new FileInputStream(getProperty("user.dir")+"/src/main/resources/"+env+".properties");
        property=new Properties();
        property.load(fs);
        log.info("In loadProperties method");
    }

    //To read the property from properties file
    public static String ReadProperty(String key){
        log.info("In ReadProperty method");
        log.info(property.getProperty(key));
        return property.getProperty(key);
    }

    //To get response as string
    public static String getResposeString(Response response){
        log.info("Converting Response to String");
        String strResponse = response.getBody().asString();
        log.debug(strResponse);
        return strResponse;
    }

    //To get the status code of the api
    public static int getStatusCode(Response response){
        log.info("Getting Response Code");
        int statusCode = response.getStatusCode();
        log.info(statusCode);
        return statusCode;
    }

    //To get the content type of the api
    public static String getContentType(Response response){
        log.info("Getting Response Code");
        String statusCode = response.contentType();
        log.info(statusCode);
        return statusCode;
    }

    //TO verify the status code
    public static void verifyStatusCode(Response response, int status){
        Assert.assertEquals(EnvironmentTrello.getStatusCode(response), status);
    }

    //To verify the contentType
    public static void verifyContentType(Response response, String contentType){
        Assert.assertEquals(EnvironmentTrello.getContentType(response), contentType);
    }    

}
