package com.orgon.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrgonCommand {

    String name;

    String location;

    Integer chemtrailsPercentage;
}
