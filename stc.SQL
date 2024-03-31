
-- //███ ████████████████  ████████████████   starting Point ████████████████  ████████████████  ████████████████ 

 CREATE TABLE "User" (
    user_id NUMBER PRIMARY KEY,
    username VARCHAR2(50)
);

CREATE TABLE "Training_details" (
    user_training_id NUMBER PRIMARY KEY,
    user_id NUMBER,
    training_id NUMBER,
    training_date DATE,
    FOREIGN KEY (user_id) REFERENCES "User"(user_id)
);

-- //███ ████████████████  ████████████████  ████████████████  ████████████████  ████████████████ 
BEGIN
  INSERT ALL
 INTO "User" (user_id, username) VALUES (1,'John Doe')
 INTO "User" (user_id, username) VALUES (2,'Jane Don')
 INTO "User" (user_id, username) VALUES (3,'Alice Jones')
 INTO "User" (user_id, username) VALUES (4,'Lisa Romero')
 SELECT * FROM dual;
  COMMIT;
END;

-- //███ ████████████████  ████████████████  ████████████████  ████████████████  ████████████████ 
BEGIN
  INSERT ALL
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(1,1,1, TO_DATE('2015-08-02','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(2,2,1, TO_DATE('2015-08-03','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(3,3,2, TO_DATE('2015-08-02','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(4,4,2, TO_DATE('2015-08-04','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(5,2,2, TO_DATE('2015-08-03','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(6,1,1, TO_DATE('2015-08-02','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(7,3,2, TO_DATE('2015-08-04','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(8,4,3, TO_DATE('2015-08-03','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(9,1,4, TO_DATE('2015-08-03','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(10,3,1,TO_DATE('2015-08-02','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(11,4,2,TO_DATE('2015-08-04','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(12,3,2,TO_DATE('2015-08-02','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(13,1,1,TO_DATE('2015-08-02','YYYY-MM-DD'))
 INTO "Training_details" (user_training_id, user_id, training_id, training_date) values(14,4,3,TO_DATE('2015-08-03','YYYY-MM-DD'))
SELECT * FROM dual;
  COMMIT;
END;
-- //███ ████████████████  ████████████████  ████████████████  ████████████████  ████████████████ 
SELECT u.user_id, u.username,t.training_id,
TO_CHAR(t.training_date, 'YYYY-MM-DD') AS training_date,
count( t.user_training_id ) AS count 
FROM "User" u JOIN "Training_details" t ON t.user_id = u.user_id 
GROUP BY u.user_id, u.username, t.training_id, t.training_date 
HAVING count( t.user_training_id ) > 1 
ORDER BY u.username || training_date desc;

-- //███ ████████████████  ████████████████  ████████████████  ████████████████  ████████████████ 
-- Results => 

-- "USER_ID", "USERNAME",     "TRAINING_ID", "TRAINING_DATE","COUNT"
--  4,        "Lisa Romero",   2,             08-04-2015,        2
--  4,        "Lisa Romero",   3,             08-03-2015,        2
--  1,        "John Doe",      1,             08-02-2015,        3
--  3,        "Alice Jones",   2,             08-02-2015,        2