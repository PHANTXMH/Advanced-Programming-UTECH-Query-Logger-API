

INSERT INTO public.users(
id, created_at, deleted_at, updated_at, contact, email, first_name, last_name, password, role, username, created_user_id, mod_user_id)
VALUES (1, CURRENT_TIMESTAMP, NULL , CURRENT_TIMESTAMP, '8768513343', 'ricardogaynorgaynor@gmail.com', 'Ricardo', 'Gaynor',
'$2y$12$1j7b17MQ/5xlZS1.lFwmpOqhltXSkrSJqrCd07vLDYFOqWMlnwMoi', 'STUDENT', '1605048', 1, 1); -- encrypted password id password