package pl.puzzle.impact.company.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.company.Company;
import pl.puzzle.impact.company.CompanyService;
import pl.puzzle.impact.company.CreateCompanyService;
import pl.puzzle.impact.company.dto.CompanyCreateDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;
    private final CreateCompanyService createCompanyService;

    public CompanyController(CompanyService companyService, CreateCompanyService createCompanyService) {
        this.companyService = companyService;
        this.createCompanyService = createCompanyService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Company> createCompany(@RequestBody CompanyCreateDTO companyCreateDTO, @PathVariable UUID userId) {
        return ResponseEntity.ok(createCompanyService.createCompany(companyCreateDTO, userId));
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable UUID companyId) {
        Optional<Company> company = companyService.getCompanyById(companyId);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
