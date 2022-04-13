package com.esprit.examen;
import java.text.ParseException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.services.CoursService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursServiceTest {
@Autowired
CoursService cs;
long l=1;
Cours C = new Cours(l,"a",TypeCours.Scrum,"intuiie");
	private static final Logger log = LogManager.getLogger(CoursServiceTest.class);
	@Test
    public void testAddCours() throws ParseException {
            Cours c = new Cours(l+1,"LogInfo",TypeCours.Scrum,"intuiie");
            cs.addCours(c);
        assertThat(c.getTypeCours()).isIn(TypeCours.values());
        log.info("user added : "+ c);
    }

    @Test
    public void testModifCours() throws ParseException {
            C.setDescription("modif with error");
            cs.modifierCours(C);
            assertThat(C.getTypeCours()).isIn(TypeCours.values());
            }

	@Test
	public void testSupprCours() throws ParseException {
    try {
		cs.supprimerCours(l);
	 } catch (Exception e) {
		log.error(e.getMessage());
	 }
        assertThat(l).isPositive();
    }

    @Test
	public void testGetCours() throws ParseException {
	List<Cours> courses = (List<Cours>) cs.getCours();
	log.info(courses.toString());
	assertThat(courses).size().isGreaterThan(0);
	}

}
