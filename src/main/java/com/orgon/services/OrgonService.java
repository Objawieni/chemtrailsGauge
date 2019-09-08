package com.orgon.services;

import com.orgon.commands.OrgonCommand;
import com.orgon.entities.Orgon;

import java.util.List;
import java.util.Optional;

public interface OrgonService {

    List<Orgon> getOrgonsList();

    Optional<Orgon> getOrgonById(Long id);

    Optional<Orgon> getOrgonByName(String name);

    Orgon addOrgon(Orgon orgon);

    Optional<Orgon> removeOrgonById(Long id);

    Optional<Orgon> removeOrgonByName(String name);

    Optional<Orgon> updateOrgonById(Long id, OrgonCommand orgonCommand);

    Optional<Orgon> updateOrgonByName(OrgonCommand orgonCommand);
}
