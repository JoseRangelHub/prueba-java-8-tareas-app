package com.tareas.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.tareas.model.Tarea;

@Mapper
public interface TareaMapper {
	
	@Select("SELECT * FROM APP_Tareas")
	List<Tarea> findAll();
	
	@Insert("INSERT INTO APP_Tareas(nombre, descripcion, fechainicio) VALUES (#{nombre}, #{descripcion}, #{fechainicio})")
    int save(Tarea item);
}
