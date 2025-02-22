package pl.puzzle.impact.company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.company.dto.CompanyCreateDTO;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name="company")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String industry;

    private int size;

    private String logo;

    private String description;

    private final LocalDateTime createdAt;

    public static Company createCompany(CompanyCreateDTO companyCreateDTO) {
        return Company.builder()
                .name(companyCreateDTO.getName())
                .industry(companyCreateDTO.getIndustry())
                .size(companyCreateDTO.getSize())
                .logo(companyCreateDTO.getLogo())
                .description(companyCreateDTO.getDescription())
                .createdAt(LocalDateTime.now())
                .build();
    }


}
