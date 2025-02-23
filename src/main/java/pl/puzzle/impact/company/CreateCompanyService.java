package pl.puzzle.impact.company;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.company.dto.CompanyCreateDTO;

import java.util.UUID;

@Service
public class CreateCompanyService {
    private final CompanyRepository companyRepository;
    private final UserCompanyService userCompanyService;
    private final CompanyDetailsRepository companyDetailsRepository;

    public CreateCompanyService(CompanyRepository companyRepository, UserCompanyService userCompanyService, CompanyDetailsRepository companyDetailsRepository) {
        this.companyRepository = companyRepository;
        this.userCompanyService = userCompanyService;
        this.companyDetailsRepository = companyDetailsRepository;
    }

    public Company createCompany(CompanyCreateDTO companyCreateDTO, UUID userId) {
        // sprawdzenie czy user istnieje
        Company company = Company.createCompany();
        companyRepository.save(company);
        userCompanyService.addUserToCompany(userId, company.getId());
        CompanyDetails companyDetails = CompanyDetails.createCompanyDetails(companyCreateDTO, company.getId());
        companyDetailsRepository.save(companyDetails);
        return company;
    }
}
