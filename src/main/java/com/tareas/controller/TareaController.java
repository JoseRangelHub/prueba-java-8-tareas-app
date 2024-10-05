package com.tareas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tareas.model.Tarea;
import com.tareas.service.TareaService;

@Controller
public class TareaController {
	

	private final TareaService service;
	
	public TareaController(TareaService service) {
		this.service = service;
	}
	
	@GetMapping("/tarea")
	public String mostrarFormulario(Model model) {
		Formulario formulario = new Formulario();
	    formulario.setTarea(new Tarea());
	    formulario.setFechainicio(new String());
	    model.addAttribute("formulario", formulario);
	    return "tarea";
	}
	
	@PostMapping("/tareas/new")
	public String saveTask(@ModelAttribute Formulario formulario) {
		Tarea tarea = new Tarea();
		tarea.setId(formulario.getTarea().getId());
		tarea.setNombre(formulario.getTarea().getNombre());
		tarea.setDescripcion(formulario.getTarea().getDescripcion());
		
		 SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			Date fecha = formato.parse(formulario.getFechainicio());
			tarea.setFechainicio(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		service.save(tarea); 
		
		return "redirect:/tarea";
	}
	
	public class Formulario {
	    private Tarea tarea;
	    private String fechainicio;
	    
	    public Formulario() {
	    	
	    }
		public Tarea getTarea() {
			return tarea;
		}
		public void setTarea(Tarea tarea) {
			this.tarea = tarea;
		}
		public String getFechainicio() {
			return fechainicio;
		}
		public void setFechainicio(String fechainicio) {
			this.fechainicio = fechainicio;
		}

	    // Getters y setters
	}
}
