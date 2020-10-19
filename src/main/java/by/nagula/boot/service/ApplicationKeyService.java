package by.nagula.boot.service;

import by.nagula.boot.entity.ApplicationKey;
import by.nagula.boot.repository.ApplicationKeyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationKeyService {
    private final ApplicationKeyRepository applicationKeyRepository;

    public ApplicationKeyService(ApplicationKeyRepository applicationKeyRepository) {
        this.applicationKeyRepository = applicationKeyRepository;
    }

    public void addApiKey(String login){
        ApplicationKey aK = new ApplicationKey();
        aK.setLogin(login);
        aK.setApiKey(generateKey());
        applicationKeyRepository.save(aK);
    }

    private String generateKey(){
        int generatedKey = (int) (Math.random() * 10000);
        return "apiKey:" + generatedKey;
    }

    public Optional<ApplicationKey> showApiKEy(String login){
        return applicationKeyRepository.findByLogin(login);
    }

    public boolean containsByApi(String apiKey){
        return applicationKeyRepository.findByApiKey(apiKey).isEmpty();
    }
}
