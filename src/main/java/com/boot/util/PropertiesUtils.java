package com.boot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class PropertiesUtils {
    private final static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

    private Properties resource = new Properties();

    public PropertiesUtils(String resourceName) {
        this.load(resourceName);
    }


    /**
     * 优先读取jar包内文件，若无则读取文件系统
     *
     * @param resourceName
     */
    public void load(String resourceName) {
        InputStream inputStream = null;
        try {
            inputStream = this.getClass().getClassLoader().getResourceAsStream(resourceName);
        } catch (Exception e) {
//            logger.info("从jar包内没有读取到配置文件，准备从文件系统中读取");
        }
        if (inputStream == null) {
            try {
                inputStream = new FileInputStream(new File(resourceName));
            } catch (FileNotFoundException ex) {
                logger.error("load resource file from file system failed!", ex);
            }
        }

        try {
            resource.load(inputStream);
        } catch (IOException e) {
            logger.error("load resource content failed!", e);
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            logger.error("close InputStream failed!", e);
        }
    }

    public String get(String keyString) {
        if (keyString == null) {
            return null;
        }

        if (this.resource.containsKey(keyString)) {
            return this.resource.getProperty(keyString);
        }

        return null;
    }
}
