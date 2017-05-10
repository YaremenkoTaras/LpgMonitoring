package com.yaremenko.lpgmonitoring.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author Taras
 * @since 20.04.2017
 */
@Entity
@Data
@EqualsAndHashCode(exclude = "id")
public class User implements Serializable{

    @Id
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String password;
    @ManyToOne
    private Company company;

}
