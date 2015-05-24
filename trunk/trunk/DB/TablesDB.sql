SET search_path TO 'public';

CREATE TABLE user_account
(
  user_id serial NOT NULL,
  first_name text NOT NULL,
  last_name text NOT NULL,
  email character varying NOT NULL,
  password character varying,
  telefone character varying(200),
  adress character varying(200),
  credit_card character varying(250),
  create_date date,
  user_role text,
  CONSTRAINT user_id PRIMARY KEY (user_id),
  CONSTRAINT email UNIQUE (email)
);

CREATE TABLE company
(
  company_id serial NOT NULL,
  company_name character varying(150)[] NOT NULL,
  periodical integer,
  CONSTRAINT company_id PRIMARY KEY (company_id),
  CONSTRAINT periodical FOREIGN KEY (periodical)
      REFERENCES periodical (periodical_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE periodical
(
  periodical_id serial NOT NULL,
  title text NOT NULL,
  per_type character varying(100),
  company serial NOT NULL,
  date_of_issue date,
  price numeric,
  available boolean DEFAULT true,
  CONSTRAINT periodical_id PRIMARY KEY (periodical_id),
  CONSTRAINT company FOREIGN KEY (company)
      REFERENCES company (company_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE shopping_cart
(
  order_id serial NOT NULL,
  user_id serial NOT NULL,
  periodical_id serial NOT NULL,
  CONSTRAINT order_id PRIMARY KEY (order_id),
  CONSTRAINT periodical_id FOREIGN KEY (periodical_id)
      REFERENCES periodical (periodical_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_id FOREIGN KEY (user_id)
      REFERENCES user_account (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE payment
(
  payment_id serial NOT NULL,
  user_id integer NOT NULL,
  order_id integer NOT NULL,
  date_of_payment date NOT NULL,
  CONSTRAINT payment_id PRIMARY KEY (payment_id),
  CONSTRAINT order_id FOREIGN KEY (order_id)
      REFERENCES shopping_cart (order_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT user_id FOREIGN KEY (user_id)
      REFERENCES user_account (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE order_result
(
  result_id serial NOT NULL,
  order_id integer NOT NULL,
  order_status character varying(50)[],
  CONSTRAINT result_id PRIMARY KEY (result_id),
  CONSTRAINT order_id FOREIGN KEY (order_id)
      REFERENCES shopping_cart (order_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

REATE TABLE comment
(
  comment_id serial NOT NULL,
  user_id integer NOT NULL,
  comment_text character varying(500)[],
  comment_date date,
  CONSTRAINT comment_id PRIMARY KEY (comment_id),
  CONSTRAINT user_id FOREIGN KEY (user_id)
      REFERENCES user_account (user_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
