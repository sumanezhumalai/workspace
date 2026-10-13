package com.sumanezhumalai.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sumanezhumalai.spring_learn.concept.AutowireConcept;
import com.sumanezhumalai.spring_learn.concept.DependencyInjectionConcept;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {

		// IOC Concept (the way to access the IOC container)
		ApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);
		// this right side dcode experession - (initial boilerplate definition) returns
		// a ConfigurableApplicationContext object (which by then inherits
		// ApplicationContext ) - so we are using it to access Spring IOC through
		// ApplicationContext

		// Spring creates Object(beans) in the IOC container (having annotated
		// @component on the respective class)
		// then inject the object as/when needed , as like below (no manual object
		// creation and management by user)
		// DependencyInjectionConcept service =
		// context.getBean(DependencyInjectionConcept.class);
		// service.code();
		// the must be annotated with any bean initiation annotation
		// or spring cant access or identify the defined class
		// and throws org.springframework.beans.factory.NoSuchBeanDefinitionException
		// error

		AutowireConcept wire = context.getBean(AutowireConcept.class);
		wire.run();

	}

}
