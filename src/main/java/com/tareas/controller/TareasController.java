package com.tareas.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tareas.mapper.TareaMapper;
import com.tareas.model.Tarea;
import com.tareas.service.TareaService;

@Controller
public class TareasController {
	
	private final TareaService service;
	
	public TareasController(TareaService service) {
		this.service = service;
	}
	
	@GetMapping("/tareas")
	public String tarea(Model model) {
		List<Tarea> tareas = service.findAll();
		List<String> fechas = new ArrayList<>();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		for (Tarea tarea : tareas) {
            fechas.add(formatter.format(tarea.getFechainicio()));
        }
		
		
		model.addAttribute("tareas", tareas);
		model.addAttribute("fechas", fechas);
		return "lista-tareas";
	}
}