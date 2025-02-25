package pl.puzzle.impact.company.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.company.CompanyDetails;
import pl.puzzle.impact.company.CompanyDetailsService;
import pl.puzzle.impact.company.dto.CompanyDetailsUpdateDto;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/company-details")
public class CompanyDetailsController {
    private final CompanyDetailsService companyDetailsService;

    public CompanyDetailsController(CompanyDetailsService companyDetailsService) {
        this.companyDetailsService = companyDetailsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDetails> getCompanyDetailsById(@PathVariable UUID id) {
        Optional<CompanyDetails> companyDetails = companyDetailsService.getCompanyDetailsById(id);
        return companyDetails.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CompanyDetails> updateCompanyDetails(@PathVariable UUID id, @RequestBody CompanyDetailsUpdateDto companyDetailsUpdateDto) {
        try {
            CompanyDetails updatedCompanyDetails = companyDetailsService.updateCompanyDetails(companyDetailsUpdateDto, id);
            return ResponseEntity.ok(updatedCompanyDetails);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
