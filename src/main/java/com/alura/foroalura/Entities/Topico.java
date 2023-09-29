package com.alura.foroalura.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusTopico estatus = StatusTopico.NO_RESPONDIDO;
    private String autor;
    private String curso;


    public Topico(DtoRegistroTopico registro) {
        this.titulo = registro.titulo();
        this.mensaje = registro.mensaje();
        this.autor = registro.autor();
        this.curso = registro.curso();
    }

    public void actualizar(DtoModificarTopico registro) {
        if(registro.autor() != null){
            this.autor = registro.autor();
        }
        if(registro.curso() != null){
            this.curso = registro.curso();
        }
        if(registro.mensaje() != null){
            this.mensaje = registro.mensaje();
        }
        if(registro.titulo() != null){
            this.titulo = registro.titulo();
        }
        
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getEstatus() {
		return estatus;
	}

	public void setEstatus(StatusTopico estatus) {
		this.estatus = estatus;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}
