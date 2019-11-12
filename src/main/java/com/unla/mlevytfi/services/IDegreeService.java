package com.unla.mlevytfi.services;
import java.util.List;

import com.unla.mlevytfi.entities.Degree;
import com.unla.mlevytfi.models.DegreeModel;


public interface IDegreeService {

	public List<Degree> getAll();
	
	public DegreeModel insertOrUpdate(DegreeModel degreeModel);
	
	public boolean remove(int id);
}

