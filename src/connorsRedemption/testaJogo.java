package connorsRedemption;

public class testaJogo {
	public static void main(String [] args) {
    	mainloop();
    	
    }
	
	public static void mainloop() {
		Jogo jogo = new Jogo();
		
		long excess = 0;
		long noDelays = 0;
		final long DESIRED_UPDATE_TIME = 40;
		final long NO_DELAYS_PER_YIELD = 16;
		 
		long overSleepTime = 0;
		
		while (jogo.isJogoAtivo()) {
		   long beforeTime = System.currentTimeMillis();
		 
		   //Pula os quadros enquanto o tempo for em excesso.
		   while (excess > DESIRED_UPDATE_TIME) {
		        jogo.processaLogica();
		        excess -= DESIRED_UPDATE_TIME;
		    }
		 
		   jogo.processaLogica();
		   jogo.processaGrafico();
		 
		   long afterTime = System.currentTimeMillis();
		   long totalTime = afterTime - beforeTime;
		 
		   if (totalTime < DESIRED_UPDATE_TIME) {
		        sleep(Math.abs(DESIRED_UPDATE_TIME - totalTime - overSleepTime));
		        long afterSleepTime = System.currentTimeMillis();
		        overSleepTime = afterSleepTime - afterTime;
		        noDelays = 0;
		    }
		    else {
		        overSleepTime = 0;
		        excess += totalTime - DESIRED_UPDATE_TIME;
		        if (++noDelays == NO_DELAYS_PER_YIELD)
		            Thread.yield();
		    }
		}
		
		
	}
	
	public static void sleep(long millis) {
	    try {
	       Thread.sleep(millis);
	   } catch (InterruptedException e) {}
	}
}
