package connorsRedemption;


public class MainTester {
	
	// APENAS PARA DEBUGAR, DEPOIS SERA DELETADO.
		public static void main(String[] args) {

		//logicaArma1();
		logicaArma2();	
			
		}
		
		public static void logicaArma1() {

			Arma metralhadora = new Arma("metralhadora", 30, 4); // futuramente tambem pretendo entrar com o sprite
																		// como parametro
			System.out.println(metralhadora.getQtdMunicao());

			System.out.println("Vou atirar!");
			System.out.println("Quantidade de Cartucho: " + metralhadora.getQtdCartucho());

			while (metralhadora.getQtdMunicao() > 0) {

				metralhadora.atirar1();
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

		}
		
		public static void logicaArma2() {
			Arma metralhadora = new Arma("metralhadora", 30, 4); // futuramente tambem pretendo entrar com o sprite
            
			while(true) {
				metralhadora.atirar2(true);
				if(metralhadora.getQtdMunicao() == 0) {
					break;
				}
					
				
			}
		}
		
}









