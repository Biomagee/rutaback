package com.ruta.app.entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String documento;
    private Integer edad;
    private String ciudadNacimiento;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    List<Image> images;

}
