package com.enclouden.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileLib {
	
	
public String getPropertyValue(String key) throws IOException {
	FileInputStream fis = new FileInputStream("./data/commondata.property");
	Properties p = new Properties();
	p.load(fis);
	return p.getProperty(key);
}
	
}
