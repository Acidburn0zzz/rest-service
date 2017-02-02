package com.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.app.model.Person;

@RestController
@RequestMapping(value="/svc/person")
public class PersonService {

	Map<Long, Person> personMap;
	
	public PersonService() {
		super();
		personMap = new HashMap< Long, Person>();
		
		
		Person p1 = new Person();
		p1.setId(1l);
		p1.setName("John Doe");
		
		
		Person p2 = new Person();
		p2.setId(2l);
		p2.setName("Jane Smith");
		
		personMap.put(p1.getId(), p1);
		personMap.put(p2.getId(), p2);
	}


	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Person getPerson(@PathVariable Long id){
		return personMap.get(id);
	}
}
