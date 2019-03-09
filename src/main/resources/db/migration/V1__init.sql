create table model_json (
  id bigserial not null primary key,
  json_in text,
  json_out text,
  constraint model_json_json_in_uniq unique (json_in)
)