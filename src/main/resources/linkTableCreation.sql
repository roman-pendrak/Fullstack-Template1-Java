CREATE TABLE template1.links (
	id int8 NOT NULL DEFAULT nextval('template1.users_id_seq'::regclass),
	name varchar(255) NULL,
	url varchar(255) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);