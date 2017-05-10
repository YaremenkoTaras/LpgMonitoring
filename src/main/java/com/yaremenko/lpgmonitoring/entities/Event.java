package com.yaremenko.lpgmonitoring.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Taras
 * @since 20.04.2017
 */
@Entity
@Data
@EqualsAndHashCode(exclude = "id")
public class Event implements Serializable {

    @Id
    private Integer id;
    private LocalDateTime date;
    private String type;
    private String value;
    private String temperature;
    private String location;
    @ManyToOne
    private MeasureSystem measureSystem;

}
