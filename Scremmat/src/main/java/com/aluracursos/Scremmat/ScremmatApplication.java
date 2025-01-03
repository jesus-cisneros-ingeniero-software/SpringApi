package com.aluracursos.Scremmat;

import com.aluracursos.Scremmat.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScremmatApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScremmatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("hola mundo desde spring");
		var consumoAPI = new ConsumoAPI();
		var apikey="eb132581";
		var json=consumoAPI.obtenerDatos("https://www.omdbapi.com/?i=tt3896198&apikey=eb132581");
		System.out.println("json = " + json);
	}
}
