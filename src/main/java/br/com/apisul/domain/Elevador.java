package br.com.apisul.domain;

public class Elevador {
	private int andar;
	private Character elevador;
	private Character turno;

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public Character getElevador() {
		return elevador;
	}

	public void setElevador(Character elevador) {
		this.elevador = elevador;
	}

	public Character getTurno() {
		return turno;
	}

	public void setTurno(Character turno) {
		this.turno = turno;
	}
}
