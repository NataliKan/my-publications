CREATE TABLE periodicals."user"
(
  user_id serial NOT NULL, -- PK
  first_name text NOT NULL, -- Имя пользователя
  last_name text NOT NULL, -- Фамилия пользователя
  "e-mail" character varying(200)[],
  password character varying(250)[],
  adress character varying(200)[], -- Адрес для подписки
  create_date date, -- Дата создания учетной записи
  telefone integer,
  CONSTRAINT user_pr_key PRIMARY KEY (user_id),
  CONSTRAINT user_unique UNIQUE ("e-mail")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE periodicals."user"
  OWNER TO "new developer";
COMMENT ON COLUMN periodicals."user".user_id IS 'PK';
COMMENT ON COLUMN periodicals."user".first_name IS 'Имя пользователя';
COMMENT ON COLUMN periodicals."user".last_name IS 'Фамилия пользователя';
COMMENT ON COLUMN periodicals."user".adress IS 'Адрес для подписки';
COMMENT ON COLUMN periodicals."user".create_date IS 'Дата создания учетной записи';

CREATE TABLE periodicals.shopping_cart
(
  order_id integer NOT NULL, -- PK
  user_id integer, -- Клиент
  periodical_id integer, -- Наименование издания к подписке
  order_date date, -- Дата заказа
  CONSTRAINT order_pr_key PRIMARY KEY (order_id),
  CONSTRAINT order_periodical_id_fkey FOREIGN KEY (periodical_id)
      REFERENCES periodicals.periodical (periodical_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT order_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES periodicals."user" (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE periodicals.shopping_cart
  OWNER TO "new developer";
COMMENT ON COLUMN periodicals.shopping_cart.order_id IS 'PK';
COMMENT ON COLUMN periodicals.shopping_cart.user_id IS 'Клиент';
COMMENT ON COLUMN periodicals.shopping_cart.periodical_id IS 'Наименование издания к подписке';
COMMENT ON COLUMN periodicals.shopping_cart.order_date IS 'Дата заказа';

CREATE TABLE periodicals.periodical
(
  periodical_id integer NOT NULL, -- PK
  title character varying(100)[] NOT NULL, -- Название издания
  per_type text, -- Тематика издания
  company integer, -- Издательство (FK)
  date_of_issue date NOT NULL, -- Дата издания
  price integer,
  CONSTRAINT periodical_pr_key PRIMARY KEY (periodical_id),
  CONSTRAINT company FOREIGN KEY (company)
      REFERENCES periodicals.company (company_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE periodicals.periodical
  OWNER TO "new developer";
COMMENT ON COLUMN periodicals.periodical.periodical_id IS 'PK';
COMMENT ON COLUMN periodicals.periodical.title IS 'Название издания';
COMMENT ON COLUMN periodicals.periodical.per_type IS 'Тематика издания';
COMMENT ON COLUMN periodicals.periodical.company IS 'Издательство (FK)';
COMMENT ON COLUMN periodicals.periodical.date_of_issue IS 'Дата издания';

CREATE TABLE periodicals.company
(
  company_id integer NOT NULL, -- PK
  company_name character varying(100) NOT NULL, -- Справочник издательств
  publishings integer, -- Список периодических изданий по каждому издательству
  CONSTRAINT pr_key_company PRIMARY KEY (company_id),
  CONSTRAINT publications FOREIGN KEY (publishings)
      REFERENCES periodicals.periodical (periodical_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE periodicals.company
  OWNER TO "new developer";
COMMENT ON COLUMN periodicals.company.company_id IS 'PK';
COMMENT ON COLUMN periodicals.company.company_name IS 'Справочник издательств';
COMMENT ON COLUMN periodicals.company.publishings IS 'Список периодических изданий по каждому издательству';

CREATE TABLE periodicals.payment
(
  payment_id integer NOT NULL,
  user_id integer,
  order_id integer,
  credit_card integer,
  date_of_payment date,
  CONSTRAINT payment_id PRIMARY KEY (payment_id),
  CONSTRAINT order_id FOREIGN KEY (order_id)
      REFERENCES periodicals.shopping_cart (order_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT payment_user_id_fkey FOREIGN KEY (user_id)
      REFERENCES periodicals."user" (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE periodicals.payment
  OWNER TO "new developer";
CREATE TABLE periodicals.order_result
(
  result_id integer NOT NULL, -- PK
  result_name character varying(20)[] NOT NULL, -- Состояние заказа
  order_id integer, -- номер заказа
  CONSTRAINT result_pr_key PRIMARY KEY (result_id),
  CONSTRAINT order_id_fr_key FOREIGN KEY (order_id)
      REFERENCES periodicals.shopping_cart (order_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE periodicals.order_result
  OWNER TO "new developer";
COMMENT ON COLUMN periodicals.order_result.result_id IS 'PK';
COMMENT ON COLUMN periodicals.order_result.result_name IS 'Состояние заказа';
COMMENT ON COLUMN periodicals.order_result.order_id IS 'номер заказа';

CREATE TABLE periodicals.comment
(
  comment_id integer NOT NULL,
  user_id integer,
  comment_text character varying(400)[],
  CONSTRAINT comment_id PRIMARY KEY (comment_id),
  CONSTRAINT user_id FOREIGN KEY (user_id)
      REFERENCES periodicals."user" (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE periodicals.comment
  OWNER TO "new developer";
