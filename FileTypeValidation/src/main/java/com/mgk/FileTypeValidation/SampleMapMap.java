package com.mgk.FileTypeValidation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;  


@Component
public class SampleMapMap {
	
	@Autowired
	FileTypeValidationApplication mgk;

	

	public  Map<String, String> SampleMap()
	{


		HashMap<String,String> sampleMap=new HashMap<String,String>();    
	 

		sampleMap.put("jpeg", "image/jpeg");
		sampleMap.put("png", "image/png");
		sampleMap.put("jpg", "image/jpeg");
		sampleMap.put("dot", "application/msword");
		sampleMap.put("doc", "application/msword");
		sampleMap.put("docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		sampleMap.put("dotx", "application/vnd.openxmlformats-officedocument.wordprocessingml.template");
		sampleMap.put("xls", "application/vnd.ms-excel");
		sampleMap.put("xlt", "application/vnd.ms-excel");
		sampleMap.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		sampleMap.put("xltx", "application/vnd.openxmlformats-officedocument.spreadsheetml.template");
		sampleMap.put("rtf", "text/rtf");
		sampleMap.put("txt", "text/plain");
		sampleMap.put("asc", "text/plain");
		sampleMap.put("text", "text/plain");
		sampleMap.put("diff", "text/plain");
		sampleMap.put("po", "text/plain");
		sampleMap.put("xml", "text/xml");
		sampleMap.put("odt", "application/vnd.oasis.opendocument.text");
   
		return sampleMap;
}
}
