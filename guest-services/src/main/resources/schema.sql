CREATE TABLE GUEST (
  GUEST_ID     BIGINT AUTO_INCREMENT PRIMARY KEY,
  FIRST_NAME    VARCHAR,
  LAST_NAME     VARCHAR,
  EMAIL_ADDRESS VARCHAR
);
CREATE UNIQUE INDEX PER_EMAIL_UNIQUE ON GUEST (EMAIL_ADDRESS);