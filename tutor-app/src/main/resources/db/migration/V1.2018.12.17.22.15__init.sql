create table if not exists app_user
(
  id              bigserial primary key,
  login           varchar(255) unique,
  password        varchar(255),
  email           varchar(255),
  full_name       varchar(255) not null,
  phone           varchar(255),
  status          varchar(255)
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
    questions_key jsonb not null
);

comment on table examination_form is 'Экзаменационная форма';
comment on column examination_form.id is 'Первичный ключ';
comment on column examination_form.creation_date is 'Дата создания объекта';
comment on column examination_form.type is 'Тип';
comment on column examination_form.description is 'Описание';
comment on column examination_form.total_questions is 'Суммарное число вопросов';
comment on column examination_form.questions_key is 'Ключ к вопросам';

create table if not exists exam_assessment (
    id bigserial primary key,
    creation_date timestamp not null default current_timestamp,
    submit_date timestamp,
    status varchar(255),
    mark smallint,
    app_user_id bigint not null constraint exam_assessment_app_user_fk references app_user (id),
    examination_form_id bigint not null constraint exam_assessment_examination_form_fk references examination_form (id)
);

comment on table exam_assessment is 'Экзаменационное испытание';
comment on column exam_assessment.id is 'Первичный ключ';
comment on column exam_assessment.creation_date is 'Дата создания объекта';
comment on column exam_assessment.submit_date is 'Дата сдачи задания';
comment on column exam_assessment.status is 'Статус';
comment on column exam_assessment.mark is 'Оценка';

create table if not exists examination_form_answer (
    exam_assessment_id bigint constraint examination_form_answer_exam_assessment_fk references exam_assessment (id),
    total_answers integer,
    answers jsonb not null
);

comment on table examination_form_answer is 'Ответы на экзаменационную форму';
comment on column examination_form_answer.total_answers is 'Суммарное число ответов';
comment on column examination_form_answer.answers is 'Ответы';

create table if not exists examination_form_mistake (
    exam_assessment_id bigint constraint examination_form_mistake_exam_assessment_fk references exam_assessment (id),
    total_mistackes integer,
    mistackes jsonb not null
);

comment on table examination_form_mistake is 'Ошибки на экзаменационную форму';
comment on column examination_form_mistake.total_mistackes is 'Суммарное число ощибок';
comment on column examination_form_mistake.mistackes is 'Ошибки';