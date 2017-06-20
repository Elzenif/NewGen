package generator.controller;

import generator.model.entity.Arme;
import generator.model.entity.ArmeCorpsACorps;
import generator.model.entity.ProprieteSpeciale;
import generator.model.entity.ProprieteSpecialeArmeCac;
import generator.model.repository.AdversaireDesigneRepository;
import generator.model.repository.ProprieteSpecialeArmeCacRepository;
import generator.model.repository.ProprieteSpecialeArmeDistanceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SuppressWarnings("SpellCheckingInspection")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProprieteSpecialeControllerTest {

  private ProprieteSpecialeController proprieteSpecialeController;
  @Mock
  private ProprieteSpecialeArmeCacRepository proprieteSpecialeArmeCacRepository;
  @Mock
  private ProprieteSpecialeArmeDistanceRepository proprieteSpecialeArmeDistanceRepository;
  @Autowired
  private ArmeInfoController armeInfoController;
  @Autowired
  private AdversaireDesigneRepository adversaireDesigneRepository;

  private Arme arme;
  private ProprieteSpecialeArmeCac prop0;
  private ProprieteSpecialeArmeCac prop1;
  private ProprieteSpecialeArmeCac prop2;
  private ProprieteSpecialeArmeCac prop3;

  @Before
  public void setUp() throws Exception {
    proprieteSpecialeController = new ProprieteSpecialeController(proprieteSpecialeArmeCacRepository,
            proprieteSpecialeArmeDistanceRepository, armeInfoController, adversaireDesigneRepository);

    arme = new ArmeCorpsACorps();
    arme.setId(1);
    arme.setArme("arme");
    arme.setPrix(10);
    arme.setPrcMin(1);
    arme.setPrcMax(5);

    prop0 = new ProprieteSpecialeArmeCac();
    prop0.setId(0);
    prop0.setModificateur(null);
    prop0.setNom("prop0");
    prop0.setPrcMin(1);
    prop0.setPrcMax(5);
    prop0.setPuissance("faible");
    prop1 = new ProprieteSpecialeArmeCac();
    prop1.setId(1);
    prop1.setModificateur(1);
    prop1.setNom("prop1");
    prop1.setPrcMin(6);
    prop1.setPrcMax(10);
    prop1.setPuissance("faible");
    prop2 = new ProprieteSpecialeArmeCac();
    prop2.setId(2);
    prop2.setModificateur(2);
    prop2.setNom("prop2");
    prop2.setPrcMin(11);
    prop2.setPrcMax(15);
    prop2.setPuissance("faible");
    prop3 = new ProprieteSpecialeArmeCac();
    prop3.setId(3);
    prop3.setModificateur(9);
    prop3.setNom("prop3");
    prop3.setPrcMin(16);
    prop3.setPrcMax(20);
    prop3.setPuissance("faible");
  }

  @Test
  public void generateOnePropriete() {
    doReturn(prop1).when(proprieteSpecialeArmeCacRepository)
            .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(anyString(), anyInt(), anyInt());

    List<ProprieteSpeciale> proprieteSpeciales = proprieteSpecialeController.generateProprieteSpecialeArme("faible", arme);

    assertThat(proprieteSpeciales).containsExactly(prop1);
  }

  @Test
  public void generateTwoProprietes() {
    when(proprieteSpecialeArmeCacRepository
            .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(anyString(), anyInt(), anyInt()))
            .thenReturn(prop0, prop1, prop2);

    List<ProprieteSpeciale> proprieteSpeciales = proprieteSpecialeController.generateProprieteSpecialeArme("faible", arme);

    assertThat(proprieteSpeciales).containsExactly(prop1, prop2);
  }

  @Test
  public void generateTwoProprietesWhenSameOneAppearsTwice() {
    when(proprieteSpecialeArmeCacRepository
            .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(anyString(), anyInt(), anyInt()))
            .thenReturn(prop0, prop1, prop1, prop2);

    List<ProprieteSpeciale> proprieteSpeciales = proprieteSpecialeController.generateProprieteSpecialeArme("faible", arme);

    assertThat(proprieteSpeciales).containsExactly(prop1, prop2);
  }

  @Test
  public void generateTwoProprietesWhenTotalModificateurGreaterThan10() {
    when(proprieteSpecialeArmeCacRepository
            .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(anyString(), anyInt(), anyInt()))
            .thenReturn(prop0, prop3, prop2, prop1);

    List<ProprieteSpeciale> proprieteSpeciales = proprieteSpecialeController.generateProprieteSpecialeArme("faible", arme);

    assertThat(proprieteSpeciales).containsExactly(prop3, prop1);
  }

  @Test
  public void generateSecurityForInfiniteLoop() {
    doReturn(prop0).when(proprieteSpecialeArmeCacRepository)
            .findFirstByPuissanceAndPrcMinLessThanEqualAndPrcMaxGreaterThanEqual(anyString(), anyInt(), anyInt());

    List<ProprieteSpeciale> proprieteSpeciales = proprieteSpecialeController.generateProprieteSpecialeArme("faible", arme);

    assertThat(proprieteSpeciales).isEmpty();

  }
}