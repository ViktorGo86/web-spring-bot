-- Авторизация на основе ролей Spring Boot Security
-- В итоговый проект Spring Security добавлен. 
-- Веб-приложение создан с правами для заполнения данных "Вопросы с ответами" СУБД PostgreSQL (чтение, запись, редактирование, создание) 
-- ПЛЮС отдельный сервис bot telegram создан, который подключен к БД "Вопросы с ответами". 

-- Пользователи (Учетные записи)
/*CREATE TABLE public.auth_users (
	id serial4 NOT NULL,
	enabled bool NULL,
	"password" varchar(255) NULL,
	user_name varchar(255) NULL,
	CONSTRAINT auth_users_pkey PRIMARY KEY (id)
);

-- Роли
CREATE TABLE public.auth_roles (
	id serial4 NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT auth_roles_pkey PRIMARY KEY (id)
);

-- Права пользователей
CREATE TABLE public.auth_users_roles (
	user_id int4 NOT NULL,
	role_id int4 NOT NULL,
	CONSTRAINT auth_users_roles_pkey PRIMARY KEY (user_id, role_id),
	CONSTRAINT auth_user_fk FOREIGN KEY (role_id) REFERENCES public.auth_roles(id),
	CONSTRAINT auth_role_fk FOREIGN KEY (user_id) REFERENCES public.auth_users(id)
);*/

INSERT INTO public.auth_users (enabled,"password",user_name) VALUES
	 (true,'$2a$10$7UUQ5cLPRJ..s4Q.Pnb/ielBJ06RV5sGgxc95KShZU1660xQT1FQ2','user_editor'),
	 (true,'$2a$10$xxl/wLDPK5LPJJhZNMUHxeVNN0F6myFpQTF7GCTJEp7Fr5yoPTis6','user'),
	 (true,'$2a$10$E/VM2udujz3abecQkfvLhugBkxcYNb99hA4ZddZgC8cdJsR1hMCLS','admin');
	 
INSERT INTO public.auth_roles ("name") VALUES
	 ('USER'),
	 ('ADMIN'),
	 ('EDITOR'),
	 ('CREATOR');	
	
INSERT INTO public.auth_users_roles (user_id,role_id) VALUES
	 (1,1),
	 (2,1),
	 (3,2),
	 (1,3),
	 (1,4);	 