package pk.view.utils;

import com.vaadin.server.StreamResource;
import com.vaadin.ui.Image;
import pk.model.dto.PokemonFactoryDTO;

import java.io.InputStream;

public class PkImage extends Image {

  private PkImage(String imageNumber) {
    super(null, new StreamResource(new StreamResource.StreamSource() {
      @Override
      public InputStream getStream() {
        return getClass().getClassLoader().getResourceAsStream("VAADIN/pokecons/" + imageNumber + ".png");
      }
    }, imageNumber));
  }

  public static PkImage of(PokemonFactoryDTO pokemonFactoryDTO) {
    Integer pokemonSpeciesId = pokemonFactoryDTO.getPokemonSpeciesId();
    String imageNumber = "00" + pokemonSpeciesId;
    return new PkImage(imageNumber.substring(imageNumber.length() - 3));
  }

}
