package rahulshettyacademy.data;

import java.io.File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class dataReader {
	
	
	public List<HashMap<String,String>> getJsonDataToMap() throws IOException {
		
		//read json to string
String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\prrchaseorder.json"),
			StandardCharsets.UTF_8);

//String to Hashmap we need jackson databind

	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
	});
	//this gives two hashmap based on json index of array
	return data;
	
	
	}







	}

	
	
	
	
	
	
	
	
	
	
	

