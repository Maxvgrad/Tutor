create table if not exists app_user
(
  id              bigserial primary key,
  login           varchar(255) unique,
  password        varchar(255) not null,
  email           varchar(255) not null,
  full_name       varchar(255) not null,
  phone           varchar(255) not null,
  status          varchar(255) not null
);

comment on table app_user
is 'Таблица пользователей';
comment on column app_user.id
is 'Первичный ключ';
comment on column app_user.login
is 'Логин пользателя';
comment on column app_user.password
is 'Пароль пользоателя в зашифрованном виде';
comment on column app_user.email
is 'E-mail';
comment on column app_user.phone
is 'Телефон';
comment on column app_user.full_name
is 'Фио пользователя';
comment on column app_user.status
is 'Статус пользователя';

create table if not exists user_role
(
  id          bigserial primary key,
  name        varchar(255) not null,
  description varchar(255),
  parent_id   bigint
);

COMMENT ON TABLE user_role
IS 'Пользовательские роли. Пример: администратор, директор, сотрудник';
COMMENT ON COLUMN user_role.id
IS 'Первичный ключ';
COMMENT ON COLUMN user_role.name
IS 'Наименование роли';
COMMENT ON COLUMN user_role.description
IS 'Краткое описание роли';
COMMENT ON COLUMN user_role.parent_id
IS 'Корневая роль';


create table if not exists app_user_roles
(
  app_user_id bigint not null
    constraint app_user_roles_user_fk references app_user (id),
  roles_id    bigint not null
    constraint app_user_roles_role_fk references user_role (id),
  constraint user_user_roles_pkey primary key (app_user_id, roles_id)
);

comment on table app_user_roles
is 'Роли пользователей.(таблица связей)';

create table if not exists examination_form (
    id bigserial primary key,
    creation_date TIMESTAMP not null default current_timestamp,
    type varchar(255) not null,
    description varchar(4096),
    total_questions integer not null,
    submitting_form_keys jsonb not null
);

comment on table examination_form is 'Экзаменационная форма';
comment on column examination_form.id is 'Первичный ключ';
comment on column examination_form.creation_date is 'Дата создания объекта';
comment on column examination_form.type is 'Тип';
comment on column examination_form.description is 'Описание';
comment on column examination_form.total_questions is 'Суммарное число вопросов';
comment on column examination_form.submitting_form_keys is 'Ключ к вопросам';

create table if not exists examination_assessment (
    id bigserial primary key,
    creation_date timestamp not null default current_timestamp,
    submit_date timestamp,
    status varchar(255),
    mark integer,
    app_user_id bigint not null constraint examination_assessment_app_user_fk references app_user (id),
    examination_form_id bigint not null constraint examination_assessment_examination_form_fk references examination_form (id)
);

comment on table examination_assessment is 'Экзаменационное испытание';
comment on column examination_assessment.id is 'Первичный ключ';
comment on column examination_assessment.creation_date is 'Дата создания объекта';
comment on column examination_assessment.submit_date is 'Дата сдачи задания';
comment on column examination_assessment.status is 'Статус';
comment on column examination_assessment.mark is 'Оценка';

create table if not exists examination_assessment_answer (
    examination_assessment_id bigint constraint examination_assessment_answer_examination_assessment_fk references examination_assessment (id),
    total_answers integer,
    submitting_form_answers jsonb not null
);

comment on table examination_assessment_answer is 'Ответы на экзаменационную форму';
comment on column examination_assessment_answer.total_answers is 'Суммарное число ответов';
comment on column examination_assessment_answer.submitting_form_answers is 'Ответы';

create table if not exists examination_assessment_mistake (
    examination_assessment_id bigint constraint examination_assessment_mistake_examination_assessment_fk references examination_assessment (id),
    total_mistackes integer,
    submitting_form_mistackes jsonb not null
);

comment on table examination_assessment_mistake is 'Ошибки на экзаменационную форму';
comment on column examination_assessment_mistake.total_mistackes is 'Суммарное число ощибок';
comment on column examination_assessment_mistake.submitting_form_mistackes is 'Ошибки';