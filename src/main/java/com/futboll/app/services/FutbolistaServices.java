package com.futboll.app.services;

import com.futboll.app.entity.Futbolista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FutbolistaServices {

    List<Futbolista> Futbolistas();

    Page<Futbolista> paginableFutbolistas(Pageable pageable);
    Futbolista buscarPorId(Long id);
}
