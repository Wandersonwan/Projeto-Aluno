package cursojava.executavel;

import java.awt.JobAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.Class.Aluno;
import cursojava.Class.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiraClassJava {

	public static void main(String[] args) {
		
		String login = JOptionPane.showInputDialog(" informe o login ");
		String senha = JOptionPane.showInputDialog(" informe a Senha ");
		
		if (login.equalsIgnoreCase("admin")&&
				senha.equalsIgnoreCase("admin")) {
			
		
		

		List<Aluno> alunos = new ArrayList<Aluno>();

		/*
		 * é uma lista que dentro dela remos uma chave que identifica uma sequencia de
		 * valores tambem
		 */

		HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

		List<Aluno> alunosAprovado = new ArrayList<Aluno>();
		List<Aluno> alunosRecuperacao = new ArrayList<Aluno>();
		List<Aluno> alunosReprovados = new ArrayList<Aluno>();

		for (int qtd = 1; qtd <= 5; qtd++) {

			String nome = JOptionPane.showInputDialog("Qual o Nome do Aluno " + qtd + " ");
			String idade = JOptionPane.showInputDialog("Qual o sua Idade");
			String dataNascimento = JOptionPane.showInputDialog("Qual sua data de Nascimento");

			Aluno aluno1 = new Aluno();

			aluno1.setNome(nome);
			aluno1.setIdade(Integer.valueOf(idade));
			aluno1.setDataNascimento(dataNascimento);

			for (int pos = 1; pos <= 1; pos++) {
				String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina " + pos + " ");
				String notaDisciplina = JOptionPane.showInputDialog("Qual a Nota  " + pos + " ");

				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(Double.valueOf(notaDisciplina));

				aluno1.getDisciplinas().add(disciplina);

			}

			int escolha = JOptionPane.showConfirmDialog(null, "Quer remover alguma disciplina?");
			if (escolha == 0) {

				int continuarRemover = 0;
				int posicao = 1;

				while (continuarRemover == 0) {
					String disciplinaRemover = JOptionPane.showInputDialog("Qual disciplina, 1, 2, 3 ou 4?");
					aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
					posicao++;
					continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a Remover?");
				}
			}
			alunos.add(aluno1);
		}

		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

		for (Aluno aluno : alunos) {
			if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
				maps.get(StatusAluno.APROVADO).add(aluno);
			} else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				maps.get(StatusAluno.RECUPERACAO).add(aluno);
			} else {
				alunosReprovados.add(aluno);
			}
		}

		System.out.println("------------Lista dos Aprovados-----------");

		for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
			System.out.println("Resultado = " + aluno.getAlunoAprovado() + "com Média de = " + aluno.getMediaNota());
		}

		System.out.println("------------Lista dos Recuperação-----------");

		for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
			System.out.println("Resultado = " + aluno.getAlunoAprovado() + "com Média de = " + aluno.getMediaNota());
		}

		System.out.println("------------Lista dos Reprovados-----------");

		for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
			System.out.println("Resultado = " + aluno.getAlunoAprovado() + "com Média de = " + aluno.getMediaNota());
		}
		}else {
			JOptionPane.showMessageDialog(null, "Senha ou Usuario incorreto");
		}
		
	}

}
