package pl.puzzle.impact.company;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.company.dto.CompanyCreateDto;
import pl.puzzle.impact.company.dto.CompanyDetailsUpdateDto;

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

    static CompanyDetails createCompanyDetails(CompanyCreateDto companyCreateDto, UUID companyId) {
        return CompanyDetails.builder()
                .id(companyId)
                .name(companyCreateDto.getName())
                .industry(companyCreateDto.getIndustry())
                .size(companyCreateDto.getSize())
                .logo(companyCreateDto.getLogo())
                .description(companyCreateDto.getDescription())
                .build();
    }

    void updateCompanyDetails(CompanyDetailsUpdateDto companyDetailsUpdateDto) {
        this.name = companyDetailsUpdateDto.getName();
        this.industry = companyDetailsUpdateDto.getIndustry();
        this.size = companyDetailsUpdateDto.getSize();
        this.logo = companyDetailsUpdateDto.getLogo();
        this.description = companyDetailsUpdateDto.getDescription();
    }
}
