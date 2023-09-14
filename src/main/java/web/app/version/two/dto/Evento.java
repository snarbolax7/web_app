/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.app.version.two.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "evento")
public class Evento implements Serializable {
    @Id
    @Column(name = "idevento")
    private Integer idEvento;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fechaevento")
    private String fechaEvento;
    @Column(name = "horaevento")
    private String horaEvento;
    @Column(name="estadoevento")
    private String estadoEvento;
}