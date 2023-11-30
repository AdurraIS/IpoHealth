package br.com.ipohealth.appgs.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_feedback")
    private Long id;

    private String comment_feedback;

    private Date dt_feedback;
}
