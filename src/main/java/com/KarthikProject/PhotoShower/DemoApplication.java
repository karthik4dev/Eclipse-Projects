package com.KarthikProject.PhotoShower;

import com.KarthikProject.PhotoShower.Client.*;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DemoApplication.class, args);
//		Client c = new Client("https://google.com/");
//		System.out.print(c.run());
	}

}
