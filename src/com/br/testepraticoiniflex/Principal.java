package com.br.testepraticoiniflex;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Principal {

	public static void main (String []args){
		//instanciando funcionarios conforme tabela
		Funcionario funcionario1 = new Funcionario();
		funcionario1.setNome("Maria");
		funcionario1.setDataNascimento(Date(2000,10,18));
		funcionario1.setSalario(BigDecimal.valueOf(2009.44));
		funcionario1.setFuncao("Operador");
		//joao
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("João");
		funcionario2.setDataNascimento(Date.of(1990,05,12));
		funcionario2.setSalario(BigDecimal.valueOf(2284.38));
		funcionario2.setFuncao("Operador");
		//caio
		Funcionario funcionario3 = new Funcionario();
		funcionario3.setNome("Caio");
		funcionario3.setDataNascimento(Date.of(1961,05,02));
		funcionario3.setSalario(BigDecimal.valueOf(9836.14));
		funcionario3.setFuncao("Coordenador");
		//Miguel
		Funcionario funcionario4 = new Funcionario();
		funcionario4.setNome("Miguel");
		funcionario4.setDataNascimento(Date.of(1988,10,14));
		funcionario4.setSalario(BigDecimal.valueOf(19119.14));
		funcionario4.setFuncao("Diretor");
		//alice
		Funcionario funcionario5 = new Funcionario();
		funcionario5.setNome("Alice");
		funcionario5.setDataNascimento(Date.of(1995,01,05));
		funcionario5.setSalario(BigDecimal.valueOf(2234.68));
		funcionario5.setFuncao("Recepcionista");
		//heitor
		Funcionario funcionario6 = new Funcionario();
		funcionario6.setNome("Heitor");
		funcionario6.setDataNascimento(Date.of(1999,11,19));
		funcionario6.setSalario(BigDecimal.valueOf(1582.72));
		funcionario6.setFuncao("Operador");
		//arthur
		Funcionario funcionario7 = new Funcionario();
		funcionario7.setNome("Arthur");
		funcionario7.setDataNascimento(Date.of(1993,03,31));
		funcionario7.setSalario(BigDecimal.valueOf(4071.84));
		funcionario7.setFuncao("Contador");
		//Laura
		Funcionario funcionario8 = new Funcionario();
		funcionario8.setNome("Laura");
		funcionario8.setDataNascimento(Date.of(1994,07,8));
		funcionario8.setSalario(BigDecimal.valueOf(3017.45));
		funcionario8.setFuncao("Gerente");
		//Heloisa
		Funcionario funcionario9 = new Funcionario();
		funcionario9.setNome("Heloisa");
		funcionario9.setDataNascimento(Date.of(2003,05,24));
		funcionario9.setSalario(BigDecimal.valueOf(1606.85));
		funcionario9.setFuncao("Eletricista");
		//Helena
		Funcionario funcionario10 = new Funcionario();
		funcionario10.setNome("Helena");
		funcionario10.setDataNascimento(Date.of(1996,9,2));
		funcionario10.setSalario(BigDecimal.valueOf(2799.93));
		funcionario10.setFuncao("Gerente");
		
		ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		listaFuncionarios.add(funcionario1);
		listaFuncionarios.add(funcionario2);
		listaFuncionarios.add(funcionario3);
		listaFuncionarios.add(funcionario4);
		listaFuncionarios.add(funcionario5);
		listaFuncionarios.add(funcionario6);
		listaFuncionarios.add(funcionario7);
		listaFuncionarios.add(funcionario8);
		listaFuncionarios.add(funcionario9);
		listaFuncionarios.add(funcionario10);

		//removendo funcionario joao
		listaFuncionarios.remove(funcionario2);
		
		
		
		//imprimindo todos os funcionarios com todas informações
		System.out.println("====LISTA DE FUNCIONARIOS====");
		for(Funcionario i: listaFuncionarios) {
			System.out.println(i);
			//não consegui exibir a data no formato dd/MM/aaaa
			//Date ld = Date.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			// DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			//não consegui exibir salario no formato 1.000,00
		}
		//Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
		System.out.println("\n====ATUALIZANDO LISTA 10% DE AUMENTO NO SALARIO====\n");
		for(int i=0; i < listaFuncionarios.size(); i++) {
			listaFuncionarios.get(i).setSalario((listaFuncionarios.get(i).getSalario().multiply(new BigDecimal(1.10).setScale(2, RoundingMode.HALF_EVEN))));  
		}
		
		System.out.println("\n3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a função e o valor a lista de funcionários”\n");
		//criando o map
	
			 
		Map<String, List<Funcionario>> mapa = new HashMap<String, List<Funcionario>>();
		
		//iterando sobre a lista de funcionarios e verificando as funções
		for(Funcionario f: listaFuncionarios) {
			String funcao = f.getFuncao();
			if(!mapa.containsKey(funcao)) {//caso ainda nao exista criar nova arraylist por funcao
				mapa.put(funcao,new ArrayList<Funcionario>());
			}
			mapa.get(funcao).add(f);//pegando a função e adicionando o funcionario
		}
	 	 
		 
		//exibindo funcionarios por setor ex "Operador"
		System.out.println("\n3.6 – Imprimir os funcionários, agrupados por função.");
		System.out.println(mapa.get("Operador"));
		
		System.out.println("\n3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.");
		for(Funcionario d: listaFuncionarios) {
			if(d.getDataNascimento().getMonthValue() == 10 || d.getDataNascimento().getMonthValue() == 12) {
				System.out.println(d);
			}	
		}
		System.out.println("\n3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.");
		int menor = 2022;
		String nome = "";
		int idade = 0;
		Funcionario maisVelho = new Funcionario();
		for(Funcionario d: listaFuncionarios) {
			if( d.getDataNascimento().getYear() < menor) {
				nome = d.getNome();
				idade = 2022 - d.getDataNascimento().getYear();
				maisVelho.setNome(d.getNome());
				menor = d.getDataNascimento().getYear();
			}
		}
		System.out.println("Nome: "+ nome);
		System.out.println("Idade: "+ idade);
		System.out.println();
		
		
		
		System.out.println("\n3.10 – Imprimir a lista de funcionários por ordem alfabética.");
		
		Collections.sort(listaFuncionarios);
		for(Funcionario i: listaFuncionarios) {
			System.out.println(i);
		}
		
		System.out.println("\n3.11 – Imprimir o total dos salários dos funcionários.");
		BigDecimal totalSalarios = new BigDecimal(0.0);
		for(int i=0; i < listaFuncionarios.size(); i++) {
			totalSalarios = totalSalarios.add(listaFuncionarios.get(i).getSalario());
		}
		
		System.out.println("Total: R$ "+totalSalarios);
		
		System.out.println("\n3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.");
		BigDecimal salarioMin = new BigDecimal(1212.00);		
		for(int i=0; i < listaFuncionarios.size(); i++) {
						//pega o salario e divide e mostra na tela
			System.out.println(listaFuncionarios.get(i).getNome() + " recebe " +
					listaFuncionarios.get(i).getSalario().divide(salarioMin, new MathContext(2, RoundingMode.HALF_EVEN))
					+ " salarios minimos.");
		}
	}
}
		
	







