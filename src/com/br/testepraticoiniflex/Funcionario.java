package com.br.testepraticoiniflex;

import java.math.BigDecimal;


public class Funcionario extends Pessoa {

	private BigDecimal salario;
	private String funcao;
	
	
	
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	@Override
	public String toString() {
		return "Nome: " + getNome()
				+" | Data de Nascimento: " + getDataNascimento()
				+" | Salario: " + salario
				+" | Função: "+ funcao;
	}
	
	
}
