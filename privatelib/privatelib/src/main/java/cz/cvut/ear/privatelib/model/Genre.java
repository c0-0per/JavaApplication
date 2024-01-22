package cz.cvut.ear.privatelib.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

@Getter
@Setter
@Entity
public class Genre {

    @Id
    @GeneratedValue
    private Integer id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String nameOfGenre;



}
