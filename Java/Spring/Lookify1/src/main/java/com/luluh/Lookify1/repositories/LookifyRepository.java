package com.luluh.Lookify1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luluh.Lookify1.models.Lookify;


@Repository
public interface LookifyRepository  extends CrudRepository<Lookify, Long>{
    List<Lookify> findAll();

}