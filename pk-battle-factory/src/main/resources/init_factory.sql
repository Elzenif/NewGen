SET FOREIGN_KEY_CHECKS=0;

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
  move1 VARCHAR(20) NULL,
  move2 VARCHAR(20) NULL,
  move3 VARCHAR(20) NULL,
  move4 VARCHAR(20) NULL,
  CONSTRAINT tmp_pokemon_factory_species_id FOREIGN KEY (pokemon_species_id) REFERENCES pokemon_species (id)
)
ENGINE = InnoDB;

TRUNCATE tmp_pokemon_factory;
LOAD DATA LOCAL INFILE 'F:\\NewGen\\pk-battle-factory\\src\\main\\resources\\pokemon_hgss_factory.csv'
INTO TABLE tmp_pokemon_factory
COLUMNS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(pokemon_species_id, nature, item, hp, atk, def, spa, spd, spe, move1, move2, move3, move4)
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

DROP TABLE IF EXISTS pokemon_factory_stats;
CREATE TABLE pokemon_factory_stats (
  pokemon_factory_id INT NOT NULL,
  stat_id            INT NOT NULL,
  ev                 INT DEFAULT 0,
  PRIMARY KEY (pokemon_factory_id, stat_id),
  CONSTRAINT pokemon_factory_stats_pokemon_factory_id FOREIGN KEY (pokemon_factory_id) REFERENCES pokemon_factory (id),
  CONSTRAINT pokemon_factory_stats_id FOREIGN KEY (stat_id) REFERENCES stats (id)
)
ENGINE = InnoDB;

TRUNCATE pokemon_factory_stats;
INSERT INTO pokemon_factory_stats (pokemon_factory_id, stat_id, ev)
  SELECT
    tmp.id,
    s.id,
    tmp.hp
  FROM tmp_pokemon_factory tmp, stat_names sn
    INNER JOIN stats s ON sn.stat_id = s.id
  WHERE sn.local_language_id = 9 AND sn.name = 'HP';
INSERT INTO pokemon_factory_stats (pokemon_factory_id, stat_id, ev)
  SELECT
    tmp.id,
    s.id,
    tmp.atk
  FROM tmp_pokemon_factory tmp, stat_names sn
    INNER JOIN stats s ON sn.stat_id = s.id
  WHERE sn.local_language_id = 9 AND sn.name = 'Attack';
INSERT INTO pokemon_factory_stats (pokemon_factory_id, stat_id, ev)
  SELECT
    tmp.id,
    s.id,
    tmp.def
  FROM tmp_pokemon_factory tmp, stat_names sn
    INNER JOIN stats s ON sn.stat_id = s.id
  WHERE sn.local_language_id = 9 AND sn.name = 'Defense';
INSERT INTO pokemon_factory_stats (pokemon_factory_id, stat_id, ev)
  SELECT
    tmp.id,
    s.id,
    tmp.spa
  FROM tmp_pokemon_factory tmp, stat_names sn
    INNER JOIN stats s ON sn.stat_id = s.id
  WHERE sn.local_language_id = 9 AND sn.name = 'Special Attack';
INSERT INTO pokemon_factory_stats (pokemon_factory_id, stat_id, ev)
  SELECT
    tmp.id,
    s.id,
    tmp.spd
  FROM tmp_pokemon_factory tmp, stat_names sn
    INNER JOIN stats s ON sn.stat_id = s.id
  WHERE sn.local_language_id = 9 AND sn.name = 'Special Defense';
INSERT INTO pokemon_factory_stats (pokemon_factory_id, stat_id, ev)
  SELECT
    tmp.id,
    s.id,
    tmp.spe
  FROM tmp_pokemon_factory tmp, stat_names sn
    INNER JOIN stats s ON sn.stat_id = s.id
  WHERE sn.local_language_id = 9 AND sn.name = 'Speed';

DROP TABLE IF EXISTS  pokemon_factory_moves;
CREATE TABLE pokemon_factory_moves (
  pokemon_factory_id INT NOT NULL,
  move_id INT NOT NULL,
  PRIMARY KEY (pokemon_factory_id, move_id),
  CONSTRAINT pokemon_factory_moves_pokemon_factory_id FOREIGN KEY (pokemon_factory_id) REFERENCES pokemon_factory (id),
  CONSTRAINT pokemon_factory_moves_move_id FOREIGN KEY (move_id) REFERENCES moves (id)
);

TRUNCATE pokemon_factory_moves;
INSERT INTO pokemon_factory_moves (pokemon_factory_id, move_id)
  SELECT
    tmp.id as pokemon_id,
    m.id as move_id
  FROM tmp_pokemon_factory tmp
    INNER JOIN move_names mn ON tmp.move1 = mn.name
    INNER JOIN moves m ON mn.move_id = m.id
  WHERE mn.local_language_id = 9;
INSERT INTO pokemon_factory_moves (pokemon_factory_id, move_id)
  SELECT
    tmp.id as pokemon_id,
    m.id as move_id
  FROM tmp_pokemon_factory tmp
    INNER JOIN move_names mn ON tmp.move2 = mn.name
    INNER JOIN moves m ON mn.move_id = m.id
  WHERE mn.local_language_id = 9;
INSERT INTO pokemon_factory_moves (pokemon_factory_id, move_id)
  SELECT
    tmp.id as pokemon_id,
    m.id as move_id
  FROM tmp_pokemon_factory tmp
    INNER JOIN move_names mn ON tmp.move3 = mn.name
    INNER JOIN moves m ON mn.move_id = m.id
  WHERE mn.local_language_id = 9;
INSERT INTO pokemon_factory_moves (pokemon_factory_id, move_id)
  SELECT
    tmp.id as pokemon_id,
    m.id as move_id
  FROM tmp_pokemon_factory tmp
    INNER JOIN move_names mn ON tmp.move4 = mn.name
    INNER JOIN moves m ON mn.move_id = m.id
  WHERE mn.local_language_id = 9;
