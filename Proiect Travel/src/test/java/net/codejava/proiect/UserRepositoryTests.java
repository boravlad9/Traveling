package net.codejava.proiect;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private LocatieRepository repoL;

    // test methods go below

    @Autowired
    private UserRepository repo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("ravikumar@gmail.com");
        user.setPassword("ravi2020");
        user.setFirstName("Ravi");
        user.setLastName("Kumar");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }

    @Test
    public void testeCreateLocatie(){
        Locatie locatie = new Locatie();
        locatie.setBaniPeZi(100);
        locatie.setNumeOras("cevaOras");
        locatie.setTip("cevaTip");
        locatie.setNumePoza("cevaPoza");
        locatie.setNumeStatiune("cevaStatiune");
        locatie.setNrMaximPersoane(2);

        Locatie savedUser = repoL.save(locatie);

        Locatie existUser = entityManager.find(Locatie.class, savedUser.getId());

        assertThat(locatie.getNumeOras()).isEqualTo(existUser.getNumeOras());
    }
}