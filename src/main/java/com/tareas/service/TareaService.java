package com.tareas.service;

import java.util.List;

import com.tareas.model.Tarea;

public interface TareaService {
	
	List<Tarea> findAll();
	
	int save(Tarea item);
}
