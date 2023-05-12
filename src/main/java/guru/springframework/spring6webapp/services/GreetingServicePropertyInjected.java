package guru.springframework.spring6webapp.services;

import org.springframework.stereotype.Service;

@Service("propertyGreetingService")
public class GreetingServicePropertyInjected implements GreetingService{
    @Override
    public String sayGreeting() {
        return "NO TO PROPERTY INJECTIONS";
    }
}
