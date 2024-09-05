-- Switch to the employee_directory database
-- In PostgreSQL, there's no direct equivalent to USE. Instead, just connect to the database directly.

-- Drop the tables if they exist
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

-- Table structure for table `users`
CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  enabled BOOLEAN NOT NULL,  -- `tinyint` is replaced by `boolean`
  PRIMARY KEY (username)
);

-- Inserting data for table `users`
INSERT INTO users (username, password, enabled) 
VALUES 
('john', '{noop}test123', TRUE),
('mary', '{noop}test123', TRUE),
('susan', '{noop}test123', TRUE);

-- Table structure for table `authorities`
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  CONSTRAINT authorities_idx_1 UNIQUE (username, authority),
  CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);

-- Inserting data for table `authorities`
INSERT INTO authorities (username, authority)
VALUES 
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_MANAGER'),
('susan', 'ROLE_ADMIN');
