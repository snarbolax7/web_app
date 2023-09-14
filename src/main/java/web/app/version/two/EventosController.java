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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@Controller
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
    public String getAllAsistencias(Model model) {
        model.addAttribute("asistencias", asistenciaDao.findAll());
        return "asistencias";
    }

    @PostMapping(value = "/asistencias")
    public String saveAsistencia(@ModelAttribute("asistencia") Asistencia asistencia) {
        asistenciaDao.save(asistencia);
        return "redirect:asistencias";
    }
    
    @GetMapping(value = "/asistencias/editar/{idAsistencia}")
    public String formulaioEditarAsistencia(@PathVariable Integer idAsistencia, Model model){
        Asistencia asistencia = asistenciaDao.findById(idAsistencia).get();
        model.addAttribute("asistencia", asistencia);
        return "editar_asistencia";
    }
    @GetMapping(value = "asistencias/eliminar/{idAsistencia}")
    public String formularioEliminarAsistencia(@PathVariable Integer idAsistencia, Model model){
        asistenciaDao.deleteById(idAsistencia);
        return "redirect:asistencias";
    }
    @PostMapping("/asistencias/{idAsistencia}")
    public String updateAsistencia(@PathVariable Integer idAsistencia, @ModelAttribute("asistencia") Asistencia asistencia, Model model){
        Asistencia asistenciaExistente = asistenciaDao.findById(idAsistencia).get();
        asistenciaExistente.setAsistira(asistencia.getAsistira());
        asistenciaExistente.setCiudad(asistencia.getCiudad());
        asistenciaExistente.setEstado(asistencia.getEstado());
        asistenciaExistente.setEvento(asistencia.getEvento());
        asistenciaExistente.setIdAsistencia(asistencia.getIdAsistencia());
        asistenciaExistente.setPersona(asistencia.getPersona());
        asistenciaDao.save(asistenciaExistente);
        return "redirect:asistencias";
    }
    
    @GetMapping(value = "/asistencias/asistencia_nueva")
    public String formularioCrearAsistencia(Model model) {
        Asistencia asistencia = new Asistencia();
        model.addAttribute("asistencia", asistencia);
        return "crear_asistencia";
    }
    

    @GetMapping(value = "/ciudades")
    public String getAllCiudades(Model model) {
        model.addAttribute("ciudades", ciudadDao.findAll());
        return "ciudades";
    }
    @PostMapping(value = "/ciudades")
    public String saveCiudad(@ModelAttribute("ciudad") Ciudad ciudad) {
        ciudadDao.save(ciudad);
        return "redirect:/ciudades";
    }
    
    @GetMapping(value="ciudades/editar/{idCiudad}")
    public String formularioEditarCiudad(@PathVariable Integer idCiudad, Model model){
        Ciudad ciudad = ciudadDao.findById(idCiudad).get();
        model.addAttribute("ciudad", ciudad);
        return "editar_ciudad";
    }
    @GetMapping(value="ciudades/eliminar/{idCiudad}")
    public String formularioEliminarCiudad(@PathVariable Integer idCiudad, Model model){
        ciudadDao.deleteById(idCiudad);
        return "redirect:/ciudades";
    }

    @PostMapping(value = "/ciudades/{idCiudad}")
    public String updateCiudad(@PathVariable Integer idCiudad, @ModelAttribute("ciudad") Ciudad ciudad, Model model) {
        Ciudad ciudadExistente = ciudadDao.findById(idCiudad).get();
        ciudadExistente.setDescripcion(ciudad.getDescripcion());
        ciudadDao.save(ciudadExistente);
        return "redirect:/ciudades";
    }
    
    @GetMapping(value = "/ciudades/ciudad_nueva")
    public String formularioCrearCiudad(Model model) {
        Ciudad ciudad = new Ciudad();
        model.addAttribute("ciudad", ciudad);
        return "crear_ciudad";
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
