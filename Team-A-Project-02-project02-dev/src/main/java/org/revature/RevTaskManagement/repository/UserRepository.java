package org.revature.RevTaskManagement.repository;

import jakarta.transaction.Transactional;
import org.revature.RevTaskManagement.Enums.Role;
import org.revature.RevTaskManagement.Enums.Status;
import org.revature.RevTaskManagement.models.Project;
import org.revature.RevTaskManagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(int id);
    User findByEmail(String email);
    User findByUsernameAndEmail(String username, String email);
    List<User> findByRole(Role role);
    Optional<User> findByUsername(String username);
    List<User> findByStatus(Status status);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = :password WHERE u.userid = :userid")
    int resetPasswordById(@Param("userid") int userid, @Param("password") String password);
}