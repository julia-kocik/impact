package pl.puzzle.impact.company;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.company.dto.CompanyDetailsUpdateDTO;

import java.util.Optional;

@Service
public class CompanyDetailsService {
    private final CompanyDetailsRepository companyDetailsRepository;


    public CompanyDetailsService(CompanyDetailsRepository companyDetailsRepository) {
        this.companyDetailsRepository = companyDetailsRepository;
    }

    public Optional<CompanyDetails> getCompanyDetailsById(Long id) {
        return companyDetailsRepository.findById(id);
    }

    public CompanyDetails updateCompanyDetails(CompanyDetailsUpdateDTO companyDetailsUpdateDTO, Long id) {
        CompanyDetails companyDetails = companyDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        companyDetails.updateCompanyDetails(companyDetailsUpdateDTO);
        companyDetailsRepository.save(companyDetails);
        return companyDetails;
    }
}
