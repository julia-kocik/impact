package pl.puzzle.impact.company;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.company.dto.CompanyCreateDTO;
import pl.puzzle.impact.company.dto.CompanyDetailsUpdateDTO;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "company_details")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class CompanyDetails {

    @Id
    private UUID id;

    private String name;

    private String industry;

    private int size;

    private String logo;

    private String description;

    static CompanyDetails createCompanyDetails(CompanyCreateDTO companyCreateDTO, UUID companyId) {
        return CompanyDetails.builder()
                .id(companyId)
                .name(companyCreateDTO.getName())
                .industry(companyCreateDTO.getIndustry())
                .size(companyCreateDTO.getSize())
                .logo(companyCreateDTO.getLogo())
                .description(companyCreateDTO.getDescription())
                .build();
    }

    void updateCompanyDetails(CompanyDetailsUpdateDTO companyDetailsUpdateDTO) {
        this.name = companyDetailsUpdateDTO.getName();
        this.industry = companyDetailsUpdateDTO.getIndustry();
        this.size = companyDetailsUpdateDTO.getSize();
        this.logo = companyDetailsUpdateDTO.getLogo();
        this.description = companyDetailsUpdateDTO.getDescription();
    }
}
