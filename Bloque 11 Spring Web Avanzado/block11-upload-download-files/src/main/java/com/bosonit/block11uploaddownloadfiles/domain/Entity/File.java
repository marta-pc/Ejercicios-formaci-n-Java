package com.bosonit.block11uploaddownloadfiles.domain.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@ToString
public class File {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private LocalDate uploadDate;
}
