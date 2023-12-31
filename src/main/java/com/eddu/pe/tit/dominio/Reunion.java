package com.eddu.pe.tit.dominio;


import java.time.LocalDateTime;

// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reu")
public class Reunion {
	
// @Column(name = "id")
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
// @Column(name = "fecha")
 private LocalDateTime fecha;
 
// @Column(name = "asunto")
 private String asunto;

 
 @ManyToOne(fetch = FetchType.LAZY)
 private Sala sala;
 
 
 
 
 
 
 
public Sala getSala() {
	return sala;
}

public void setSala(Sala sala) {
	this.sala = sala;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Reunion() {}


public Reunion(LocalDateTime fecha, String asunto) {
	
	this.fecha = fecha;
	this.asunto = asunto;
}

@Override
public String toString() {
	return "Reunion [id=" + id + ", fecha=" + fecha + ", asunto=" + asunto + "]";
}

public LocalDateTime getFecha() {
	return fecha;
}

public void setFecha(LocalDateTime fecha) {
	this.fecha = fecha;
}

public String getAsunto() {
	return asunto;
}

public void setAsunto(String asunto) {
	this.asunto = asunto;
}
 
 
}
