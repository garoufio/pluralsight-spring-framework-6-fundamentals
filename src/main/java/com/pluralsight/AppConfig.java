package com.pluralsight;

import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.repository.StubSpeakerRepositoryImpl;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan({"com.pluralsight"})
public class AppConfig {

  @Bean(name="speakerService")
  @Scope(value= BeanDefinition.SCOPE_SINGLETON)
  public SpeakerService getSpeakerService() {
    // SpeakerRepository will be automatically injected as it is Autowired
    SpeakerServiceImpl speakerService = new SpeakerServiceImpl();
    //SpeakerServiceImpl speakerService = new SpeakerServiceImpl(getSpeakerRepository()); // constructor injection
    //speakerService.setSpeakerRepository(getSpeakerRepository()); // setter injection
    return speakerService;
  }

  @Bean(name="speakerRepository")
  public SpeakerRepository getSpeakerRepository() {
    return new StubSpeakerRepositoryImpl();
  }

}
