package com.alura.foroalura.Controller;

import com.alura.foroalura.Entities.DtoModificarTopico;
import com.alura.foroalura.Entities.DtoRegistroTopico;
import com.alura.foroalura.Entities.DtoRespuestaTopico;
import com.alura.foroalura.Entities.Topico;
import com.alura.foroalura.Repository.TopicoRepository;

import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "foro/topico")
public class TopicoController {

    private final TopicoRepository repository;

    public TopicoController(TopicoRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Topico> registroTopico(@RequestBody @Valid DtoRegistroTopico registro){
        try{
            return ResponseEntity.ok(repository.save(new Topico(registro)));
        }catch (DataIntegrityViolationException ex){
            return ResponseEntity.badRequest().header("Error", "Error al registrar el topico").build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<DtoRespuestaTopico>> listarTopicos() {
        return ResponseEntity.ok(repository.findAll()
                .stream()
                .map(DtoRespuestaTopico::new)
                .toList());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DtoRespuestaTopico> buscarTopico(@PathVariable Long id){
        Topico  topico = repository.findById(id).orElse(null);
        if(topico == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new DtoRespuestaTopico(topico));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DtoModificarTopico registro){
        Topico topico = repository.findById(id).orElse(null);
        if(topico == null)
            return ResponseEntity.notFound().build();

        try{
            topico.actualizar(registro);
            return ResponseEntity.ok(repository.save(topico));
        }
        catch(DataIntegrityViolationException ex){
            return ResponseEntity.badRequest().header("Error", "Error al actualizar el topico").build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> eliminarTopico(@PathVariable Long id){
        Topico topico = repository.findById(id).orElse(null);
        if(topico == null)
            return ResponseEntity.notFound().build();

        repository.delete(topico);
        return ResponseEntity.ok().build();
    }
}
