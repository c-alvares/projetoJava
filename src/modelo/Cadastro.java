package modelo;

import java.util.Objects;

public class Cadastro {

	private String funcionario;
	private String data;
	private String evento;
	private String despesas;
	private Double valorDespesa;
	private int id;

	public Cadastro(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getId(String s) {
		return String.format("%d", id);
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		return id == other.id;
	}

	public Cadastro(int id, String funcionario, String data, String evento, String despesas, Double valorDespesa) {

		this.id = id;
		this.funcionario = funcionario;
		this.data = data;
		this.evento = evento;
		this.despesas = despesas;
		this.valorDespesa = valorDespesa;
	}

	public Cadastro(String linha) {
		this.data = linha.split(";")[0];
		this.funcionario = linha.split(";")[1];
		this.evento = linha.split(";")[2];
		this.despesas = linha.split(";")[3];

	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getDespesas() {
		return despesas;
	}

	public void setDespesas(String despesas) {
		this.despesas = despesas;
	}

	public Double getValorDespesa() {
		return valorDespesa;
	}

	public String getValorDespesa(String string) {
		return String.format("%.2f", valorDespesa);
	}

	public void setValorDespesa(Double valorDespesa) {
		this.valorDespesa = valorDespesa;
	}

	public String toCSV() {
		return funcionario + ";" + data + ";" + evento + ";" + despesas + ";" + valorDespesa + "\r\n";
	}

}
