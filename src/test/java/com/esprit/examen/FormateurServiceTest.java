package com.esprit.examen;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Session;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.services.FormateurService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FormateurServiceTest {
	@Autowired
	FormateurService fs;
	long l=1;
	Formateur F = new Formateur(l,"n","m",Poste.Docteur,Contrat.CDI,"nes@esp.tn","pass");
		private static final Logger log = LogManager.getLogger(FormateurServiceTest.class);
		@Test
	    public void testAddFormateur() throws ParseException {
			//Formateur f = new Formateur(l,"n","m",Poste.Ingénieur,Contrat.CDI,"nes@esp.tn","pass");
	           fs.addFormateur(F);
	        assertThat(F.getPoste()).isIn(Poste.values());
	        log.info("formateur : "+F);
	    }

	    @Test
	    public void testModifFormateur() throws ParseException {
	            F.setPrenom("modif Prenom2");
	           fs.modifierFormateur(F);
	            assertThat(F.getPoste()).isIn(Poste.values());
	            assertThat(F.getContrat()).isIn(Contrat.values());
	            }

		@Test
		public void testSupprFormateur() throws ParseException {
	    try {
			fs.supprimerFormateur(l+1);
		 } catch (Exception e) {
			log.error(e.getMessage());
		 }
	        assertThat(l).isPositive();
	    }

	    @Test
		public void testGetFormateur() throws ParseException {
		List<Formateur> formateurs = (List<Formateur>) fs.listFormateurs();
		log.info(formateurs.toString());
		assertThat(formateurs).size().isGreaterThan(0);
		}


}
