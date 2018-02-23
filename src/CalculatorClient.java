import java.rmi.Naming;

import javax.swing.JOptionPane;

public class CalculatorClient {
	public static void main(String[] args) {
		try {
			Calculator c = (Calculator) Naming.lookup("//localhost:1020/CalculatorService");
			String opcao[] = { "+", "-", "*", "/" };
			String entradaN1 = JOptionPane.showInputDialog("Entre com o primeiro valor: ");
			int n1 = Integer.parseInt(entradaN1);
			int operacao = JOptionPane.showOptionDialog(null, "Escolha uma das operacoes", "Tipo de operacao", 0,
					JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);
			String entradaN2 = JOptionPane.showInputDialog("Entre com o segundo valor: ");
			int n2 = Integer.parseInt(entradaN2);
			if (operacao == 0) {
				System.out.println(c.add(n1, n2));
			} else if (operacao == 1) {
				System.out.println(c.sub(n1, n2));
			} else if (operacao == 2) {
				System.out.println(c.mul(n1, n2));
			} else {
				System.out.println(c.div(n1, n2));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
