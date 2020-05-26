package com.jrp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<Project> getAll(){
		return proRepo.findAll();
	}

	public Iterable<Project> getAllById(List<Long> theProject) {
		return proRepo.findAll();
	}

	public Project findByProjectId(long theId) {
		// TODO Auto-generated method stub
		return proRepo.findByProjectId(theId);
	}

	public void delete(Project theProj) {
		// TODO Auto-generated method stub
		proRepo.delete(theProj);
	}
}
