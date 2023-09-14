/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.app.version.two.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "asistencia")
public class Asistencia implements Serializable {

    @Id
    @Column(name = "idasistencia")
    private Integer idAsistencia;
    @OneToOne
    @JoinColumn(name = "idevento")
    private Evento evento;
    @OneToOne
    @JoinColumn(name = "idpersona")
    private Persona persona;
    @OneToOne
    @JoinColumn(name = "idciudad")
    private Ciudad ciudad;
    @Column(name = "asistira")
    private Boolean asistira;
    @Column(name = "estado")
    private String estado;

}
