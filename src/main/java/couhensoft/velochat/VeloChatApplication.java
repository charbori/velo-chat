package couhensoft.velochat;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VeloChatApplication {

	public static void main(String[] args) {
		//Flyway flyway = Flyway.configure().dataSource("DB_URL","root","root").load();
		System.setProperty("spring.profiles.default", "local");
		SpringApplication.run(VeloChatApplication.class, args);
	}

}
