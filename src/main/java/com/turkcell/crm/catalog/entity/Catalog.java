package com.turkcell.crm.catalog.entity;

import com.turkcell.crm.catalog.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="catalog")
@EqualsAndHashCode(callSuper = true)
public class Catalog extends BaseEntity {

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @NotNull(message = "Name can not be null!")
    protected BigDecimal price;

}
