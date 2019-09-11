package com.accenture.rentacar.app.util;

import java.time.format.DateTimeParseException;
import java.util.Date;

public class utilDate {
	
	
	
	public static int calcularDias(Date fechaInicio, Date fechaFinal) {
		
		try{
		
	    long diferencia = fechaFinal.getTime() -fechaInicio.getTime(); 
		Long d = (diferencia/(1000*60*60*24));
		
		int dias= d.intValue(); 
		return dias; 
		
		}catch(DateTimeParseException e  ) {
			System.err.println(e);
			throw e; 
		}catch(Exception e  ) {
			System.err.println(e);
			throw e; 
		}
		
		finally {
			
		}
		
		
		
		
		
	}

}
