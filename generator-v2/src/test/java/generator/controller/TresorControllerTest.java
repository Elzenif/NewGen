package generator.controller;

import generator.model.entity.TresorType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Germain on 28/05/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TresorControllerTest {

  @Autowired
  private TresorController tresorController;

  @Test
  public void convertTresorPieces() {
    String s = tresorController.convertTresor(TresorType.pieces, "1d1x100pa");
    assertThat(s).isEqualTo("100pa");
    s = tresorController.convertTresor(TresorType.pieces, "3d10x10pp");
    assertThat(s).containsPattern(Pattern.compile("(\\d)*pp"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void convertTresorPiecesWhenError1() {
    tresorController.convertTresor(TresorType.pieces, "d10x100pa");
  }

  @Test(expected = IllegalArgumentException.class)
  public void convertTresorPiecesWhenError3() {
    tresorController.convertTresor(TresorType.pieces, "3dx100pa");
  }

  @Test(expected = IllegalArgumentException.class)
  public void convertTresorPiecesWhenError4() {
    tresorController.convertTresor(TresorType.pieces, "3d10100pa");
  }

  @Test(expected = IllegalArgumentException.class)
  public void convertTresorPiecesWhenError5() {
    tresorController.convertTresor(TresorType.pieces, "5d10xpa");
  }

  @Test(expected = IllegalArgumentException.class)
  public void convertTresorPiecesWhenError6() {
    tresorController.convertTresor(TresorType.pieces, "2d10x100p");
  }

}