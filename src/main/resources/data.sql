INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
            VALUES (1, 0, 'Sber', 'Sberbank', 1234567890, 123456789, 'Moscow, 50', 88001111111, true);

INSERT INTO Organization (id, version, name, full_name, inn, kpp, address, phone, is_active)
            VALUES (2, 0, 'Apple', 'Apple', 0987654321, 987654321, 'Moscow, 10', 88002222222, true);

INSERT INTO Office (id, version, name, address, phone, is_active, organization_id)
            VALUES (1, 0, 'Office', 'Moscow, 100', 88001234567, true, 1);

INSERT INTO Office (id, version, name, address, phone, is_active, organization_id)
            VALUES (2, 0, 'Office2', 'Moscow, 120', 88001234568, true, 1);

INSERT INTO Office (id, version, name, address, phone, is_active, organization_id)
            VALUES (3, 0, 'Office3', 'Moscow, 150', 88001234569, true, 2);

INSERT INTO Document (id, version, name, number, date) VALUES (1, 0, 'Passport', 15476, '2015-10-20');

INSERT INTO Document (id, version, name, number, date) VALUES (2, 0, 'DNI', 69574, '2018-10-20');

INSERT INTO Document (id, version, name, number, date) VALUES (3, 0, 'Driving License', 02476, '2019-05-10');

INSERT INTO Nationality (id, version, name, code) VALUES (1, 0, 'USA', 001);

INSERT INTO Nationality (id, version, name, code) VALUES (2, 0, 'Russia', 002);

INSERT INTO Nationality (id, version, name, code) VALUES (3, 0, 'Spain', 007);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, is_identified, office_id, document_id, nationality_id)
            VALUES (1, 0, 'John', 'Smith', 'JS', 'Worker', 5551100, TRUE, 1, 2, 3);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, is_identified, office_id, document_id, nationality_id)
            VALUES (2, 0, 'Bob', 'Key', 'BK', 'Worker', 5551122, TRUE, 2, 1, 2);

INSERT INTO User (id, version, first_name, second_name, middle_name, position, phone, is_identified, office_id, document_id, nationality_id)
            VALUES (3, 0, 'Ann', 'Cole', 'AC', 'Boss', 5551111, TRUE, 3, 3, 1);