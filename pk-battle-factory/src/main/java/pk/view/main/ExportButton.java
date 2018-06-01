package pk.view.main;

import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pk.controller.PokemonFactoryController;
import pk.model.data.PokemonRowModel;
import pk.model.dto.PokemonFactoryDTO;
import pk.model.entity.Ability;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Locale;

@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class ExportButton extends Button implements Button.ClickListener {

  private final PokemonFactoryController pokemonFactoryController;
  private PkInfoRow pkInfoRow;
  private PokemonRowModel pokemonRowModel;

  @Autowired
  public ExportButton(PokemonFactoryController pokemonFactoryController) {
    super(Constants.resourceBundle.getString("export"));
    this.pokemonFactoryController = pokemonFactoryController;
    addClickListener(this);
  }

  public void setPkInfoRow(PkInfoRow pkInfoRow) {
    this.pkInfoRow = pkInfoRow;
  }

  public void setPokemonRowModel(PokemonRowModel pokemonRowModel) {
    this.pokemonRowModel = pokemonRowModel;
  }

  @Override
  public void buttonClick(ClickEvent event) {
    PokemonFactoryDTO pokemonFactoryDTO = pokemonRowModel.get(pkInfoRow);

    Ability ability = pokemonFactoryDTO.getPotentialAbilities().get(0);
    if (pokemonFactoryDTO.getPotentialAbilities().size() > 1) {
      // TODO ask ability name (based on language) -> choose ability
    }

    String prettyPrint = pokemonFactoryController
        .prettyPrint(pokemonFactoryDTO, ability, new Locale("en").getLanguage());
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(new StringSelection(prettyPrint), null);

    Notification.show(Constants.resourceBundle.getString("copy_to_clipboard"));
  }
}
