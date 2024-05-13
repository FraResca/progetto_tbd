package tbd.progetto_idsa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import tbd.progetto_tbd.service.impl.VisitaServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ApplicationTest {

    @Autowired
    private ApplicationContext context;

    @MockBean
    private VisitaServiceImpl visitaService;

    @Test
    public void contextLoads() {
        assertThat(context).isNotNull();
    }
}
