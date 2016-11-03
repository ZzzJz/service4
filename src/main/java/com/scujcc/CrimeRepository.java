package com.scujcc;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CrimeRepository 
	extends MongoRepository<Crime,String>{
	
}
