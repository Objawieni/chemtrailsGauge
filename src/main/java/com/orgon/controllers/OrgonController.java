package com.orgon.controllers;

import com.orgon.entities.Orgon;
import com.orgon.services.OrgonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
public class OrgonController {

    private final OrgonService orgonService;

    @GetMapping("getOrgonById/{id}")
    public Optional<Orgon> getOrgonById(@PathVariable Long id) {
        return orgonService.getOrgonById(id);
    }
}
