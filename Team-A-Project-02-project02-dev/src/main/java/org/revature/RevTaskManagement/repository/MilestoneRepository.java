package org.revature.RevTaskManagement.repository;

import org.revature.RevTaskManagement.models.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Integer> {
    Milestone findByMilestoneId(int milestoneId);
}