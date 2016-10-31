package commons.model.entity.characteristics.primary.fields;

import java.util.Map;

/**
 * Created by Germain on 31/10/2016.
 */
@FunctionalInterface
public interface HasMultipleRarities<K extends IRarityKey> {

  Map<K, HasRarity> getRarities();
}
