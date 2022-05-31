package com.ruta.app.dto;

import com.ruta.app.entity.Image;
import com.ruta.app.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDTO implements Serializable {

    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String documento;
    private Integer edad;
    private String ciudadNacimiento;
    List<Image> images;
    private String img;
    private User user;


}
