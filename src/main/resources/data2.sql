INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username)
VALUES (1, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '8768513343', 'ricardogaynorgaynor@gmail.com', 'Ricardo', 'Gaynor',
'$2a$10$04fc3qJMnRCsRL8ylFnVhuhH2ySYLTi4zS4dPKV0OAOtPjQ05Cyre', 'STUDENT', '1605048' ); -- encrypted password id password


INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username)
VALUES (2, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '8764860382', 'kerionwillis@gmail.com', 'Kerion', 'Willis',
'$2a$10$04fc3qJMnRCsRL8ylFnVhuhH2ySYLTi4zS4dPKV0OAOtPjQ05Cyre', 'STUDENT', '1608987' ); -- encrypted password id password


INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username)
VALUES (3, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '8763549876', 'chrispanther@gmail.com', 'Chris', 'Panther',
'$2a$10$04fc3qJMnRCsRL8ylFnVhuhH2ySYLTi4zS4dPKV0OAOtPjQ05Cyre', 'STUDENT_REPRESENTATIVE', '1509999');


INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username)
VALUES (4, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '8767797832', 'marcalharrision@gmail.com', 'Marcal', 'Harrison',
'$2a$10$04fc3qJMnRCsRL8ylFnVhuhH2ySYLTi4zS4dPKV0OAOtPjQ05Cyre', 'STUDENT', '1703882');



INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username)
VALUES (5, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '8763549876', 'kaceycampbell@gmail.com', 'Kacey', 'Campbell',
'$2a$10$04fc3qJMnRCsRL8ylFnVhuhH2ySYLTi4zS4dPKV0OAOtPjQ05Cyre', 'STUDENT_REPRESENTATIVE', '1909876');



INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username)
VALUES (6, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '876253973', 'rohanbedward@gmail.com', 'Rohan', 'Bedward',
'$2a$10$04fc3qJMnRCsRL8ylFnVhuhH2ySYLTi4zS4dPKV0OAOtPjQ05Cyre', 'STUDENT_REPRESENTATIVE', '10982743');



INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username)
VALUES (7, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '8761243', 'kadeentmopson@gmail.com', 'Kadeen', 'Thompson',
'$2a$10$04fc3qJMnRCsRL8ylFnVhuhH2ySYLTi4zS4dPKV0OAOtPjQ05Cyre', 'STUDENT_REPRESENTATIVE', '1309098');



INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username)
VALUES (8, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '8765432', 'kerionwillis@gmail.com', 'Kerion', 'Willis',
'$2a$10$04fc3qJMnRCsRL8ylFnVhuhH2ySYLTi4zS4dPKV0OAOtPjQ05Cyre', 'STUDENT_REPRESENTATIVE', '1202020');


INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username)
VALUES (9, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '876126434', 'davidwhite@gmail.com', 'David', 'white',
'$2a$10$04fc3qJMnRCsRL8ylFnVhuhH2ySYLTi4zS4dPKV0OAOtPjQ05Cyre', 'STUDENT', '1209098' ); -- encrypted password id password

-- https://www.browserling.com/tools/bcrypt

INSERT INTO public.services(id, icon, name) VALUES (1, 'https://trubluloans.com/images/ap/registration.png', 'Registration');
INSERT INTO public.services(id, icon, name) VALUES (2, 'https://trubluloans.com/images/ap/adddrop.png', 'Add Drop');
INSERT INTO public.services(id, icon, name) VALUES (3, 'https://trubluloans.com/images/ap/accounting.png', 'Accounting');
INSERT INTO public.services(id, icon, name) VALUES (4, 'https://trubluloans.com/images/ap/graduation.png', 'Graduation');