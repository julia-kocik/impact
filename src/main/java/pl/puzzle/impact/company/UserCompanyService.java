package pl.puzzle.impact.company;
import org.springframework.stereotype.Service;

@Service
public class UserCompanyService {

    private final UserCompanyRepository userCompanyRepository;

    public UserCompanyService(UserCompanyRepository userCompanyRepository) {
        this.userCompanyRepository = userCompanyRepository;
    }

    public void addUserToCompany(Long userId, Long companyId) {
        UserCompany userCompany = UserCompany.builder()
                .userId(userId)
                .companyId(companyId)
                .build();

        userCompanyRepository.save(userCompany);
    }
}

