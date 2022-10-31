package grupos;

public class Converte {
	public String valorInteiro =""; //recebe o numero a ser convertido
	public String valorRomano="";
	private int retorno =0;
	
	//tabela para o calculo estatistico
	int Ie=0;
	int Ve=0;
	int Xe=0;
	int Le=0;
	int Ce=0;
	int De=0;
	int Me=0;
	
	public boolean validarInteiro() {
		int valorAux= Integer.parseInt(valorInteiro);
		
		//verifica se é numero e se esta dentro da faixa delimitada
		
		if (valorInteiro.matches("^[0-9]*$")) {
			if(valorAux<10001 && valorAux>0) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	public boolean validarRomano() {
		int cont;
		
		if (valorRomano.length()>0) {
			//verifica se as letras inseridas formam um numero romano
			for(cont=0; cont < valorRomano.length(); cont++){
				 if((valorRomano.charAt(cont) != 'I')&&(valorRomano.charAt(cont) != 'V')&&(valorRomano.charAt(cont) != 'X')&&(valorRomano.charAt(cont) != 'L')&&(valorRomano.charAt(cont) != 'C')&&(valorRomano.charAt(cont) != 'D')&&(valorRomano.charAt(cont) != 'M')){
		 	    	return false;
		 	    }
			}
		}
		return true;
	}
	
	public boolean verificaValidadeRomano() {
		int i;
		char ant, num, prox, verificador;
		
		//verifica se tem alguma letra repetida fora da regra:
		//com exceção de V, L e D, todas podem se repetir mais de 3 vezes
		if (valorRomano.length()>3) {
			for(i=0; i < valorRomano.length(); i++){
				if (i == 0){
					 ant =valorRomano.charAt(i);
					 num = valorRomano.charAt(i+1);
					 prox = valorRomano.charAt(i+2);
					 verificador = valorRomano.charAt(i+3);
					 
					 if ((ant == num)&&(num == prox)&&(prox ==verificador)&&(verificador==ant)) {
						 return false;
					 }
				 }else {
					 if ((i+3)< valorRomano.length()) {
						 ant =valorRomano.charAt(i);
						 num = valorRomano.charAt(i+1);
						 prox = valorRomano.charAt(i+2);
						 verificador = valorRomano.charAt(i+3);
						 
						 if ((ant == num)&&(num == prox)&&(prox ==ant)&&(verificador==ant)) {
							 System.out.println("Digite um numero romano valido, repetição acima do permitido!");
					 	    	return false;
						 }
						 if (((ant =='V')&&(num =='V'))||((ant =='V')&& (prox=='V'))||((prox =='V')&& (verificador=='V'))) {
							 System.out.println("Digite um numero romano valido, repetição acima do permitido!");
				 	    	 return false;
						 }
						 if (((ant =='L')&&(num =='L'))||((ant =='L')&& (prox=='L'))||((prox =='L')&& (verificador=='L'))) {
							 System.out.println("Digite um numero romano valido, repetição acima do permitido!");
				 	    	 return false;
						 }
						 if (((ant =='D')&&(num =='D'))||((ant =='D')&& (prox=='D'))||((prox =='D')&& (verificador=='D'))) {
							 System.out.println("Digite um numero romano valido, repetição acima do permitido!");
				 	    	 return false;
						 }
					 }
				}
			}
			
			//return true;
		}else {
			//caso se menor que 4
			if(valorRomano.length()>2) {
				i =0;
				ant =valorRomano.charAt(i);
				num = valorRomano.charAt(i+1);
				prox = valorRomano.charAt(i+2);
				if (((ant =='V')&&(num =='V'))||((ant =='V')&& (prox=='V'))||((prox =='V'))) {
					 System.out.println("Digite um numero romano valido, repetição acima do permitido!");
		 	    	 return false;
				 }
				 if (((ant =='L')&&(num =='L'))||((ant =='L')&& (prox=='L'))||((prox =='L'))) {
					 System.out.println("Digite um numero romano valido, repetição acima do permitido!");
		 	    	 return false;
				 }
				 if (((ant =='D')&&(num =='D'))||((ant =='D')&& (prox=='D'))||((prox =='D'))) {
					 System.out.println("Digite um numero romano valido, repetição acima do permitido!");
		 	    	 return false;
				 }
			}else {
				if(valorRomano.length()>1) {
					i =0;
					ant =valorRomano.charAt(i);
					num = valorRomano.charAt(i+1);
					if (((ant =='V')&&(num =='V'))||((ant =='V'))) {
						 System.out.println("Digite um numero romano valido, repetição acima do permitido!");
			 	    	 return false;
					 }
					 if (((ant =='L')&&(num =='L'))||((ant =='L'))) {
						 System.out.println("Digite um numero romano valido, repetição acima do permitido!");
			 	    	 return false;
					 }
					 if (((ant =='D')&&(num =='D'))||((ant =='D'))) {
						 System.out.println("Digite um numero romano valido, repetição acima do permitido!");
			 	    	 return false;
					 }
				}
			}
			
		}
		return true;
	}
	public String converterIntRom() {
		int cont;
		
		String[] rom= {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
		int[] i= {1,4,5,9,10,40,50,90,100,400,500,900,1000};
		//String romano ="";
		int valorAux= Integer.parseInt(valorInteiro);
		
		for (cont=((rom.length)-1); cont>=0; cont--) { 
			while(valorAux >= i[cont]) {
				//System.out.println("valorAux "+valorAux);
				valorRomano= valorRomano + rom[cont];
				//System.out.println("rom-cont "+rom[cont]);
				valorAux= valorAux- i[cont];
				//System.out.println("i-cont "+i[cont]);
				//System.out.println("valorAux "+valorAux);
			}	
		}
		return valorRomano;
	}
	
	public String converteRomInt() {
		int cont=0;
		char ant, num;
		int inteiro = 0;
		
		for(cont=0; cont < valorRomano.length(); cont++){
			//System.out.println("rom"+romano.charAt(cont));
			if (cont == 0) {
				ant =valorRomano.charAt(cont);
				if (ant=='I') {
					inteiro = 1;
				 }else {
					 if (ant=='V') {
						 inteiro = 5;
					 }else {
						 if (ant=='X') {
							 inteiro = 10;
						 }else {
							 if (ant=='L') {
								 inteiro = 50;
							 }else {
								 if (ant=='C') {
									 inteiro = 100;
								 }else {
									 if (ant=='D') {
										 inteiro = 500;
									 }else {
										 inteiro = 1000;
									 }
								 }
							 }
						 }
					 }
				 }
			}else {		
				if ((cont+1)< valorRomano.length()){
					//System.out.println("entrou pra comparar");
					 ant =valorRomano.charAt(cont);
					 num = valorRomano.charAt(cont+1);
					 //prox = romano.charAt(cont+2);
					 if ((ant=='I')&&(num=='I')) {
						 inteiro = inteiro + 1;
					 }else {
						 if ((ant=='I')&&(num=='V')) {
							 inteiro = inteiro + 5;
						 }else {
							 if ((ant=='I')&&(num=='X')) {
								 inteiro = inteiro + 10;
							 }else {
								 if ((ant=='I')&&(num=='L')) {
									 inteiro = inteiro + 50;
								 }else {
									 if ((ant=='I')&&(num=='C')) {
										 inteiro = inteiro + 100;
									 }else {
										 if ((ant=='I')&&(num=='D')) {
											 inteiro = inteiro + 500;
										 }else {
											 // fazer se menor
										 	}
										 }
									 }
								 }
							 }
					 	}
				 }
 	     }
		 valorInteiro= Integer.toString(inteiro);
		 
		}
		return valorInteiro;
	}
	public String estatistica() {
		// faz o calculo das estatisticas
		int cont;
		String estat="";
		
		if (valorRomano!=null) {
			for(cont=0; cont < valorRomano.length(); cont++){
		 	    if(valorRomano.charAt(cont) == 'I'){
		 	    	Ie=Ie+1;
		 	    }else {
					if(valorRomano.charAt(cont) == 'V') {
						Ve=Ve+1;
					}else {
						if(valorRomano.charAt(cont) == 'X') {
							Xe=Xe+1;
						}else {
							if(valorRomano.charAt(cont) == 'L') {
								Le=Le+1;
							}else {
								if(valorRomano.charAt(cont) == 'C') {
									Ce=Ce+1;
								}else {
									if(valorRomano.charAt(cont) == 'D'){
										De=De+1;
									}else {
										if(valorRomano.charAt(cont) == 'M') {
											Me=Me+1;
										}
									}
								}
							}
						}
					}
		 	    }
			}
		}
		estat = "Ie = "+Ie+"\n Ve = "+Ve+"\n Xe = "+Xe+"\n Le = "+Le+"\n Ce = "+De+"\n Me = "+Me;
		return(estat);
	}
	
	
	public String toString() {
		return "\nValor digitado: "+valorInteiro+" - correspondente romano: "+valorRomano+"\n\nEstatistica: \nI = "+Ie+ "\nV = "+Ve+"\nX = "+Xe+ "\nL = "+Le+ "\nC = "+Ce+"\nD = "+De+"\nM = "+Me;
	}
}
