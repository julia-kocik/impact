package pl.puzzle.impact.company;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.company.dto.CompanyCreateDTO;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final UserCompanyService userCompanyService;

    public CompanyService(CompanyRepository companyRepository, UserCompanyService userCompanyService) {
        this.companyRepository = companyRepository;
        this.userCompanyService = userCompanyService;
    }

    public Company createCompany(CompanyCreateDTO companyCreateDTO, Long userId) {
        // sprawdzenie czy user istnieje
        Company company = Company.createCompany(companyCreateDTO);
        companyRepository.save(company);
        userCompanyService.addUserToCompany(userId, company.getId());
        return company;
    }
}
