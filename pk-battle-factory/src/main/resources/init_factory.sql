DROP TABLE IF EXISTS pokemon_factory;

CREATE TABLE pokemon_factory (
  id                 INT AUTO_INCREMENT PRIMARY KEY,
  pokemon_species_id INT NOT NULL,
  nature_id          INT NULL,
  item_id            INT NULL,
  hp                 INT NULL,
  attack             INT NULL,
  defense            INT NULL,
  special_attack     INT NULL,
  special_defense    INT NULL,
  speed              INT NULL,

  CONSTRAINT pokemon_factory_species_id FOREIGN KEY (pokemon_species_id) REFERENCES pokemon_species (id),
  CONSTRAINT pokemon_factory_nature_id FOREIGN KEY (nature_id) REFERENCES natures (id),
  CONSTRAINT pokemon_factory_item_id FOREIGN KEY (item_id) REFERENCES items (id)
)
ENGINE = InnoDB;


DROP TABLE IF EXISTS tmp_pokemon_factory;
CREATE TABLE tmp_pokemon_factory (
  id                 INT AUTO_INCREMENT PRIMARY KEY,
  pokemon_species_id INT         NOT NULL,
  nature             VARCHAR(20) NULL,
  item               VARCHAR(20) NULL,
  hp                 INT         NULL,
  atk                INT         NULL,
  def                INT         NULL,
  spa                INT         NULL,
  spd                INT         NULL,
  spe                INT         NULL,
  CONSTRAINT tmp_pokemon_factory_species_id FOREIGN KEY (pokemon_species_id) REFERENCES pokemon_species (id)
)
ENGINE = InnoDB;

TRUNCATE tmp_pokemon_factory;
LOAD DATA LOCAL INFILE 'F:\\NewGen\\pk-battle-factory\\src\\main\\resources\\pokemon_hgss_factory.csv'
INTO TABLE tmp_pokemon_factory
COLUMNS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(pokemon_species_id, nature, item, hp, atk, def, spa, spd, spe)
SET id = NULL;

DROP TABLE IF EXISTS pokemon_factory;
CREATE TABLE pokemon_factory (
  id                 INT AUTO_INCREMENT PRIMARY KEY,
  pokemon_species_id INT NOT NULL,
  nature_id          INT NULL,
  item_id            INT NULL,
  CONSTRAINT pokemon_factory_species_id FOREIGN KEY (pokemon_species_id) REFERENCES pokemon_species (id),
  CONSTRAINT pokemon_factory_nature_id FOREIGN KEY (nature_id) REFERENCES natures (id),
  CONSTRAINT pokemon_factory_item_id FOREIGN KEY (item_id) REFERENCES items (id)
)
ENGINE = InnoDB;

TRUNCATE pokemon_factory;
INSERT INTO pokemon_factory (pokemon_species_id, nature_id, item_id)
  SELECT
    tmp.pokemon_species_id,
    n.id,
    it.id
  FROM tmp_pokemon_factory tmp
    LEFT JOIN nature_names nn ON tmp.nature = nn.name AND nn.local_language_id = 9
    LEFT JOIN natures n ON nn.nature_id = n.id
    LEFT JOIN item_names itn ON tmp.item = itn.name AND itn.local_language_id = 9
    LEFT JOIN items it ON itn.item_id = it.id;


SELECT
  pokemonfac0_.id   AS col_0_0_,
  pokemonspe2_.name AS col_1_0_,
  naturename5_.name AS col_2_0_
FROM pokemon_factory pokemonfac0_ INNER JOIN pokemon_species pokemonspe1_
    ON pokemonfac0_.pokemon_species_id = pokemonspe1_.id
  INNER JOIN pokemon_species_names pokemonspe2_ ON pokemonspe1_.id = pokemonspe2_.pokemon_species_id
  INNER JOIN languages language3_ ON pokemonspe2_.local_language_id = language3_.id
  LEFT OUTER JOIN natures nature4_ ON pokemonfac0_.nature_id = nature4_.id
  LEFT OUTER JOIN nature_names naturename5_ ON nature4_.id = naturename5_.nature_id
  LEFT OUTER JOIN languages language6_ ON naturename5_.local_language_id = language6_.id
WHERE pokemonspe2_.name = ? AND language3_.iso639 = ? AND CASE WHEN pokemonfac0_.nature_id IS NULL
  THEN ?
                                                          ELSE language6_.iso639 END = ?;