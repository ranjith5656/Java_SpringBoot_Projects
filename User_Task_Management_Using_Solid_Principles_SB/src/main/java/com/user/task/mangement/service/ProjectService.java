package com.user.task.mangement.service;

import java.util.List;

import com.user.task.mangement.entity.Project;

public interface ProjectService {
	/**
	 * creates a new project 
	 * 
	 * @param project  The project object to request the project.
	 * @return project object is saved
	 */
	public Project createProject(Project project);
	
	/**
	 * update the existing project.
	 * @param projectId the projectId from existing project 
	 * @param project the project object
	 * @return project object is updated and saved in exist
	 */
	public Project updateProject(Long projectId, Project project);
	
	/**
	 * Retrieves  the projectId
	 * @param projectId 
	 * @return 
	 */
	public Project getProjectId(Long projectId);
	
	public List<Project> getAllProjects();
	
	public void deleteProject(Long projectId);

}
