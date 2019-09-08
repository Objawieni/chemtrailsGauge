package com.orgon.repositories;

import com.orgon.entities.Orgon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgonRepository extends JpaRepository<Orgon, Long> {
}
