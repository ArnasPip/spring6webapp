package guru.springframework.spring6webapp.services.i18n;

import guru.springframework.spring6webapp.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Profile("LT")
@Service("i18NService")
public class LithuanianGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Labas lietuviškai!";
    }
}
