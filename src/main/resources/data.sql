INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username, created_user_id, mod_user_id)
VALUES (1, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '8768513343', 'ricardogaynorgaynor@gmail.com', 'Ricardo', 'Gaynor',
'$2a$10$04fc3qJMnRCsRL8ylFnVhuhH2ySYLTi4zS4dPKV0OAOtPjQ05Cyre', 'STUDENT', '1605048', 1, 1); -- encrypted password id password


INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username, created_user_id, mod_user_id)
VALUES (2, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '8764860382', 'kerionwillis@gmail.com', 'Kerion', 'Willis',
'$2a$10$04fc3qJMnRCsRL8ylFnVhuhH2ySYLTi4zS4dPKV0OAOtPjQ05Cyre', 'STUDENT', '1608987', 1, 1); -- encrypted password id password


INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username, created_user_id, mod_user_id)
VALUES (3, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '8763549876', 'chrispanther@gmail.com', 'Chris', 'Panther',
'$2a$10$04fc3qJMnRCsRL8ylFnVhuhH2ySYLTi4zS4dPKV0OAOtPjQ05Cyre', 'STUDENT_REPRESENTATIVE', '1509999', 1, 1); -- encrypted password id password

-- https://www.browserling.com/tools/bcrypt

INSERT INTO public.services(id, icon, name) VALUES (1, 'https://trubluloans.com/images/ap/registration.png', 'Registration');
INSERT INTO public.services(id, icon, name) VALUES (2, 'https://trubluloans.com/images/ap/adddrop.png', 'Add Drop');
INSERT INTO public.services(id, icon, name) VALUES (3, 'https://trubluloans.com/images/ap/accounting.png', 'Accounting');
INSERT INTO public.services(id, icon, name) VALUES (4, 'https://trubluloans.com/images/ap/graduation.png', 'Graduation');