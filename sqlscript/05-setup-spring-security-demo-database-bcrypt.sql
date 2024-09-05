-- Drop the tables if they exist
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

-- Table structure for table `users`
CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password CHAR(68) NOT NULL,
  enabled BOOLEAN NOT NULL,  -- Replacing tinyint with boolean
  PRIMARY KEY (username)
);

-- Inserting data for table `users`
-- NOTE: The passwords are encrypted using BCrypt
-- Default passwords here are: fun123

INSERT INTO users (username, password, enabled) 
VALUES 
('john', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', TRUE),
('mary', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', TRUE);

-- Table structure for table `authorities`
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  CONSTRAINT authorities4_idx_1 UNIQUE (username, authority),
  CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);

-- Inserting data for table `authorities`
INSERT INTO authorities (username, authority)
VALUES 
('john', 'ROLE_USER'),
('mary', 'ROLE_USER'),
('mary', 'ROLE_ADMIN');
