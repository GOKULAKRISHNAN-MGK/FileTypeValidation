package com.mgk.FileTypeValidation.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mgk.FileTypeValidation.SampleMapMap;
/*import com.mgk.constants.Constants;*/

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicException;
import net.sf.jmimemagic.MagicMatchNotFoundException;
import net.sf.jmimemagic.MagicParseException;

@RestController
public class TypeValidationController {

	@Autowired
	SampleMapMap sampleMap;

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public void validateFile(@RequestParam("file") MultipartFile file)
			throws MagicParseException, MagicMatchNotFoundException, MagicException, IOException {

		HashMap<String, String> sampleMap = new HashMap<String, String>();

		sampleMap.put("pdf", "application/pdf");
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

		// List<String> ext=map.keySet().stream().collect(Collectors.toList());
		/*System.out.println("-----" + file.getOriginalFilename());
		if (!file.getOriginalFilename().matches(Constants.PDF_FORMAT)) {
			System.out.println("Error");
		} else {*/
			String fileMimeType = Magic.getMagicMatch(file.getBytes()).getMimeType();
			String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
			String fileName=file.getOriginalFilename();
			int length=fileName.length();
			int count=0;
			int count1=0;
			for(int i=0;i<length;i++)
			{
				char a=fileName.charAt(i);
				if(a=='.')
				{
					count++;
				}
			}
			
			if(count>1)
			{
				System.out.println("double extension error");
			}
			else
			{
			for (Map.Entry<String, String> map1 : sampleMap.entrySet()) {
				if (!fileExtension.equalsIgnoreCase(map1.getKey())) {
					System.out.println("File not found");
				} else {
					String val=map1.getValue();
					if(!val.equalsIgnoreCase(fileMimeType))
					{
						System.out.println("Error");
					    System.out.println(fileMimeType);
					}
					else
					{
						System.out.println("Success");
						System.out.println(map1);
					}
					
				}

			}

		}
	}
	
}
	



