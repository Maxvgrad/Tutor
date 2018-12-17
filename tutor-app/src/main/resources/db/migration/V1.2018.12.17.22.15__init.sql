create table if not exists form (
    id bigserial primary key,
    body jsonb not null
);