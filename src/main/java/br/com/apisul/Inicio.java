package br.com.apisul;

import java.util.List;
import br.com.apisul.services.ElevadorService;


public class Inicio {

	public static void main(String[] args) {
		ElevadorService es = new ElevadorService();
		
		System.out.println("Andar(es) menos utilizado:");
		List<Integer> andarMenosUsado = es.andarMenosUtilizado();
		System.out.println(andarMenosUsado);
		
		System.out.println("\nElevador(es) mais usados");
		List<Character> elevadorMaisFrequentado = es.elevadorMaisFrequentado();
		System.out.println(elevadorMaisFrequentado);
		
		System.out.println("\nPeríodo de mais uso dos elevador(es) mais usados");
		List<Character> periodoElevadorMaisFrequentado = es.periodoMaiorFluxoElevadorMaisFrequentado();
		System.out.println(periodoElevadorMaisFrequentado);
		
		System.out.println("\nElevador(es) menos usados");
		List<Character> elevadorMenosFrequentado = es.elevadorMenosFrequentado();		System.out.println(elevadorMenosFrequentado);
		System.out.println(elevadorMenosFrequentado);
		
		System.out.println("\nPeríodo de menor uso dos elevador(es) menos usados");
		List<Character> periodoElevadorMenosFrequentado = es.periodoMenorFluxoElevadorMenosFrequentado();
		System.out.println(periodoElevadorMenosFrequentado);
		
		System.out.println("\nPeríodo de maior uso de todos os elevador(es)");
		List<Character> peridodoMaiorUso = es.periodoMaiorUtilizacaoConjuntoElevadores();
		System.out.println(peridodoMaiorUso);
		
		System.out.println("\nPercentual uso elevador A:");
		System.out.println(es.percentualDeUsoElevadorA());
		
		System.out.println("\nPercentual uso elevador B:");
		System.out.println(es.percentualDeUsoElevadorB());
		
		System.out.println("\nPercentual uso elevador C:");
		System.out.println(es.percentualDeUsoElevadorC());
		
		System.out.println("\nPercentual uso elevador D:");
		System.out.println(es.percentualDeUsoElevadorD());
		
		System.out.println("\nPercentual uso elevador E:");
		System.out.println(es.percentualDeUsoElevadorE());
	}

}
