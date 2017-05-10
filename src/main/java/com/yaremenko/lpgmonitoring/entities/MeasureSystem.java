package com.yaremenko.lpgmonitoring.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author Taras
 * @since 21.04.2017
 */
@Entity
@Data
@EqualsAndHashCode(exclude = "id")
public class MeasureSystem implements Serializable {

    @Id
    private Integer id;
    private String serialnumber;
    private String description;
    private String placement;
    private Date inspection;
    @ManyToOne
    private Company company;

}
