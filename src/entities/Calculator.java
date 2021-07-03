package entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import Exceptions.CalculatorException;



public class Calculator {
	
	private String adsName;
	private String clientName;
	private Date initDate;
	private Date finalDate;
	private double investimento;
	
	private int visualizacao;
	private int compartilhamento;
	private int clique;
	
	public Calculator () {
		
	}
	


	public Calculator(String adsName, String clientName, Date initDate, Date finalDate) {
		
		if (!finalDate.after(initDate)) {
			throw new CalculatorException ( "A data de término deve ser depois da data de início");
		}
		
		this.adsName = adsName;
		this.clientName = clientName;
		this.initDate = initDate;
		this.finalDate = finalDate;
		
	}

	public String getAdsName() {
		return adsName;
	}

	public void setAdsName(String adsName) {
		this.adsName = adsName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	
	public double getInvestimento() {
		return investimento;
	}

	public void setInvestimento(double investimento) {
		this.investimento = investimento;
	}

	public int getVisualizacao() {
		return visualizacao;
	}

	public void setVisualizacao(int visualizacao) {
		this.visualizacao = visualizacao;
	}

	public int getCompartilhamento() {
		return compartilhamento;
	}

	public void setCompartilhamento(int compartilhamento) {
		this.compartilhamento = compartilhamento;
	}

	public int getClique() {
		return clique;
	}

	public void setClique(int clique) {
		this.clique = clique;
	}

	public long duration() {
		long diff = finalDate.getTime() - initDate.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); 
	}
	
	public void calculatorAlcance(double investimento ){
		
		this.investimento = investimento;
		
		clique = 0;
		compartilhamento = 0;
		
		visualizacao = (int) (30 * investimento);
		
		clique = visualizacao / ( 100 / 12 ) ;
		
		compartilhamento = clique / (20 / 3 );
		
		
		if (compartilhamento >= 1) {
			int compVisu = compartilhamento * 40 ;
			visualizacao += compVisu;
			
			int compVisu02 = compVisu;
			
			while(compVisu02 >= 40) {
				int click02 = compVisu02 / ( 100 / 12 ) ;
				clique += click02;
				
				int comp02 = click02 / (20 / 3 );
				compartilhamento += comp02;
				
				if (comp02 >= 1) {
					compVisu02 = comp02 * 40 ;
					visualizacao += compVisu02;
				}else {
					compVisu02 = 0;
				}
			}
		}
		
		visualizacao = (int) (visualizacao * duration());
		clique = (int) (clique * duration());
		compartilhamento = (int) (compartilhamento * duration());
		
	}
	
	public double investimentoTotal() {
		return investimento = (double) investimento * duration();
	}
	
	
}