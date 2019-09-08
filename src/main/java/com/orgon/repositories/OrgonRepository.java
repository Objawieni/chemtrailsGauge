package com.orgon.repositories;

import com.orgon.entities.Orgon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrgonRepository extends JpaRepository<Orgon, Long> {

    Optional<Orgon> findByName(String name);

    Optional<Orgon> deleteByName(String name);
}
