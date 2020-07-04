package io.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;


//@Repository
public interface DataRepository extends CrudRepository<details, Integer> {
    //List<details> findByTitleContainingOrContentContaining(String text, String textAgain);


}
