package com.alura.foroalura.Entities;

import java.sql.Date;
import java.time.LocalDateTime;

public record DtoRespuestaTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String autor,
        StatusTopico status,
        String curso
) {

    public DtoRespuestaTopico(Topico topico) {
     this(topico.getTitulo(), topico.getMensaje(),
             topico.getFechaCreacion(), topico.getAutor(),
             topico.getEstatus(), topico.getCurso());
    }
}
