package com.turkcell.crm.catalog.entity;

import com.turkcell.crm.catalog.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="catalog")
public class Catalog extends BaseEntity /*extends BaseEntity*/{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @NotNull(message = "Name can not be null!")
    protected int speed;

    @NotNull(message = "Name can not be null!")
    protected BigDecimal price;

    @NotNull(message = "Name can not be null!")
    protected String currency;

    @NotNull(message = "Name can not be null!")
    protected String unit;

}
