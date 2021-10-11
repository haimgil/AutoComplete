package com.bl.autocomplete.persistence;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "names")
@EntityListeners(AuditingEntityListener.class)
public class Boy {

    private String name;

    public Boy() {}

    public Boy(String name){
        this.name = name;
    }

    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
