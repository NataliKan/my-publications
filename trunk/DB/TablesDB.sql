CREATE TABLE periodicals.user_account
(
  user_id integer NOT NULL DEFAULT nextval('periodicals.user_user_id_seq'::regclass), -- PK
  first_name text NOT NULL, -- Имя пользователя
  last_name text NOT NULL, -- Фамилия пользователя
  "e-mail" character varying(200)[],
  password character varying(250)[],
  CONSTRAINT user_pr_key PRIMARY KEY (user_id),
  CONSTRAINT user_unique UNIQUE ("e-mail")
);

CREATE TABLE periodicals.user_profile
(
  profile_id integer NOT NULL,
  adress character varying(200),
  telefone character varying(150)[],
  credit_card character varying(250)[],
  create_date date,
  user_id integer,
  user_role smallint NOT NULL DEFAULT 0,
  CONSTRAINT profile_id PRIMARY KEY (profile_id),
  CONSTRAINT user_id FOREIGN KEY (user_id)
      REFERENCES periodicals.user_account (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE periodicals.comment
(
  comment_id integer NOT NULL,
  user_id integer,
  comment_text character varying(400)[],
  CONSTRAINT comment_id PRIMARY KEY (comment_id),
  CONSTRAINT user_id FOREIGN KEY (user_id)
      REFERENCES periodicals.user_account (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE periodicals.periodical
(
  periodical_id integer NOT NULL, -- PK
  title character varying(100)[] NOT NULL, -- Название издания
  per_type text, -- Тематика издания
  company integer, -- Издательство (FK)
  date_of_issue date NOT NULL, -- Дата издания
  price numeric(12,2) NOT NULL,
  available boolean NOT NULL DEFAULT true,
  CONSTRAINT periodical_pr_key PRIMARY KEY (periodical_id),
  CONSTRAINT company FOREIGN KEY (company)
      REFERENCES periodicals.company (company_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

REATE TABLE periodicals.company
(
  company_id integer NOT NULL, -- PK
  company_name character varying(100) NOT NULL, -- Справочник издательств
  publishings integer, -- Список периодических изданий по каждому издательству
  CONSTRAINT pr_key_company PRIMARY KEY (company_id),
  CONSTRAINT publications FOREIGN KEY (publishings)
      REFERENCES periodicals.periodical (periodical_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

REATE TABLE periodicals.shopping_cart
(
  order_id integer NOT NULL, -- PK
  user_id integer, -- Клиент
  periodical_id integer, -- Наименование издания к подписке
  CONSTRAINT order_pr_key PRIMARY KEY (order_id),
  CONSTRAINT order_periodical_id_fkey FOREIGN KEY (periodical_id)
      REFERENCES periodicals.periodical (periodical_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT order_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES periodicals.user_account (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE periodicals.payment
(
  payment_id integer NOT NULL,
  user_id integer,
  order_id integer,
  date_of_payment date,
  CONSTRAINT payment_id PRIMARY KEY (payment_id),
  CONSTRAINT order_id FOREIGN KEY (order_id)
      REFERENCES periodicals.shopping_cart (order_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT payment_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES periodicals.user_account (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE periodicals.order_result
(
  result_id integer NOT NULL, -- PK
  order_id integer, -- номер заказа
  order_status smallint NOT NULL DEFAULT 0,
  CONSTRAINT result_pr_key PRIMARY KEY (result_id),
  CONSTRAINT order_id_fr_key FOREIGN KEY (order_id)
      REFERENCES periodicals.shopping_cart (order_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

