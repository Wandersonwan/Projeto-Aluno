package cursojava.executavel;

import javax.swing.JOptionPane;

import cursojava.Class.Aluno;
import cursojava.Class.Disciplina;

public class PrimeiraClassJava {

	public static void main(String[] args) {

		String nome = JOptionPane.showInputDialog("Qual o seu Nome");
		String idade = JOptionPane.showInputDialog("Qual o sua Idade");
		String dataNascimento = JOptionPane.showInputDialog("Qual sua data de Nascimento");

		Aluno aluno1 = new Aluno();

		aluno1.setNome(nome);
		aluno1.setIdade(Integer.valueOf(idade));
		aluno1.setDataNascimento(dataNascimento);

		for (int pos = 1; pos <= 4; pos++) {
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
				posicao ++;
				continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a Remover?");

			}

		}

		System.out.println(aluno1.toString());
		System.out.println("Media do Aluno: " + aluno1.getMediaNota());
		System.out.println("Resultado " + (aluno1.getAlunoAprovado()));

	}

}
