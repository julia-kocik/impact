package pl.puzzle.impact.company.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDetailsUpdateDTO {
    private String name;
    private String industry;
    private int size;
    private String logo;
    private String description;
}
