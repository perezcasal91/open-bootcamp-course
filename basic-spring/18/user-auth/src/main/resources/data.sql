INSERT INTO e_role (description, name) VALUES ('Admin Role', 'ADMIN');
INSERT INTO e_role (description, name) VALUES ('Manager Role', 'MANAGER');
INSERT INTO e_role (description, name) VALUES ('User Role', 'USER');

INSERT INTO e_user(username, email, password) values ('user1', 'user1@user.com', '$2a$10$hjdjJ/M3YF.6h7fIo8PJUOjy34yMt1rF.Y3rhwAt9zJ909vXdCCu.');
INSERT INTO e_user_role(user_id, role_id) values (1, 3);

INSERT INTO e_user(username, email, password) values ('user2', 'user2@admin.com', '$2a$10$hjdjJ/M3YF.6h7fIo8PJUOjy34yMt1rF.Y3rhwAt9zJ909vXdCCu.');
INSERT INTO e_user_role(user_id, role_id) values (2, 1);