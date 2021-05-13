import javax.swing.JOptionPane;

public class ListaAluno {

	private nodeAluno inicio;

	public ListaAluno() {
		this.inicio = null;
	}

	public void AdicionaInicio(nodeAluno aluno) {

		nodeAluno noh = new nodeAluno(aluno.getRA(), aluno.getNome(), aluno.getTurma(), aluno.getSemestre());
		if (inicio != null) {
			noh.prox = inicio;
			inicio.anterior = noh;
		}
		inicio = noh;

	}

	public void AdicionaFinal(nodeAluno aluno) {

		nodeAluno noh = new nodeAluno(aluno.getRA(), aluno.getNome(), aluno.getTurma(), aluno.getSemestre());
		if (inicio == null) {
			inicio = noh;
			noh.anterior = null;
			noh.prox = null;
		} else {
			nodeAluno aux = inicio;
			while (aux.prox != null) {
				aux = aux.prox;
			}
			aux.prox = noh;
			noh.anterior = aux;
			noh.prox = null;
		}
	}

	public void AdicionaPosicao(nodeAluno aluno, int pos) {

		nodeAluno noh = new nodeAluno(aluno.getRA(), aluno.getNome(), aluno.getTurma(), aluno.getSemestre());

		if (pos == 1) {
			AdicionaInicio(aluno);
		} else {
			nodeAluno nohAux = inicio;
			int contador = 1;

			while (nohAux != null && contador < (pos - 1)) {
				nohAux = nohAux.prox;
				contador++;
			}
			if (contador == (pos - 1)) {
				noh.prox = nohAux.prox;
				nohAux.prox = noh;
				noh.anterior = nohAux;
			} else {
				JOptionPane.showMessageDialog(null, "Posição inválida");
			}

		}
	}

	public String RemoveInicio() {

		String i = "";
		if (inicio == null) {
			JOptionPane.showMessageDialog(null, "Lista vazia");
		} else {
			i = inicio.getNome();
			inicio = inicio.prox;
			if (inicio != null) {
				inicio.anterior = null;
			}
		}
		return i;
	}

	public String RemoveFinal() {
		String i = "";

		if (inicio == null) {
			JOptionPane.showMessageDialog(null, "Lista vazia");
		} else if (inicio.prox == null) {
			i = inicio.getNome();
			inicio = null;
		} else {
			nodeAluno aux = auxRemoveFinalRecursivo(inicio, inicio);
			i = aux.prox.getNome();
			aux.prox.anterior = null;
			aux.prox = null;
		}
		return i;
	}
	
	public nodeAluno auxRemoveFinalRecursivo(nodeAluno aux1, nodeAluno aux2) {
		if(aux1.prox != null) {
			return auxRemoveFinalRecursivo(aux1.prox, aux1); //Recursividade direta no método de busca
		}
		return aux2;
	}
	

	public String removePosicao(int pos) {
		String i = "";
		int j = 1;
		nodeAluno nohAux = inicio;

		if (inicio != null) {
			if (pos == 1) {
				i = RemoveInicio();
				return i;
			} else {
				while (nohAux.prox != null) {
					nohAux = nohAux.prox;
					j++;
				}
				if (pos > j || pos <= 0) {
					JOptionPane.showMessageDialog(null, "Posição inválida");
					return i;
				} else if (pos == j) {
					i = RemoveFinal();
					return i;
				} else {
					nohAux = inicio;
					nodeAluno nohAux2 = nohAux;

					while (pos > 1) {
						nohAux2 = nohAux;
						nohAux = nohAux.prox;
						pos--;
					}
					i = nohAux.getNome();
					if(nohAux.prox.prox !=null) {
						nohAux.prox.anterior = nohAux2;
					}
					nohAux2.prox = nohAux.prox;
					return i;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Lista vazia");
			return i;
		}

	}

	public void percorreLista() {
		if (inicio != null) {
			nodeAluno nohAux = inicio;
			System.out.println("Lista de Alunos: ");
			System.out.print(nohAux.getNome() + " | ");

			while (nohAux.prox != null) {
				nohAux = nohAux.prox;
				System.out.print(nohAux.getNome() + " | ");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Lista vazia");
		}
		System.out.println("");
	}

}
