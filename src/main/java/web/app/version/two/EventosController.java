/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.app.version.two;

import javax.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import web.app.version.two.dao.AsistenciaDao;
import web.app.version.two.dao.CiudadDao;
import web.app.version.two.dao.EventoDao;
import web.app.version.two.dao.PersonaDao;
import web.app.version.two.dto.Asistencia;
import web.app.version.two.dto.Ciudad;
import web.app.version.two.dto.Evento;
import web.app.version.two.dto.Persona;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
public class EventosController {

    @Autowired
    private AsistenciaDao asistenciaDao;
    @Autowired
    private CiudadDao ciudadDao;
    @Autowired
    private EventoDao eventoDao;
    @Autowired
    private PersonaDao personaDao;

    @GetMapping(value = "/asistencias")
    public ResponseEntity getAllAsistencias() {
        return new ResponseEntity(asistenciaDao.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/asistencia")
    public ResponseEntity saveAsistencia(@RequestBody Asistencia asistencia) {
        return new ResponseEntity(asistenciaDao.save(asistencia), HttpStatus.CREATED);
    }

    @GetMapping(value = "/ciudades")
    public ResponseEntity getAllCiudades() {
        return new ResponseEntity(ciudadDao.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/ciudad")
    public ResponseEntity saveCiudad(@RequestBody Ciudad ciudad) {
        return new ResponseEntity(ciudadDao.save(ciudad), HttpStatus.CREATED);
    }

    @GetMapping(value = "/ciudad/{id_ciudad}")
    public ResponseEntity getCiudadById(@PathVariable("id_ciudad") Integer id) {
        return new ResponseEntity(ciudadDao.findById(id), HttpStatus.CREATED);
    }

    @GetMapping(value = "eventos")
    public ResponseEntity getAllEventos() {
        return new ResponseEntity(eventoDao.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "evento")
    public ResponseEntity saveEvento(@RequestBody Evento evento) {
        return new ResponseEntity(eventoDao.save(evento), HttpStatus.CREATED);
    }

    @GetMapping(value = "evento/{id_evento}")
    public ResponseEntity getEventoById(@PathVariable("id_evento") Integer id) {
        return new ResponseEntity(eventoDao.findById(id), HttpStatus.CREATED);
    }

    @GetMapping(value = "/personas")
    public ResponseEntity getAllPersonas() {
        return new ResponseEntity(personaDao.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "persona")
    public ResponseEntity Persona(@RequestBody Persona persona) {
        return new ResponseEntity(personaDao.save(persona), HttpStatus.CREATED);
    }

    @GetMapping(value = "persona")
    public ResponseEntity savePersona(@PathVariable("id_persona") Integer id) {
        return new ResponseEntity(personaDao.findById(id), HttpStatus.CREATED);
    }
}
