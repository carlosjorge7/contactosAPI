package com.contactosApi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contactosApi.model.Contacto;

public interface ContactoDAO extends JpaRepository<Contacto, Integer> {

}
