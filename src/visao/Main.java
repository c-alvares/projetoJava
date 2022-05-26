package visao;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import controle.DespesaProcess;
import modelo.Cadastro;

public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel painel;
	private JLabel id, funcionario, data, evento, despesas, valordespesa;
	private JTextField tfid, tfFuncionario, tfData, tfEvento, tfDespesas, tfValorDespesas;
	private JTable table;
	private JButton btEnviar, btExcluir;
	private JScrollPane rolagem;
	private DefaultTableModel tableModel;
	private JTextArea area;
	private String texto = "";
	private int autoId = DespesaProcess.des.size() + 1;

	Main() {

		setTitle("Nota fiscal");
		setBounds(100, 100, 800, 600);
		painel = new JPanel();
		painel.setBackground(new Color(255, 255, 204));
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		id = new JLabel("id");
		id.setBounds(20, 10, 500, 20);
		painel.add(id);

		funcionario = new JLabel("Funcionário");
		funcionario.setBounds(20, 40, 500, 20);
		painel.add(funcionario);
		funcionario.setFont(new Font("Arial", Font.PLAIN, 15));

		data = new JLabel("Data");
		data.setBounds(20, 80, 500, 20);
		painel.add(data);
		data.setFont(new Font("Arial", Font.PLAIN, 15));

		evento = new JLabel("Evento");
		evento.setBounds(20, 120, 500, 20);
		painel.add(evento);
		evento.setFont(new Font("Arial", Font.PLAIN, 15));

		despesas = new JLabel("Despesa");
		despesas.setBounds(20, 160, 500, 20);
		painel.add(despesas);
		despesas.setFont(new Font("Arial", Font.PLAIN, 15));

		valordespesa = new JLabel("Valor");
		valordespesa.setBounds(20, 200, 500, 20);
		painel.add(valordespesa);
		valordespesa.setFont(new Font("Arial", Font.PLAIN, 15));
		table = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.addColumn("id");
		tableModel.addColumn("Funcionário");
		tableModel.addColumn("Data");
		tableModel.addColumn("Evento");
		tableModel.addColumn("Despesa");
		tableModel.addColumn("Valor da despesa");
		preencherTabela();
		table = new JTable(tableModel);
		table.setEnabled(false);
		rolagem = new JScrollPane(table);
		rolagem.setBounds(20, 310, 740, 230);
		painel.add(rolagem);

		tfid = new JTextField(String.format("%d",autoId));
		tfid.setBounds(100, 10, 200, 20);
		painel.add(tfid);
		tfid.setEditable(false);

		tfFuncionario = new JTextField();
		tfFuncionario.setBounds(100, 40, 200, 25);
		painel.add(tfFuncionario);

		tfData = new JTextField();
		tfData.setBounds(100, 80, 200, 25);
		painel.add(tfData);

		tfEvento = new JTextField();
		tfEvento.setBounds(100, 120, 200, 25);
		painel.add(tfEvento);

		tfDespesas = new JTextField();
		tfDespesas.setBounds(100, 160, 200, 25);
		painel.add(tfDespesas);

		tfValorDespesas = new JTextField();
		tfValorDespesas.setBounds(100, 200, 200, 25);
		painel.add(tfValorDespesas);

		btEnviar = new JButton("Enviar");
		btEnviar.setBounds(400, 50, 100, 20);
		painel.add(btEnviar);

		btExcluir = new JButton("Excluir");
		btExcluir.setBounds(505, 50, 100, 20);
		painel.add(btExcluir);

		area = new JTextArea();
		area.setBounds(400, 90, 300, 200);
		painel.add(area);

		btEnviar.addActionListener(this);
		btExcluir.addActionListener(this);

	}

	private void enviar() {
		if (tfFuncionario.getText().length() != 0 && tfData.getText().length() != 0 && tfEvento.getText().length() != 0
				&& tfDespesas.getText().length() != 0 && tfValorDespesas.getText().length() != 0) {

			DespesaProcess.des.add(new Cadastro(autoId, tfFuncionario.getText(), tfData.getText(), tfEvento.getText(),
					tfDespesas.getText(), Double.parseDouble(tfValorDespesas.getText())));
			autoId++;
			preencherTabela();
			limparCampos();

		} else {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos");
		}

	}

	public void limparCampos() {
		tfFuncionario.setText(null);
		tfData.setText(null);
		tfEvento.setText(null);
		tfDespesas.setText(null);
		tfValorDespesas.setText(null);
	}

	private void preencherTabela() {
		for (Cadastro c : DespesaProcess.des) {
			tableModel.addRow(new String[] { c.getId("s"), c.getFuncionario(), c.getData(), c.getEvento(),
					c.getDespesas(), c.getValorDespesa("s") });
		}

	}

	public static void main(String[] args) throws ParseException {
		DespesaProcess.carregarDespesa();
		new Main().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btEnviar) {
			enviar();
		}
		if (e.getSource() == btExcluir) {
			excluir();
		}

	}

	private void excluir() {
		
		int id = Integer.parseInt(tfid.getText());
		Cadastro cadastro = new Cadastro(id);
		int indice = DespesaProcess.des.indexOf(cadastro);
		DespesaProcess.des.remove(indice);
		preencherTabela();
		limparCampos();
		tfid.setText(String.format("%d", autoId));
	}

}
