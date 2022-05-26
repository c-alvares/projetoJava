package controle;

import java.text.ParseException;

import java.util.ArrayList;

import modelo.Cadastro;

public class DespesaProcess {

	public static ArrayList<Cadastro> des = new ArrayList<>();
	private static DAO ds = new DAO();

	public static void abrir() {
		des = ds.ler();
	}

	public static void salvar() {
		ds.escrever(des);
	}

	public static void carregarDespesa() throws ParseException {
		des = new ArrayList<>();

		des.add(new Cadastro(0, "Andre", "12/03/2022", "Expoflora", "transporte", 16d));
		des.add(new Cadastro(1, "Andre", "12/03/2022", "Expoflora", "Almoco", 30d));
		des.add(new Cadastro(2, "Andre", "12/03/2022", "Expoflora", "entrada", 50d));
		des.add(new Cadastro(3, "Andre", "12/03/2022", "Expoflora", "Lembrancinhas", 15d));
		des.add(new Cadastro(4, "Ciro", "15/04/2022", "CCXP", "Entrada", 100d));
		des.add(new Cadastro(5, "Ciro", "15/04/2022", "CCXP", "trasporte", 140d));
		des.add(new Cadastro(6, "Ciro", "15/04/2022", "CCXP", "Almoco", 20d));
		des.add(new Cadastro(7, "Ciro", "15/04/2022", "CCXP", "jantar", 35d));
		des.add(new Cadastro(8, "Rodrigo", "01/05/2022", "BGS", "Entrada", 90d));
		des.add(new Cadastro(9, "Rodrigo", "01/05/2022", "BGS", "trasporte", 40d));
		des.add(new Cadastro(10, "Rodrigo", "01/05/2022", "BGS", "hospedagem", 150d));
		des.add(new Cadastro(11, "Rodrigo", "01/05/2022", "BGS", "Almoco", 35d));
		des.add(new Cadastro(12, "Rodrigo", "01/05/2022", "BGS", "jantar", 65d));
	}
}
