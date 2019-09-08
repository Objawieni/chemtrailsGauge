package com.orgon.controllers;

import com.orgon.commands.OrgonCommand;
import com.orgon.config.Config;
import com.orgon.config.Messages;
import com.orgon.entities.Orgon;
import com.orgon.services.OrgonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin
@RequestMapping("api/chemtrails")
public class OrgonController {

    private final OrgonService orgonService;

    @GetMapping("getAllOrgons")
    public ResponseEntity<List<Orgon>> getAllOrgons() {
        List<Orgon> orgonList = orgonService.getOrgonsList();
        log.info(Messages.GET_ORGON_LIST_MESSAGE);

        return orgonList.isEmpty() ? new ResponseEntity<>(orgonService.getOrgonsList(), HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(orgonService.getOrgonsList(), HttpStatus.OK);
    }

    @GetMapping("getOrgonById/{id}")
    public ResponseEntity<Orgon> getOrgonById(@PathVariable Long id) {
        Optional<Orgon> orgon = orgonService.getOrgonById(id);
        log.info(Messages.GET_ORGON_BY_ID_MESSAGE + id);

        return orgon.isPresent() ? new ResponseEntity<>(orgon.get(), HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("addOrgon")
    public ResponseEntity<Orgon> addOrgon(@RequestBody OrgonCommand orgonCommand) {
        log.info(Messages.POST_NEW_ORGON_MESSAGE + orgonCommand.toString());

        return new ResponseEntity<>(orgonService.addOrgon(
                new Orgon(orgonCommand.getName(), orgonCommand.getLocation(), orgonCommand.getChemtrailsPercentage())),
                HttpStatus.OK);
    }

    @DeleteMapping("removeOrgonById/{id}")
    public ResponseEntity<Orgon> removeOrgonById(@PathVariable Long id) {
        Optional<Orgon> orgon = orgonService.removeOrgonById(id);
        log.info(Messages.REMOVE_ORGON_BY_ID_MESSAGE + id);

        return orgon.isPresent() ? new ResponseEntity<>(orgon.get(), HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("updateOrgonById/{id}")
    public ResponseEntity<Orgon> updateOrgonById(@PathVariable Long id, @RequestBody OrgonCommand orgonCommand) {
        Optional<Orgon> orgon = orgonService.updateOrgonById(id, orgonCommand);
        log.info(Messages.UPDATE_ORGON_BY_ID_MESSAGE + id);
        log.info(orgon.toString());

        return orgon.isPresent() ? new ResponseEntity<>(orgon.get(), HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
