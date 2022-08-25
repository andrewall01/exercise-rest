package com.exerciserest;

import com.exerciserest.entities.Laptop;
import com.exerciserest.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ExerciseRestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ExerciseRestApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null,"HP","Pavilion 2500");
		repository.save(laptop1);
		Laptop laptop2 = new Laptop(null,"DELL","Latitude5400");
		repository.save(laptop2);
	}

}
