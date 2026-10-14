package com.sumanezhumalai.springboot_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sumanezhumalai.springboot_learn.model.Laptop;
import com.sumanezhumalai.springboot_learn.model.User;
import com.sumanezhumalai.springboot_learn.service.LaptopService;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {

		// IOC Concept (the way to access the IOC container)
		ApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);
		// this right side dcode experession - (initial boilerplate definition) returns
		// a ConfigurableApplicationContext object (which by then inherits
		// ApplicationContext ) - so we are using it to access Spring IOC through
		// ApplicationContext

		// CODE

		LaptopService service = context.getBean(LaptopService.class);

		User usr = context.getBean(User.class);
		usr.getDefaultDevice();

		Laptop laptop = context.getBean(Laptop.class);

		service.addLaptop(laptop);
	}

}
