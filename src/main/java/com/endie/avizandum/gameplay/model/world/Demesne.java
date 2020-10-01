package com.endie.avizandum.gameplay.model.world;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "demesnes")
public class Demesne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
