package se.overdo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration")
class OverdoApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        Assertions.assertThat(context).isNotNull();
        Assertions.assertThat(context.getBean(OverdoApplication.class)).isNotNull();
    }

}
