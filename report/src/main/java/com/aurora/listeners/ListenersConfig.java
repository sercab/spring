package com.aurora.listeners;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.aurora.data.model.County;
import com.aurora.data.repositories.CountyRepository;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ListenersConfig {
	
	@Autowired
	CountyRepository countyRepo;
	
	@EventListener({ContextRefreshedEvent.class})
    void contextRefreshedEvent() {
		
		List<County> counties = countyRepo.findAll();
		
		if(counties.size()==0){
			try{
				ClassLoader classLoader = getClass().getClassLoader();
				byte[] jsonData = Files.readAllBytes(Paths.get(classLoader.getResource("tx.json").toURI()));
				ObjectMapper objectMapper = new ObjectMapper();
				JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, County.class);
				counties = objectMapper.readValue(jsonData, type);
				countyRepo.save(counties);
			}catch(Exception ex){ex.printStackTrace();}
		}else{
			System.out.println("We have counties!!!");
		}
		
	}

}
