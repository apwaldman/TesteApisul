package br.com.apisul.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import br.com.apisul.domain.Elevador;
import br.com.apisul.utils.Carregar;

public class ElevadorService implements IElevadorService {

	Carregar carregar = new Carregar();

	List<Elevador> elevador = carregar.lerJson();

	// método para obter andares
	public List<Integer> obterAndares() {
		List<Integer> andares = new ArrayList<Integer>();
		for (Elevador elevadorAndar : elevador) {
			andares.add(elevadorAndar.getAndar());
		}
		return andares;
	}

	// método para obter elevadores
	public List<Character> obterElevadores() {
		List<Character> elevadores = new ArrayList<Character>();
		for (Elevador elevadorLetra : elevador) {
			elevadores.add(elevadorLetra.getElevador());
		}
		return elevadores;
	}

	// Método para obter lista de Lista de periodo de mais uso dos eleavadores mais
	// usados
	public List<Character> listaperiodoMaiorFluxoElevadorMaisFrequentado() {
		List<Character> periodo = new ArrayList<>();
		List<Character> elevadorMaisUsado = elevadorMaisFrequentado();
		for (Elevador elevador2 : elevador) {
			for (Character elevadorMaisUsado2 : elevadorMaisUsado) {
				if (elevador2.getElevador().equals(elevadorMaisUsado2)) {
					periodo.add(elevador2.getTurno());
				}
			}
		}
		return periodo;
	}

	// Método para obter lista de Lista de periodo de menor uso dos eleavadores
	// menos usados
	public List<Character> listaperiodoMenorFluxoElevadorMenosFrequentado() {
		List<Character> periodo = new ArrayList<>();
		List<Character> elevadorMenosUsado = elevadorMenosFrequentado();
		for (Elevador elevador2 : elevador) {
			for (Character elevadorMenosUsado2 : elevadorMenosUsado) {
				if (elevador2.getElevador().equals(elevadorMenosUsado2)) {
					periodo.add(elevador2.getTurno());
				}
			}
		}
		return periodo;
	}

	// Lista todos os turnos dos elevadores
	public List<Character> listaPeriodoTodosElevadores() {
		List<Character> periodo = new ArrayList<>();
		for (Elevador elevador2 : elevador) {
			periodo.add(elevador2.getTurno());
		}
		return periodo;
	}

	// Count uso dos elevadores
	public HashMap<Character, Integer> countUsoElevador() {
		HashMap<Character, Integer> elementCountMap = new HashMap<Character, Integer>();
		for (Character i : obterElevadores()) {
			if (elementCountMap.containsKey(i)) {
				elementCountMap.put(i, elementCountMap.get(i) + 1);
			} else {
				elementCountMap.put(i, 1);
			}
		}
		return elementCountMap;
	}

	public Integer somaFrequenciaElementosMapaJson() {
		Integer totalElementos = 0;
		for (Integer f : countUsoElevador().values()) {
			totalElementos += f;
		}
		return totalElementos;
	}

