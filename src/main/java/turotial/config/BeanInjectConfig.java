package turotial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import turotial.services.ClassRoomService;
import turotial.services.impl.DefaultClassRoomService;

@Configuration
public class BeanInjectConfig {

    @Bean
    public ClassRoomService otherClassRoomService(){
        return new DefaultClassRoomService();
    }

}
