package org.revature.RevTaskManagement.repository;

import org.revature.RevTaskManagement.models.Project;
import org.revature.RevTaskManagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query("SELECT p FROM Project p WHERE p.projectManager.username = :username")
    List<Project> findProjectsByUsername(@Param("username") String username);

    Project findByProjectName(String projectName);

    Project findByProjectId(int projectId);

    @Query("SELECT p FROM Project p WHERE p.projectManager.username = :managerName")
    List<Project> findProjectsByProjectManagerName(@Param("managerName") String managerName);

    @Query("SELECT p.projectManager FROM Project p JOIN p.teamMembers tm WHERE tm.username = :username")
    User findProjectManagerByTeamMemberUsername(@Param("username") String username);

    @Query("SELECT p FROM Project p JOIN p.teamMembers u WHERE u.username = :username")
    List<Project> findProjectsByUsernameget(@Param("username") String username);

    @Query("SELECT DISTINCT p.projectManager FROM Project p JOIN p.teamMembers tm WHERE tm.username = :username")
    List<User> findAllProjectManagersByTeamMemberUsername(@Param("username") String username);

}
