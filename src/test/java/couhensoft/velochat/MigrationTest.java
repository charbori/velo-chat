package couhensoft.velochat;

import couhensoft.velochat.repository.MemoryMemberRepository;
import couhensoft.velochat.service.MemberService;
import org.flywaydb.core.Flyway;
import org.h2.tools.Server;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.context.event.annotation.BeforeTestClass;

public class MigrationTest {

    public static final String DB_URL =
            "jdbc:h2:mem:testdb;MODE=Mysql;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
    private static Server server;

    @BeforeEach
    void beforeEach() throws Exception{
        server = Server.createTcpServer();
        initSchema();
    }

    private static void initSchema(){
        //Flyway flyway = new Flyway();
        //flyway.setDataSource(DB_URL, "sa", "");
        //flyway.migrate();
    }

    @AfterEach
    public static void closeDB() throws Exception{
        server.shutdown();
    }
}
