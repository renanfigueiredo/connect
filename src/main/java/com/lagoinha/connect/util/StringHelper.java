package com.lagoinha.connect.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringHelper {

	public static LocalDate converterParaData(String data) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return LocalDate.parse(data, formatter);
			
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Boolean validarIdade(LocalDate date) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataNascimento = date;
		if(dataNascimento != null) {
			Period diferenca = Period.between(dataNascimento, dataAtual);
			Integer idade = diferenca.getYears();
			if(idade < 8 || idade > 11) {
				return false;
			}
		}
		return true;
	}
	
	public static Boolean validarString(String string) {
		Boolean retorno = true;
		try {
			if(string == null || string.isEmpty() || string.isBlank()) {
				retorno = false;
			}
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
			retorno = false;
			return retorno;
		}
		
	}
	
	public static String listToString(List<String> stringList) {
		return stringList.stream()
			      .map(n -> String.valueOf(n))
			      .collect(Collectors.joining(";"));
	}
	
	public static List<String> stringAsList(String text) {
		String[] texto = text.split(";");
		return Arrays.asList(texto);
	}
	
	public static Boolean validarStringIgual(String s) {
		int n = s.length();
	    for (int i = 1; i < n; i++) {
	    	if (s.charAt(i) != s.charAt(0)) {
	        	return false;
	        }
	    }
	    return true;
	}
	
	public static Boolean validarTelefone(String telefone) {
		try {
			if(telefone.contains("(") || telefone.contains(")") || telefone.contains("-")) {
				telefone = telefone.replace("(", "").replace(")", "").replace("-","");
				telefone = telefone.trim();
				telefone = telefone.replaceAll("\\s+", "");
			}
			Integer qtd = telefone.length();
			if(qtd > 11 || qtd < 10) {
				return false;
			}
			if(validarStringIgual(telefone)) {
				return false;
			}
			Long telNumber = Long.parseLong(telefone);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
}
