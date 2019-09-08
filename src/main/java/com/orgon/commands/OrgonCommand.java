package com.orgon.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgonCommand {

    private String name;

    private String location;

    private Integer chemtrailsPercentage;
}