	public Float calculoPercentual(Character siglaElevador) {
		Integer totalElementos = somaFrequenciaElementosMapaJson();
		HashMap<Character, Integer> elementCountMap = countUsoElevador();
		Float percentual = 0f;
		Set<Entry<Character, Integer>> entrySet = countUsoElevador().entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			if (entry.getKey().equals(siglaElevador)) {
				percentual = (float) ((entry.getValue() * 100) / totalElementos);
			}
		}
		return percentual;
	}

	@Override
	public List<Integer> andarMenosUtilizado() {
		List<Integer> andarMenosUsado = new ArrayList<Integer>();
		HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();
		for (int i : obterAndares()) {
			if (elementCountMap.containsKey(i)) {
				elementCountMap.put(i, elementCountMap.get(i) + 1);
			} else {
				elementCountMap.put(i, 1);
			}
		}

		int element = 0;
		Set<Entry<Integer, Integer>> entrySet = elementCountMap.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			if (entry.getValue() == 1) {
				element = entry.getKey();
				andarMenosUsado.add(element);
			}
		}
		return andarMenosUsado;
	}

	@Override
	public List<Character> elevadorMaisFrequentado() {
		List<Character> elevadorMaisUsado = new ArrayList<Character>();
		HashMap<Character, Integer> elementCountMap = new HashMap<Character, Integer>();
		for (Character i : obterElevadores()) {
			if (elementCountMap.containsKey(i)) {
				elementCountMap.put(i, elementCountMap.get(i) + 1);
			} else {
				elementCountMap.put(i, 1);
			}
		}
		Character element;
		Set<Entry<Character, Integer>> entrySet = elementCountMap.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() >= 8) {
				element = entry.getKey();
				elevadorMaisUsado.add(element);
			}
		}
		return elevadorMaisUsado;
	}

	@Override
	public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
		List<Character> periodo = new ArrayList<>();
		HashMap<Character, Integer> elementCountMap = new HashMap<Character, Integer>();
		for (Character i : listaperiodoMaiorFluxoElevadorMaisFrequentado()) {
			if (elementCountMap.containsKey(i)) {
				elementCountMap.put(i, elementCountMap.get(i) + 1);
			} else {
				elementCountMap.put(i, 1);
			}
		}
		Character element;
		Set<Entry<Character, Integer>> entrySet = elementCountMap.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() >= 4) {
				element = entry.getKey();
				periodo.add(element);
			}
		}
		return periodo;
	}

	@Override
	public List<Character> elevadorMenosFrequentado() {
		List<Character> elevadorMenosUsado = new ArrayList<Character>();
		HashMap<Character, Integer> elementCountMap = new HashMap<Character, Integer>();
		for (Character i : obterElevadores()) {
			if (elementCountMap.containsKey(i)) {
				elementCountMap.put(i, elementCountMap.get(i) + 1);
			} else {
				elementCountMap.put(i, 1);
			}
		}
		Character element;
		Set<Entry<Character, Integer>> entrySet = elementCountMap.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() == 1) {
				element = entry.getKey();
				elevadorMenosUsado.add(element);
			}
		}
		return elevadorMenosUsado;
	}

	@Override
	public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
		List<Character> periodo = new ArrayList<>();
		HashMap<Character, Integer> elementCountMap = new HashMap<Character, Integer>();
		for (Character i : listaperiodoMenorFluxoElevadorMenosFrequentado()) {
			if (elementCountMap.containsKey(i)) {
				elementCountMap.put(i, elementCountMap.get(i) + 1);
			} else {
				elementCountMap.put(i, 1);
			}
		}
		Character element;
		Set<Entry<Character, Integer>> entrySet = elementCountMap.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() >= 1) {
				element = entry.getKey();
				periodo.add(element);
			}
		}
		return periodo;
	}

	@Override
	public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
		List<Character> periodoMaisUsado = new ArrayList<>();
		HashMap<Character, Integer> elementCountMap = new HashMap<Character, Integer>();
		for (Character i : listaPeriodoTodosElevadores()) {
			if (elementCountMap.containsKey(i)) {
				elementCountMap.put(i, elementCountMap.get(i) + 1);
			} else {
				elementCountMap.put(i, 1);
			}
		}
		Character element;
		Set<Entry<Character, Integer>> entrySet = elementCountMap.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			if (entry.getValue() >= 10) {
				element = entry.getKey();
				periodoMaisUsado.add(element);
			}
		}
		return periodoMaisUsado;
	}

	@Override
	public float percentualDeUsoElevadorA() {
		return calculoPercentual('A');
	}

	@Override
	public float percentualDeUsoElevadorB() {
		return calculoPercentual('B');
	}

	@Override
	public float percentualDeUsoElevadorC() {
		return calculoPercentual('C');
	}

	@Override
	public float percentualDeUsoElevadorD() {
		return calculoPercentual('D');
	}

	@Override
	public float percentualDeUsoElevadorE() {
		return calculoPercentual('E');
	}
}
