create table if not exists app_user
(
  id bigserial primary key,
  login
  varchar
(
  255
),
  password        varchar(255) not null,
  email varchar
(
  255
) not null unique,
  full_name       varchar(255) not null,
  phone varchar
(
  255
),
  status          varchar(255) not null
);

comment on table app_user is 'Таблица пользователей';
comment on column app_user.id is 'Первичный ключ';
comment on column app_user.login is 'Логин пользателя';
comment on column app_user.password is 'Пароль пользоателя в зашифрованном виде';
comment on column app_user.email is 'E-mail';
comment on column app_user.phone is 'Телефон';
comment on column app_user.full_name is 'Фио пользователя';
comment on column app_user.status is 'Статус пользователя';

create table if not exists user_role
(
  id          bigserial primary key,
  name        varchar(255) not null,
  description varchar
(
  255
)
);

COMMENT ON TABLE user_role IS 'Пользовательские роли. Пример: администратор, директор, сотрудник';
COMMENT ON COLUMN user_role.id IS 'Первичный ключ';
COMMENT ON COLUMN user_role.name IS 'Наименование роли';
COMMENT ON COLUMN user_role.description IS 'Краткое описание роли';


create table if not exists app_user_roles
(
  app_user_id bigint not null constraint app_user_roles_user_fk references app_user (id),
  roles_id    bigint not null constraint app_user_roles_role_fk references user_role (id),
  constraint user_user_roles_pkey primary key (app_user_id, roles_id)
);

comment on table app_user_roles
is 'Роли пользователей.(таблица связей)';

create table if not exists examination_form (
    id bigserial primary key,
    creation_date TIMESTAMP not null default current_timestamp,
    exam_type varchar(255) not null,
    description varchar(4096),
    total integer not null,
    question_key jsonb not null
);

comment on table examination_form is 'Экзаменационная форма';
comment on column examination_form.id is 'Первичный ключ';
comment on column examination_form.creation_date is 'Дата создания объекта';
comment on column examination_form.exam_type is 'Тип экзамена';
comment on column examination_form.description is 'Описание экзамена';
comment on column examination_form.total is 'Суммарное число вопросов';
comment on column examination_form.question_key is 'Ключ к вопросам';

create table if not exists answer (
    id bigserial primary key,
    total integer,
    submit_form jsonb not null,
    examination_form_id bigint not null constraint answer_examination_form_fk references examination_form (id)
);

comment on table answer is 'Ответы на экзаменационную форму';
comment on column answer.id is 'Первичный ключ';
comment on column answer.total is 'Суммарное число ответов';
comment on column answer.submit_form is 'Форма с ответами';

create table if not exists mistake (
    id bigserial primary key,
    total integer,
    content jsonb not null,
    answer_id bigint not null constraint mistake_answer_fk references answer (id)
);

comment on table mistake is 'Ошибки на экзаменационную форму';
comment on column mistake.id is 'Первичный ключ';
comment on column mistake.total is 'Суммарное число ошибок';
comment on column mistake.content is 'Список ошибок';

create table if not exists examination_assessment (
    id bigserial primary key,
    creation_date timestamp not null default current_timestamp,
    submit_date timestamp,
    status varchar(255),
    mark float,
    app_user_id bigint not null constraint examination_assessment_app_user_fk references app_user (id),
    examination_form_id bigint not null constraint examination_assessment_examination_form_fk references examination_form (id),
    answer_id bigint constraint examination_assessment_answer_fk references answer (id)
);

comment on table examination_assessment is 'Экзаменационное испытание';
comment on column examination_assessment.id is 'Первичный ключ';
comment on column examination_assessment.creation_date is 'Дата создания объекта';
comment on column examination_assessment.submit_date is 'Дата сдачи задания';
comment on column examination_assessment.status is 'Статус';
comment on column examination_assessment.mark is 'Оценка';
