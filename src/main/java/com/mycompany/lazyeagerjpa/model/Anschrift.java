package com.mycompany.lazyeagerjpa.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author alutz
 */
@Data
@Entity
public class Anschrift implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String strasse;

    @NotNull
    private String hausnummer;

    @NotNull
    private String plz;
   
}
