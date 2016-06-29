package nbk.model.entity.utils.builders;

import nbk.model.entity.utils.fields.HasSize;

/**
 * Created by Germain on 26/06/2016.
 *
 * Define if the builder size is SMALL or LARGE. NORMAL is the default if no one is used
 */
public interface SizeBuilder extends HasSize {

  SizeBuilder smallSize();

  SizeBuilder largeSize();
}