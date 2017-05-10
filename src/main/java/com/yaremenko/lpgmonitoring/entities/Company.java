package com.yaremenko.lpgmonitoring.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Taras
 * @since 20.04.2017
 */
@Entity
@Data
@EqualsAndHashCode(exclude = "id")
public class Company implements Serializable{

    @Id
    private Integer id;
    private String name;
    private String info;
    private String tax;


}
