package com.futboll.app.controller;

import com.futboll.app.entity.Futbolista;
import com.futboll.app.services.FutbolistaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/futbolista")
public class FutbolistaController {

    @Autowired
    private FutbolistaServices futbolistaServices;

    @GetMapping
    public List<Futbolista> futbolistas(){
        return futbolistaServices.Futbolistas();
    }

    @GetMapping("page")
    public Page<Futbolista> pageable(@PageableDefault(sort = "idFutbolista",direction = Sort.Direction.ASC, size = 5) Pageable pageable){
        Page<Futbolista> futbolistasPaginados=futbolistaServices.paginableFutbolistas(pageable);
        return futbolistasPaginados;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Futbolista> buscarPorId(@PathVariable Long id){
        Optional<Futbolista> futbolistaOptional =Optional.of(futbolistaServices.buscarPorId(id));
        return futbolistaOptional
                .map(futbolista -> ResponseEntity.ok(futbolista))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
