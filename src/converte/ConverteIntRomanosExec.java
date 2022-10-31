package converte;

import java.util.Scanner;

import grupos.Converte;

public class ConverteIntRomanosExec {

	public static void main(String[] args) {

		Converte c = new Converte();// criando o objeto e instanciando
		
		Scanner sc = new Scanner(System.in); 
		int op;
		String romano="";
		String estat="";
		String inteiroaux="";
				
		// pergunta de o tipo de conversão
		System.out.println("Informe o tipo de conversão a ser feita: 1- de inteiro para romano ; 2 - romano para inteiro");
		op = sc.nextInt();
		
		if(op == 1) {
			// converte de inteiro para romano
			
			System.out.println("Digite um numero entre 1 e 3999:"); // acima de 4000 recebe o o carater - em cima do valor -IV
			c.valorInteiro =sc.next();
			
			if (c.validarInteiro()==true) {
				// significa que é numero
				romano = c.converterIntRom();
				// estatistica
				estat= c.estatistica();
				
				//escreve aqui
				System.out.println(c);	
			}else {
				System.out.println("Numero invalido!");
			}
		}else{		
		// opcao 2
		// converte de romano para inteiro	
			
			System.out.println("Digite um numero entre I e MMMCMXCIX (3999): "); // limita a 3999 por causa do simbolo "- na frente do -IV", que seria em cima
			c.valorRomano =sc.next();
			c.valorRomano=c.valorRomano.toUpperCase(); // garante que todas as letras serão maiusculas
			
			if (c.validarRomano()==true){
				if (c.verificaValidadeRomano()==true) {
					inteiroaux = c.converteRomInt();
					estat= c.estatistica();
					System.out.println(c);
				}else{
					System.out.println("Digite um numero romano valido!");
					c.valorRomano = "";
					System.out.println(c);
				}
			}else{
				System.out.println("Digite um numero romano valido!");
			 	c.valorRomano = "";
			}
				
		}	
								
		sc.close();
		
	}
	
}