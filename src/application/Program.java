package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Calculator;


public class Program {

	public static void main(String[] args) {
		
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Cadastro do an�ncio");
		System.out.println();
		System.out.print("Nome do an�ncio: ");
		String adsName = sc.next();
		System.out.print("Cliente: ");
		sc.nextLine();
		String clientName = sc.nextLine();
		System.out.print("Data de in�cio (dd/MM/yyyy): ");
		Date initDate = sdf.parse(sc.next());
		System.out.print("Data de t�rmino (dd/MM/yyyy): ");
		Date finalDate = sdf.parse(sc.next());
		
		Calculator calc = new Calculator(adsName, clientName, initDate, finalDate);	
		
		System.out.print("Investimento por dia: ");
		double investimento = sc.nextDouble();
		calc.calculatorAlcance(investimento);
		
		System.out.println();
		System.out.println("----------------");
		System.out.println();
		System.out.println("Nome do an�ncio: " + adsName);
		System.out.println("Cliente: " + clientName);
		System.out.println("Valor total investido: $" + String.format("%.2f", calc.investimentoTotal())); 
		System.out.println("Quantidade m�xima de visualiza��es: " + calc.getVisualizacao());
		System.out.println("Quantidade m�xima de cliques: "+ calc.getClique());
		System.out.println("Quantidade m�xima de compartilhamentos: " + calc.getCompartilhamento());
		
		sc.close();
		}
		catch(ParseException e) {
			System.out.println("Erro: Data digitada incorretamente.");
		}
		
	}
}