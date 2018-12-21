DROP TABLE IF EXISTS task_lists;
DROP TABLE IF EXISTS todos;

CREATE TABLE task_lists (
	id serial PRIMARY KEY,
	name varchar(255) NOT NULL
);

CREATE TABLE todos (
	id serial PRIMARY KEY,
	task_list_id int NOT NULL REFERENCES task_lists(id),
	task varchar(255) NOT NULL
);

INSERT INTO task_lists (name) VALUES ('Shopping List');
INSERT INTO todos (task_list_id, task) VALUES (1, 'Potatoes');
INSERT INTO todos (task_list_id, task) VALUES (1, 'Celery');
INSERT INTO todos (task_list_id, task) VALUES (1, 'Salt');
INSERT INTO todos (task_list_id, task) VALUES (1, 'Broth');

