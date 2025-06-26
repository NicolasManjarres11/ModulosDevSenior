package com.devsenior.nmanja.demo_record;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsenior.nmanja.demo_record.model.dto.UsuarioRequest;

@SpringBootApplication
public class DemoRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRecordApplication.class, args);

		/* demoRecord(); */
	}

	private static void demoRecord(){

		var u1 = new UsuarioRequest("Nicolas","Manjarres","319289732","nico@gmail.es",25);
		var u2 = new UsuarioRequest("Dayana","Medina","324654235","desm@gmail.es",230);
		var u3 = new UsuarioRequest("Dayana","Medina","324654235","desm@gmail.es",-7);
		var u4 = new UsuarioRequest("Pepe","Sierra");

		System.out.println(u1.lastname());
		System.out.println(u2.phonenumber());
		System.out.println(u2.equals(u1));
		System.out.println(u2.equals(u3));

		System.out.printf("La edad de u1 es %d, u2 tiene %d y finalmente u3 tiene %d%n", u1.age(),u2.age(),u3.age());

		System.out.println("El usuario es: "+u4);

	}

}
