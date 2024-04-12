package com.futboll.app.services;

import com.futboll.app.entity.Futbolista;
import com.futboll.app.repository.FutbolistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FutbolistaImpl implements FutbolistaServices{

    @Autowired
    private FutbolistaRepository futbolistaRepository;

    @Override
    public List<Futbolista> Futbolistas() {
        return futbolistaRepository.findAll();
    }

    @Override
    public Page<Futbolista> paginableFutbolistas(Pageable pageable) {
        return futbolistaRepository.findAll(pageable);
    }

    @Override
    public Futbolista buscarPorId(Long id) {
        return futbolistaRepository.findById(id).get();
    }
}
