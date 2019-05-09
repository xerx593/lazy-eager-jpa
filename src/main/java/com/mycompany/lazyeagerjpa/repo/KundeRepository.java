package com.mycompany.lazyeagerjpa.repo;

import com.mycompany.lazyeagerjpa.model.Kunde;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 *
 * @author alutz
 */
public interface KundeRepository extends Repository<Kunde, Long> {

    // standard: lazy, ohne Anschrift
    List<Kunde> findAll();
    
    // custom: join fetch
    @Query("SELECT k FROM Kunde k JOIN FETCH k.post")
    List<Kunde> findCustom();
}
