CREATE TABLE IF NOT EXISTS Organization
(
    id        INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version   INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    name      VARCHAR(15) NOT NULL COMMENT 'Название',
    full_name VARCHAR(50) NOT NULL COMMENT 'Полное название',
    inn       INTEGER     NOT NULL COMMENT 'ИНН',
    kpp       INTEGER     NOT NULL COMMENT 'КПП',
    address   VARCHAR(50) NOT NULL COMMENT 'Адрес',
    phone     VARCHAR(11) NOT NULL COMMENT 'Телефон',
    is_active BOOLEAN     NOT NULL COMMENT 'Активен'
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Office
(
    id              INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version         INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    name            VARCHAR(15) NOT NULL COMMENT 'Название',
    address         VARCHAR(50) NOT NULL COMMENT 'Адрес',
    phone           VARCHAR(11) NOT NULL COMMENT 'Телефон',
    is_active       BOOLEAN     NOT NULL COMMENT 'Активен',
    organization_id INTEGER     NOT NULL COMMENT 'ID Организации',
    FOREIGN KEY (organization_id) REFERENCES Organization (id)
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS Document
(
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    name    VARCHAR(20) NOT NULL COMMENT 'Наименование документа',
    number  VARCHAR(10) NOT NULL COMMENT 'Номер документа',
    date    DATE        NOT NULL COMMENT 'Дата выдачи'
);
COMMENT ON TABLE Document IS 'Документ';

CREATE TABLE IF NOT EXISTS Nationality
(
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    name    VARCHAR(20) NOT NULL COMMENT 'Гражданство',
    code    VARCHAR(3)  NOT NULL COMMENT 'Код гражданства'
);
COMMENT ON TABLE Nationality IS 'Гражданство';

CREATE TABLE IF NOT EXISTS User
(
    id               INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version          INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    first_name       VARCHAR(15) NOT NULL COMMENT 'Имя',
    second_name      VARCHAR(15) NOT NULL COMMENT 'Фамилия',
    middle_name      VARCHAR(15) NOT NULL COMMENT 'Отчество',
    position         VARCHAR(20) NOT NULL COMMENT 'Должность',
    phone            VARCHAR(11) NOT NULL COMMENT 'Телефон',
    is_identified    BOOLEAN     NOT NULL COMMENT 'Идентифицирован',
    office_id        INTEGER     NOT NULL COMMENT 'ID офиса',
    FOREIGN KEY (office_id) REFERENCES Office (id),
    document_id      INTEGER     NOT NULL COMMENT 'ID документа',
    FOREIGN KEY (document_id) REFERENCES Document (id),
    nationality_id   INTEGER     NOT NULL COMMENT 'ID гражданства',
    FOREIGN KEY (nationality_id) REFERENCES Nationality (id)
);
COMMENT ON TABLE User IS 'Работник';