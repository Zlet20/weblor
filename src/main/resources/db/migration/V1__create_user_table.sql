CREATE TABLE w_user (
	ID 	VARCHAR ( 36 ) NOT NULL,
	created_at 			TIMESTAMP,
	created_by 			VARCHAR ( 36 ),
	last_modified_at 	TIMESTAMP,
	last_modified_by 	VARCHAR ( 36 ),
	VERSION int4 		NOT NULL,
	username 			VARCHAR(100) NOT NULL UNIQUE,
	password			VARCHAR(255) NOT NULL,
	email				VARCHAR(100) NOT NULL UNIQUE,
	PRIMARY KEY ( ID ) 
);

CREATE TABLE w_item (
	ID 	VARCHAR ( 36 ) NOT NULL,
	created_at 			TIMESTAMP,
	created_by 			VARCHAR ( 36 ),
	last_modified_at 	TIMESTAMP,
	last_modified_by 	VARCHAR ( 36 ),
	VERSION int4 		NOT NULL,
	name 			VARCHAR(100) NOT NULL UNIQUE,
	status			VARCHAR(36),	 	
	PRIMARY KEY ( ID ) 
);

CREATE TABLE pdf_file (
    ID VARCHAR ( 36 ) PRIMARY KEY,
    filename VARCHAR(255),
    content BLOB
);

CREATE TABLE student_info (
	ID 	VARCHAR ( 36 ) NOT NULL,
	class_number_name	VARCHAR(100),
	name 			VARCHAR(100) NOT NULL UNIQUE,
	email			VARCHAR(100),
	PRIMARY KEY ( ID ) 
);
CREATE TABLE usage_info (
	ID 	VARCHAR ( 36 ) PRIMARY KEY NOT NULL,
	'time'	DATE,
	 ( ID )
	item_id VARCHAR ( 36 ),
    student_info_id VARCHAR ( 36 ),
	FOREIGN KEY (item_id) REFERENCES w_item(ID),
	FOREIGN KEY (student_info_id) REFERENCES student_info(ID)

    
);


