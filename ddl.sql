CREATE USER p3board IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO p3board;

CREATE USER p3story IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO p3story;

CREATE USER p3task IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO p3task;

CREATE USER p3user IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO p3user;

CREATE USER p3chart IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO p3chart;


-- For board manager service
CREATE TABLE board(
 board_id INT,
 board_name VARCHAR2(4000) UNIQUE,
 PRIMARY KEY(board_id)
);
/
CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1;

-- For story manager service
CREATE TABLE story(
 story_id INT,
 board_id INT NOT NULL,
 lt_id INT DEFAULT 1 NOT NULL,
 story_name VARCHAR2(4000) NOT NULL,
 story_points INT DEFAULT 0 NOT NULL,
 story_desc VARCHAR2(4000),
 last_move_date DATE,
 PRIMARY KEY(story_id)
);
/
CREATE SEQUENCE story_seq START WITH 1 INCREMENT BY 1;

-- For task manager service
CREATE TABLE task(
 task_id INT,
 story_id INT NOT NULL,
 task_desc VARCHAR2(4000) NOT NULL,
 PRIMARY KEY(task_id)
);
/
CREATE SEQUENCE task_seq START WITH 1 INCREMENT BY 1;

-- For user service
CREATE TABLE role_type(
 rt_id INT,
 rt_name VARCHAR2(4000) UNIQUE,
 PRIMARY KEY(rt_id)
);
/

CREATE TABLE scrum_user(
 su_id INT,
 rt_id INT DEFAULT 1 NOT NULL,
 su_fn VARCHAR2(4000),
 su_ln VARCHAR2(4000),
 su_username VARCHAR2(4000) UNIQUE NOT NULL,
 su_password VARCHAR2(4000) NOT NULL,
 PRIMARY KEY(su_id),
 FOREIGN KEY(rt_id) REFERENCES role_type(rt_id)
);
/

CREATE TABLE board_user_join(
 board_id INT,
 su_id INT,
 PRIMARY KEY(board_id, su_id),
 FOREIGN KEY(su_id) REFERENCES scrum_user(su_id)
);
/
CREATE SEQUENCE scrum_user_seq START WITH 1 INCREMENT BY 1;

-- For chart service
CREATE TABLE chart(
 chart_id INT,
 board_id INT NOT NULL,
 chart_title VARCHAR2(4000),
 start_date DATE DEFAULT SYSDATE NOT NULL,
 PRIMARY KEY(chart_id)
);
/
CREATE SEQUENCE chart_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE board_comment(
 board_comment_id INT,
 board_id INT,
 su_id INT,
 comment_desc VARCHAR2(4000),
 comment_date DATETIME DEFAULT sysdate,
 PRIMARY KEY(board_comment_id)
);
/
CREATE SEQUENCE board_comment_seq START WITH 1 INCREMENT BY 1;

--In every database run the following for logging
CREATE TABLE logs(
 l_id INT,
 l_dated VARCHAR2(4000),
 l_level VARCHAR2(4000),
 l_logger VARCHAR2(4000),
 l_message VARCHAR2(4000),
 PRIMARY KEY(l_id)
);
/
CREATE SEQUENCE log_seq START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER log_seq_trg 
BEFORE INSERT ON logs
FOR EACH ROW
BEGIN
IF :new.L_ID IS NULL THEN
  SELECT log_seq.NEXTVAL INTO :new.L_ID FROM dual;
END IF;
END;
/
