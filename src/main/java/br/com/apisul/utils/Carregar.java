package br.com.apisul.utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.apisul.domain.Elevador;


public class Carregar {

	private List<Elevador> list = new ArrayList<>();
	
	public List<Elevador> lerJson() {
		List<Elevador> elevador = new ArrayList<>();
		try {
			ObjectMapper om = new ObjectMapper();			
			Resource resource = new ClassPathResource("input.json");
			File file = resource.getFile();			 
			elevador = Arrays.asList(om.readValue(file, Elevador[].class));
			list.addAll(elevador);
		} catch(Exception e) {
			System.out.println(
				"Ocorreu erro na leitura do arquivo");
		}		
		return elevador;
	}
}
		

	