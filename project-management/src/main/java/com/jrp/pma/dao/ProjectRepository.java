package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jrp.pma.entities.Project;

@RepositoryRestResource(collectionResourceRel="apiprojects", path="apiprojects")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
	
	@Override
	public List<Project> findAll();

	public Project findByProjectId(long theId);
}
