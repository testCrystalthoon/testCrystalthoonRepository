create table web5member(
	id varchar2(20) primary key,
	password varchar2(20) not null,
	name varchar2(20) not null,
	email varchar2(20) not null,
	division varchar2(20),
	idno varchar2(20) not null,
	address varchar2(100)
);

create table web5board(
	boardnum number primary key,
	id varchar2(20) not null,
	title varchar2(100) not null,
	content varchar2(2000) not null,
	inputdate date default sysdate,
	hits number default 0,
	originfile varchar2(200) ,
	savedfile varchar2(200)
);

create sequence board_seq start with 1 increment by 1; --boardnum에 관련된 sequence



select * from web5member;

select * from web5board;

alter table web5member modify email varchar2(40);


insert into web5board(
  			boardnum,
  			id,
  			title,
  			content
  		)
  		values(
  			board_seq.nextval,
  			'id',
  			'title',
  			'content'
  		);

alter table web5board add constraint web5board_id_fk foreign key(id) references web5member(id);
  		
select m.name, b.title, b.inputdate, b.hits from web5member m, web5board b where m.id = b.id;
