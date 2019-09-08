package com.orgon.services;

import com.orgon.commands.OrgonCommand;
import com.orgon.entities.Orgon;

import java.util.List;
import java.util.Optional;

public interface OrgonService {

    List<Orgon> getOrgonsList();

    Optional<Orgon> getOrgonById(Long id);

    Orgon addOrgon(Orgon orgon);

    Optional<Orgon> removeOrgonById(Long id);

    Optional<Orgon> updateOrgonById(Long id, OrgonCommand orgonCommand);
}
