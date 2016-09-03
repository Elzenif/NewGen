package commons.model.entity;

import commons.model.commons.Game;
import commons.model.entity.characteristics.primary.enums.EItemRarity;
import commons.model.entity.characteristics.primary.enums.IRarity;
import commons.model.entity.characteristics.primary.fields.HasRarity;
import commons.utils.exception.NoAvailableEntityTypeException;

/**
 * Created by Germain on 28/08/2016.
 */
public abstract class Entity<T extends Game> implements HasRarity {

  protected EItemRarity rarity;

  protected Entity(EntityBuilder builder) {
    rarity = builder.rarity;
  }

  protected Entity() {
    rarity = EItemRarity.COMMON;
  }

  protected abstract static class EntityBuilder implements HasRarity {

    protected EItemRarity rarity;

    @Override
    public IRarity getRarity() {
      return rarity;
    }

    protected abstract Entity build() throws NoAvailableEntityTypeException;
  }
}

