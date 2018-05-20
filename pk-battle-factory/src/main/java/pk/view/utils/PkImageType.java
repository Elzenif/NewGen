package pk.view.utils;

import com.vaadin.server.StreamResource;
import com.vaadin.ui.Image;
import org.jetbrains.annotations.NotNull;
import pk.model.entity.Type;

import java.io.InputStream;

public class PkImageType extends Image {

  private PkImageType(String typeIdentifier) {
    super(null, new StreamResource(new StreamResource.StreamSource() {
      @Override
      public InputStream getStream() {
        return getClass().getClassLoader().getResourceAsStream("VAADIN/types/" + typeIdentifier + ".png");
      }
    }, typeIdentifier));
  }

  @NotNull
  public static PkImageType of(@NotNull Type type) {
    return new PkImageType(type.getIdentifier());
  }

}
