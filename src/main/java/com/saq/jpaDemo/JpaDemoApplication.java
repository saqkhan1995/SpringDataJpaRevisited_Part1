package com.saq.jpaDemo;

import com.saq.jpaDemo.entity.Course;
import com.saq.jpaDemo.respository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = repository.findById(10001L);

		LOGGER.info("Course details 10001 :{}", course);

		/*repository.deleteById(10001L);*/

		repository.save(new Course("Microservice in 100 steps"));

		repository.playWithEntityManager0();
	}
}
