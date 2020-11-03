INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
            VALUES (1, 0, 'Sber', 'Sberbank', 1234567890, 123456789, 'Moscow, 50', '88001111111', true);

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
            VALUES (2, 0, 'Apple', 'Apple', 0987654321, 987654321, 'Moscow, 10', '88002222222', true);

INSERT INTO Office (id, version, name, address, phone, is_active, organization_id)
            VALUES (1, 0, 'Office', 'Moscow, 100', '88001234567', true, 1);

INSERT INTO Office (id, version, name, address, phone, is_active, organization_id)
            VALUES (2, 0, 'Office2', 'Moscow, 120', '88001234568', true, 1);

INSERT INTO Office (id, version, name, address, phone, is_active, organization_id)
            VALUES (3, 0, 'Office3', 'Moscow, 150', '88001234569', true, 2);

INSERT INTO Document (id, version, code, name) VALUES (1, 0, '21', 'Паспорт гражданина Российской Федерации');

INSERT INTO Document (id, version, code, name) VALUES (2, 0, '03', 'Свидетельство о рождении');

INSERT INTO Document (id, version, code, name) VALUES (3, 0, '07', 'Военный билет');

INSERT INTO Document (id, version, code, name) VALUES (4, 0, '08', 'Временное удостоверение, выданное взамен военного билета');

INSERT INTO Document (id, version, code, name) VALUES (5, 0, '10', 'Паспорт иностранного гражданина');

INSERT INTO Document (id, version, code, name)
        VALUES (6, 0, '11', 'Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу');

INSERT INTO Document (id, version, code, name) VALUES (7, 0, '12', 'Вид на жительство в Российской Федерации');

INSERT INTO Document (id, version, code, name) VALUES (8, 0, '13', 'Удостоверение беженца');

INSERT INTO Document (id, version, code, name) VALUES (9, 0, '14', 'Временное удостоверение личности гражданина Российской Федерации');

INSERT INTO Document (id, version, code, name) VALUES (10, 0, '15', 'Разрешение на временное проживание в Российской Федерации');

INSERT INTO Document (id, version, code, name) VALUES (11, 0, '18', 'Свидетельство о предоставлении временного убежища на территории Российской Федерации');

INSERT INTO Document (id, version, code, name) VALUES (12, 0, '23', 'Свидетельство о рождении, выданное уполномоченным органом иностранного государства');

INSERT INTO Document (id, version, code, name) VALUES (13, 0, '24', 'Удостоверение личности военнослужащего Российской Федерации');

INSERT INTO Document (id, version, code, name) VALUES (14, 0, '91', 'Иные документы');

INSERT INTO Nationality (id, version, name, code) VALUES (1, 0, 'USA', '001');

INSERT INTO Nationality (id, version, name, code) VALUES (2, 0, 'Russia', '002');

INSERT INTO Nationality (id, version, name, code) VALUES (3, 0, 'Spain', '007');

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, document_number, document_date, is_identified, office_id, document_id, nationality_id)
            VALUES (1, 0, 'John', 'Smith', 'JS', 'Worker', 5551100, '123', '2015-12-17', TRUE, 1, 2, 3);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, document_number, document_date, is_identified, office_id, document_id, nationality_id)
            VALUES (2, 0, 'Bob', 'Key', 'BK', 'Worker', 5551122, '321', '2018-12-17', TRUE, 2, 1, 2);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, document_number, document_date, is_identified, office_id, document_id, nationality_id)
            VALUES (3, 0, 'Ann', 'Cole', 'AC', 'Boss', 5551111, '111', '2019-12-17', TRUE, 3, 3, 1);