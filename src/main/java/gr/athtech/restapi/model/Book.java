package gr.athtech.restapi.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String title;
    private double price;

    @ManyToOne
    private Author author;

}
