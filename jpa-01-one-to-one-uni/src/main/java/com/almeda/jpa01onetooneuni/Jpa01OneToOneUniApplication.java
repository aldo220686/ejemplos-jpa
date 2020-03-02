package com.almeda.jpa01onetooneuni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@ComponentScan(basePackages="com.almeda")
@EntityScan("com.almeda.entity")*/
public class Jpa01OneToOneUniApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jpa01OneToOneUniApplication.class, args);
	}
}
