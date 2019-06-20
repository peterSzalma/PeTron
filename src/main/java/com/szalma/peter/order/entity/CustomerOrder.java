package com.szalma.peter.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue
    private Long id;

    @Transient
    private List<String> colors;

    private Type type;

    private Integer quantity;

    private Date date;

}
