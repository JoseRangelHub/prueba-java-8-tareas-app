package com.tareas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tareas.mapper.TareaMapper;
import com.tareas.model.Tarea;

@Service
public class TareaServiceImpl implements TareaService {
	
	private final TareaMapper mapper;
	
	public TareaServiceImpl(TareaMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	public List<Tarea> findAll() {
		return mapper.findAll();
	}

	@Override
	public int save(Tarea item) {
		return mapper.save(item);
	}

}
