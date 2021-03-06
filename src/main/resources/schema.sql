CREATE TABLE IF NOT EXISTS Organization
(
    id        INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version   INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    name      VARCHAR(15) NOT NULL COMMENT 'Название',
    full_name VARCHAR(50) NOT NULL COMMENT 'Полное название',
    inn       VARCHAR(10) NOT NULL COMMENT 'ИНН',
    kpp       VARCHAR(9)  NOT NULL COMMENT 'КПП',
    address   VARCHAR(50) NOT NULL COMMENT 'Адрес',
    phone     VARCHAR(11) COMMENT 'Телефон',
    is_active BOOLEAN COMMENT 'Активен'
);
COMMENT ON TABLE Organization IS 'Организация';
CREATE INDEX UX_organization_inn ON Organization (id);

CREATE TABLE IF NOT EXISTS Office
(
    id              INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version         INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    name            VARCHAR(15) NOT NULL COMMENT 'Название',
    address         VARCHAR(50) NOT NULL COMMENT 'Адрес',
    phone           VARCHAR(11) COMMENT 'Телефон',
    is_active       BOOLEAN COMMENT 'Активен',
    organization_id INTEGER     NOT NULL COMMENT 'ID Организации',
    FOREIGN KEY (organization_id) REFERENCES Organization (id)
);
COMMENT ON TABLE Office IS 'Офис';
CREATE INDEX UX_office_organization_id ON Office (organization_id);

CREATE TABLE IF NOT EXISTS Document_Type
(
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    name    VARCHAR(120) NOT NULL COMMENT 'Наименование документа',
    code    VARCHAR(2)   NOT NULL COMMENT 'Код документа'
);
COMMENT ON TABLE Document_Type IS 'Тип документа';
CREATE INDEX UX_document_type_id ON Document_Type (id);

CREATE TABLE IF NOT EXISTS Nationality
(
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    name    VARCHAR(20) NOT NULL COMMENT 'Гражданство',
    code    VARCHAR(3)  NOT NULL COMMENT 'Код гражданства'
);
COMMENT ON TABLE Nationality IS 'Гражданство';
CREATE INDEX UX_nationality_id ON Nationality (id);

CREATE TABLE IF NOT EXISTS User
(
    id             INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version        INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    first_name     VARCHAR(15) NOT NULL COMMENT 'Имя',
    second_name    VARCHAR(15) NOT NULL COMMENT 'Фамилия',
    middle_name    VARCHAR(15) COMMENT 'Отчество',
    position       VARCHAR(20) NOT NULL COMMENT 'Должность',
    phone          VARCHAR(11) NOT NULL COMMENT 'Телефон',
    is_identified  BOOLEAN     NOT NULL COMMENT 'Идентифицирован',
    office_id      INTEGER     NOT NULL COMMENT 'ID офиса',
    FOREIGN KEY (office_id) REFERENCES Office (id),
    nationality_id INTEGER     NOT NULL COMMENT 'ID гражданства',
    FOREIGN KEY (nationality_id) REFERENCES Nationality (id)
);
COMMENT ON TABLE User IS 'Работник';
CREATE INDEX UX_user_office_id ON User (office_id);

CREATE TABLE IF NOT EXISTS Document
(
    user_id          INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY,
    FOREIGN KEY (user_id) REFERENCES User (id),
    version          INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    number           VARCHAR(10) NOT NULL COMMENT 'Номер документа',
    date             DATE        NOT NULL COMMENT 'Дата документа',
    document_type_id INTEGER     NOT NULL COMMENT 'ID Типа документа',
    FOREIGN KEY (document_type_id) REFERENCES Document_Type (id)
);
COMMENT ON TABLE Document IS 'Документ';
CREATE INDEX UX_document_document_type_id ON Document (document_type_id);