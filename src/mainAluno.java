
import javax.swing.JOptionPane;

public class mainAluno {

	public static void main(String[] args) {
		
		nodeAluno aluno = new nodeAluno(0, "", "", "");
		
		int opc = 0, pos;
		
		ListaAluno la = new ListaAluno();
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1- Adiciona Inicio \n "
					+ "2 - Adiciona Final \n "
					+ "3 - Escolhe posi��o \n "
					+ "4 - Remove Inicio \n "
					+ "5 - Remove Final\n"
					+ "6 - Esolhe posi��o para remover\n"
					+ "7 - Exibir lista;"
					+ "8 - Exibir lista com detalhes"));
			
			switch(opc) {
			
				case 1: aluno = setarAluno(aluno);
					la.AdicionaInicio(aluno);
					break;
					
				case 2: aluno = setarAluno(aluno);
					la.AdicionaFinal(aluno);
					break;
				
				case 3: aluno = setarAluno(aluno);
					pos = Integer.parseInt(JOptionPane.showInputDialog("Informe uma posi��o para inser��o: "));
					la.AdicionaPosicao(aluno, pos);
					break;
					
				case 4: 
					JOptionPane.showMessageDialog(null, "O elemento removido foi : " +la.RemoveInicio());
					break;
				
				case 5: 
					JOptionPane.showMessageDialog(null, "O elemento removido foi : " +la.RemoveFinal());
					break;
					
				case 6: 
					pos = Integer.parseInt(JOptionPane.showInputDialog("Digite uma posi��o para remo��o"));
					JOptionPane.showMessageDialog(null, "O elemento removido foi: " + la.removePosicao(pos));
					break;
					
				case 7: 
					la.percorreLista();
				break;
				
				case 8:
					//Implementando
						System.out.println("Implementando");
					break;
			
			}
		}while (opc!=0);
		

	}
	
	public static nodeAluno setarAluno(nodeAluno aluno) {
		
		int ra = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA : "));
		aluno.setRA(ra);
		aluno.setNome(JOptionPane.showInputDialog("Digite o nome :"));
		aluno.setTurma(JOptionPane.showInputDialog("Digite a turma: "));
		aluno.setSemestre(JOptionPane.showInputDialog("Qual � o semestre: "));
		
		
		return aluno;
	}

}
