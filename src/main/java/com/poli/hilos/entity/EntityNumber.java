package com.poli.hilos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "ENTITY_NUMBER")
public class EntityNumber {

    @Id
    @Column (name = "ID")
    private int Id;

    @Column (name = "NUMBER_INDEX")
    private int numberIndex;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNumberIndex() {
        return numberIndex;
    }

    public void setNumberIndex(int numberIndex) {
        this.numberIndex = numberIndex;
    }
}
