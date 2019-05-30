package connorsRedemption;

public class MainTester {
	
	// APENAS PARA DEBUGAR, DEPOIS SERA DELETADO.
		public static void main(String[] args) {

			Arma metralhadora = new Arma("metralhadora", 30, 4, 55.5); // futuramente tambem pretendo entrar com o sprite
																		// como parametro
			System.out.println(metralhadora.getQtdMunicao());

			System.out.println("Vou atirar!");
			System.out.println("Quantidade de Cartucho: " + metralhadora.getQtdCartucho());

			while (metralhadora.getQtdMunicao() > 0) {

				metralhadora.atirar();
				if (metralhadora.getQtdCartucho() > 0) {
					System.out.println("Tiro: " + metralhadora.getQtdMunicao());
				} else {
					break;
				}
				if (metralhadora.getQtdMunicao() <= 1) {
					System.out.println("Tenho que recarregar");
					metralhadora.carregar();
					System.out.println("Quantidade de Cartucho: " + metralhadora.getQtdCartucho());
				}
			}
			System.out.println();
			System.out.println("Status quantidade de bala atual: " + metralhadora.getQtdMunicao());
			System.out.println("Status quantidade de Cartucho atual: " + metralhadora.getQtdCartucho());
			
			Ar ar = new Ar("gas", null, 0.0f, 0.0f); // so pra testar herança
			
			ar.detectarColisao("nomeObjeto", 0.0f, 0.0f); // so pra testar herança
			
			

		}
		
		
		



}








