package com.bskyb.db.entity.two;

import javax.persistence.*;

@MappedSuperclass
public abstract class Identity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
