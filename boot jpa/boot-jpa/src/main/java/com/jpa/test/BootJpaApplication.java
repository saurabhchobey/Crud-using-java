package com.jpa.test;


import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepo;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootJpaApplication {

	public static void main(String[] args) {
		 SpringApplication.run(BootJpaApplication.class, args);

       ApplicationContext context = SpringApplication.run(BootJpaApplication.class, args);
		 
		 UserRepo userRepo=context.getBean(UserRepo.class);
  
		 
		  //create user 
  User user =new User();
  
  user.setName("saurabh0");
  user.setCity("delhi");
  user.setStatus("morning");
  
  
   User user5 =new User();
  
  user.setName("rajat0");
  user.setCity("delhi");
  user.setStatus("evening");
  
  
  // for single user

   User user2 =userRepo.save(user);
  System.out.println(user2);
  
  
  // updatw the user
  // imp findall , get , hasnext  collection  foreach  
  
  //itr.foreach(user->{sop}
  
   Optional<User> optional = userRepo.findById(1);
   
   
   User user3 = optional.get();
   user3.setName("rahul");
   User result = userRepo.save(user3);
   System.out.println(result);
   
   
   //for deleteting user
   
   Iterable<User> itr =userRepo.findAll();
   
 
   userRepo.deleteAll(itr);
	}

}
