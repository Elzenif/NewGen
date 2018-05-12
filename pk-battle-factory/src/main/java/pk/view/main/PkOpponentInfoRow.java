package pk.view.main;

import com.vaadin.data.HasValue;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import commons.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import pk.controller.PkMoveValueChangeListener;
import pk.controller.PkNameValueChangeListener;
import pk.controller.PkTypeValueChangeListener;
import pk.controller.PokemonFactoryController;
import pk.model.data.OpponentPokemonRowModel;

import javax.annotation.PostConstruct;

/**
 * Created by Germain on 10/07/2017.
 */
@org.springframework.stereotype.Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class PkOpponentInfoRow extends PkInfoRow {

  private final PkNameValueChangeListener pkNameValueChangeListener;
  private final PkTypeValueChangeListener pkTypeValueChangeListener;
  private final PkMoveValueChangeListener pkMoveValueChangeListener;

  private PkNameComboBox nameComboBox;
  private PkTypeComboBox typeComboBox;
  private PkMoveComboBox moveComboBox;

  private Component currentComponent;

  @Autowired
  public PkOpponentInfoRow(PokemonFactoryController pokemonFactoryController, OpponentPokemonRowModel opponentPokemonRowModel,
                           PkNameValueChangeListener pkNameValueChangeListener,
                           PkTypeValueChangeListener pkTypeValueChangeListener,
                           PkMoveValueChangeListener pkMoveValueChangeListener) {
    super(pokemonFactoryController, opponentPokemonRowModel);
    this.pkNameValueChangeListener = pkNameValueChangeListener;
    this.pkTypeValueChangeListener = pkTypeValueChangeListener;
    this.pkMoveValueChangeListener = pkMoveValueChangeListener;
  }

  @Autowired
  public void setNameComboBox(PkNameComboBox nameComboBox) {
    this.nameComboBox = nameComboBox;
  }

  @Autowired
  public void setTypeComboBox(PkTypeComboBox typeComboBox) {
    this.typeComboBox = typeComboBox;
  }

  @Autowired
  public void setMoveComboBox(PkMoveComboBox moveComboBox) {
    this.moveComboBox = moveComboBox;
  }

  @PostConstruct
  public void init() {
    ComboBox<PkOpponentCriteria> criteriaComboBox = new ComboBox<>(Constants.resourceBundle.getString("criteria"));
    criteriaComboBox.setWidth(7, Unit.EM);
    criteriaComboBox.setDataProvider(DataProvider.ofItems(PkOpponentCriteria.values()));
    criteriaComboBox.setValue(PkOpponentCriteria.NAME);
    addComponent(criteriaComboBox);

    currentComponent = nameComboBox;
    addComponent(currentComponent);

    criteriaComboBox.addValueChangeListener(new PkOpponentCriteriaValueChangeListener());

    nameComboBox.addValueChangeListener(pkNameValueChangeListener);
    nameComboBox.addFocusListener(pkNameValueChangeListener);

    typeComboBox.addValueChangeListener(pkTypeValueChangeListener);
    typeComboBox.addFocusListener(pkTypeValueChangeListener);

    moveComboBox.addValueChangeListener(pkMoveValueChangeListener);
    moveComboBox.addFocusListener(pkMoveValueChangeListener);

    postInit();
  }

  private class PkOpponentCriteriaValueChangeListener implements HasValue.ValueChangeListener<PkOpponentCriteria> {

    @Override
    public void valueChange(HasValue.ValueChangeEvent<PkOpponentCriteria> event) {
      Component newComponent;
      switch (event.getValue()) {
      case MOVE:
        newComponent = moveComboBox;
        break;
      case NAME:
        newComponent = nameComboBox;
        break;
      case TYPE:
        newComponent = typeComboBox;
        break;
      default:
        return;
      }
      replaceComponent(currentComponent, newComponent);
      currentComponent = newComponent;
    }
  }
}
