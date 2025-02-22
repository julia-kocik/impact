package pl.puzzle.impact.company.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.company.Company;
import pl.puzzle.impact.company.CompanyService;
import pl.puzzle.impact.company.dto.CompanyCreateDTO;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Company> createCompany(@RequestBody CompanyCreateDTO companyCreateDTO, @PathVariable Long userId) {
        return ResponseEntity.ok(companyService.createCompany(companyCreateDTO, userId));
    }
}
