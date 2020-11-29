--EXAMPLES

--Insert steps
insert into lemontree2.step
(title, description, agent_activity, customer_activity, created_at, updated_at, fg_active)
values
("Refered to", "Refered to:", "","", CURDATE(), CURDATE(), '1');

--Insert steps
insert into lemontree2.response
(description, id_original_step, id_next_step, response_type, created_at, updated_at, fg_active)
values
("", 9, 10, 'STATIC', CURDATE(), CURDATE(), '1');

insert into lemontree2.response
(description, id_original_step, id_next_step, response_type, created_at, updated_at, fg_active)
values
("YES", 6, 7, 'MULTIPLE', CURDATE(), CURDATE(), '1'),
("Forgot Pass Code", 6, 7, 'MULTIPLE', CURDATE(), CURDATE(), '1'),
("No", 6, 7, 'MULTIPLE', CURDATE(), CURDATE(), '1'),
("Non Frontier CX",6, 7, 'MULTIPLE', CURDATE(), CURDATE(), '1');

--Obtener las notas segun el record
SELECT s.title, fr.respuesta_escrita, n.description FROM lemontree2.flow_record fr
INNER JOIN notes n ON n.id_flow_record = fr.id
INNER JOIN step s ON s.id = fr.id_step
WHERE fr.id_record = ?;

--Traer la pregunta y sus respuestas
SELECT
s.id AS id_step, s.title, s.description AS description_step, s.agent_activity, s.customer_activity,
r.id AS id_response, r.description AS description_response, r.id_original_step, r.id_next_step, r.response_type
FROM lemontree2.step s
RIGHT JOIN lemontree2.response r ON r.id_original_step = s.id
WHERE s.id = 6;

--Validar login
SELECT count(*) FROM lemontree2.employee e
where e.email = "?" and
e.password = "?";

--Insertar usuario
INSERT INTO employee (email, password, created_at, updated_at, fg_active) values("?", "?", CURDATE(), CURDATE(), '1');

--Insertar una nota
INSERT INTO lemontree2.notes
(id_record, id_step, id_response, respuesta_escrita)
VALUES
(?,?,?,"");

--Insertar una vueltica al flow_record
INSERT INTO lemontree2.flow_record
(id_record, id_step, id_response, respuesta_escrita)
VALUES
(?,?,?,"");