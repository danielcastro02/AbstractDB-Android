create table if not exists usuario(
    id_usuario integer primary key autoincrement,
    nome varchar(20),
    senha varchar(20)
)
;
create table if not exists funciona(
nome varchar(20)
)