package com.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.model.Contato;

@Repository
public interface Contatos extends JpaRepository<Contato, Long> {

}
