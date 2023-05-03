package banco;

import java.util.Scanner;

public class bancoSimples {
	/* Váriáveis do cliente */
	private static int agencia, conta,pin;
	private static String nome;
	private static double saldo=2000;

	public static void main(String[] args) {
		byte opcao;		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite a Opção Desejada ou 0 para sair!\n1-Login Gerente \n2-Login Cliente");
		opcao = entrada.nextByte();	
		
		while(opcao != 0) {
				
			switch(opcao) {
			case 1:
				loginGerente();
				break;
				
			case 2:
				loginCliente();
				break;
				
				default:
					System.out.println("Digite uma opção Válida");
					break;			 
			}
			
			System.out.println("Digite a Opção Desejada ou 0 para sair!\n1-Login Gerente \n2-Login Cliente");
			opcao = entrada.nextByte();		
			
		}
		System.out.println("\n SISTEMA ENCERRATO !\n ");
	}
	
	public static void loginGerente() {/* Inicia Gerente*/
		String usuario = "gerente";
		String usuarioValidar; /* Validação do usuário*/
		int senha = 123;
		int senhaValidar; /* Validação */
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite seu usuario");
		usuarioValidar = entrada.next();
		
		System.out.println("Digite sua senha");
		senhaValidar = entrada.nextInt(); 
		
		if(usuarioValidar.equals(usuario) && senha == senhaValidar) {/* EQUALS utilizado para fazer validação de Strings*/
			System.out.println("\nBem Vindo Gerente\n");
			cadastrarCliente();
		}else {
			System.out.println("Login ou senha Inválidos");
		}
		
		
	} /* Fim do Gerente*/ 
	
	public static void cadastrarCliente() {/* Inicio do cadastrar Cliente*/
		Scanner entrada = new Scanner(System.in);
		System.out.println("\nDigite a Agência");
		agencia = entrada.nextInt();
		
		System.out.println("\nDigite a Conta");
		conta = entrada.nextInt();
		
		System.out.println("\nDigite o primeiro nome");
		nome = entrada.next();
		
		System.out.println("\nDigite o PIN numérico 4 digitos");
		pin = entrada.nextInt();	
		
	}/* Fim do cadastrar Cliente*/
	
	public static void loginCliente() {
		int agenciaValidar,contaValidar, pinValidar;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("\nDigite a Agência");
		agenciaValidar = entrada.nextInt();
		
		System.out.println("\nDigite a Conta");
		contaValidar = entrada.nextInt();
		
		System.out.println("\nDigite o PIN numérico 4 digitos");
		pinValidar = entrada.nextInt();
		
		if(agencia == agenciaValidar && conta == contaValidar && pin == pinValidar) {
			byte opcaoCLiente;
			System.out.println("\nOla Cliente");
			System.out.println("Digite a Opcção:\n 1-Ver Saldo\n2-Depósito\n3-Saque\n0-Para Sair");
			opcaoCLiente = entrada.nextByte();
			while(opcaoCLiente != 0) {
				switch(opcaoCLiente) {
				case 1:
					verSaldo();
					break;
				case 2:
					deposito();
					break;
				case 3: 
					saque();
					break;
					
					default:
					System.out.println("\nOpção Inválida");
					break;
				}
				System.out.println("Digite a Opcção:\n 1-Ver Saldo\n2-Depósito\n3-Saque\n0-Para Sair");
				opcaoCLiente = entrada.nextByte();
			}
		}
		else {
			System.out.println("\nCliente sem Cadastro ou dados Inválidos");
		}
	}
	
	public static void verSaldo() {
		System.out.printf("\nSeu saldo é %.2f \n",saldo);
	}
	
	public static void deposito() {
		double deposito;
		Scanner entrada = new Scanner(System.in);
		System.out.println("\nDigite o valor de depósito");
		deposito = entrada.nextDouble();
		saldo = saldo + deposito;
		
	}
	
	public static void saque() {
		double sacar;
		Scanner entrada = new Scanner(System.in);
		System.out.println("\nDigite o valor para saque");
		sacar = entrada.nextInt();
		
		if(sacar > saldo) {
			System.out.println("\nValor Indisponível para Saque");
		} else {
			saldo = saldo - sacar;
		}
		
	}

}
