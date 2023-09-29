package com.alura.foroalura.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alura.foroalura.Entities.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
