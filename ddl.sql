
CREATE TABLE contestants
	(
	  contestant_number integer     NOT NULL
	, contestant_name   varchar(50) NOT NULL
	, CONSTRAINT PK_contestants PRIMARY KEY
	  (
	    contestant_number
	  )
);

insert into contestants values (1, 'George');
insert into contestants values (2, 'Peppa');
	
create procedure SELECTFROMCONTESTANTS as select contestant_name from contestants where contestant_number = ?;
create procedure GETALL as select * from contestants;