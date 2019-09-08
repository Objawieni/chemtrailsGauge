package com.orgon.services.impl;

import com.orgon.commands.OrgonCommand;
import com.orgon.entities.Orgon;
import com.orgon.repositories.OrgonRepository;
import com.orgon.services.OrgonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class OrgonServiceImpl implements OrgonService {

    private final OrgonRepository orgonRepository;

    @Override
    public List<Orgon> getOrgonsList() {
        return orgonRepository.findAll();
    }

    @Override
    public Optional<Orgon> getOrgonById(Long id) {
        return orgonRepository.findById(id);
    }

    @Override
    public Optional<Orgon> getOrgonByName(String name) {
        return orgonRepository.findByName(name);
    }

    @Override
    public Orgon addOrgon(Orgon orgon) {
        return orgonRepository.save(orgon);
    }

    @Override
    public Optional<Orgon> removeOrgonById(Long id) {
        Optional<Orgon> orgon = orgonRepository.findById(id);
        orgonRepository.deleteById(id);
        return orgon;
    }

    @Override
    public Optional<Orgon> updateOrgonById(Long id, OrgonCommand orgonCommand) {
        Optional<Orgon> orgon = orgonRepository.findById(id);

        if (orgon.isPresent()) {
            orgonRepository.deleteById(orgon.get().getId());
            Orgon updatedOrgon = orgonRepository.save(new Orgon(
                    orgonCommand.getName(), orgonCommand.getLocation(), orgonCommand.getChemtrailsPercentage()
            ));
            return orgonRepository.findById(updatedOrgon.getId());
        }
        return orgon;
    }
}
