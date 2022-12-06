package com.br.testepraticoiniflex;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class Pessoa implements Comparable <Pessoa>{private String nome;
private Date dataNascimento;


public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Date getDataNascimento() {
	return dataNascimento;
}
public void setDataNascimento(Date dataNascimento) {
	this.dataNascimento = dataNascimento;
}

@Override
public   void  setdataNascimento (Date dataNascimento )  {
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
Date dataNascimento = formato.parse("dd/MM/yyyy");

System.out.println(formato.format(dataNascimento));

}

@Override
public int compareTo(Pessoa o) {
	// TODO Auto-generated method stub
	return this.nome.compareTo(o.getNome());
}


}
