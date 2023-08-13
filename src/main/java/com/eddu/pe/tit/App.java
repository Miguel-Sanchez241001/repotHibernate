package com.eddu.pe.tit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.eddu.pe.tit.dao.ReunionDao;
import com.eddu.pe.tit.dao.SalaDao;
import com.eddu.pe.tit.dominio.Reunion;
import com.eddu.pe.tit.dominio.Sala;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ReunionDao dao = new ReunionDao();
		List<Reunion> reu = dao.getAll();

		for (Reunion reunion : reu) {
			System.out.println("**" + reunion);
		}

		Reunion reunion = new Reunion(LocalDateTime.now() , "aprendiendo etos");
		Reunion reunion3 = new Reunion(LocalDateTime.now().plus(1, ChronoUnit.DAYS), "Reunion del 1 de agostos");
		System.out.println(reunion3);
		dao.save(reunion3);
		//System.out.println(reunion);
		System.out.println("Proxima reunion " + dao.proximaReunion());
		System.out.println("reuniones de manana " + dao.reunionesdiaSiguente());
		  
		SalaDao saladao = new SalaDao();
		Sala s = new Sala("S002","Primera sala",20 );
		saladao.save(s);
		System.out.println("Paso 1: " + saladao.getAll());		
		s.setDescripcion(" primera modificacion de sala 1");
		saladao.update(s);
		System.out.println("paso 2: "+ saladao.getAll());
		Sala s2 = new Sala("S003","	Primera sala",1 );
		saladao.save(s2);

		System.out.println("paso 3: "+ saladao.getAll());
		saladao.delete(s2);
		System.out.println("paso 4: "+ saladao.getAll());

		
		
		 
	}
}
