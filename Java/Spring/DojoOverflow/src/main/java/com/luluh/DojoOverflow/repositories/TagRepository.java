package com.luluh.DojoOverflow.repositories;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luluh.DojoOverflow.models.Tag;


@Repository
public interface TagRepository  extends CrudRepository<Tag, Long>{
	Tag findBySubjectEquals(String subject);

}