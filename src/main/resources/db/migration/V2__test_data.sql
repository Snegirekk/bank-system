insert into public.address (id, country, locality, address1, post_code) values
    ('750493ff-0524-4b8e-bb0d-053069386810', 'RU', 'Novosibirsk', 'Tereshkovoy, 32', '630090'),
    ('e9c91430-0d65-4811-8912-2c05d70b89fe', 'RU', 'Novosibirsk', 'Pirogova, 25/3', '630090');

insert into public.customer (id, first_name, last_name, address_id, birthday) values
    ('fdb7d712-67f2-457e-a1f5-f4ee2d36ba09', 'Ivan', 'Petrov', '750493ff-0524-4b8e-bb0d-053069386810', '1998-05-16'),
    ('06b48e00-0ac5-46c6-9202-2fa4566a187b', 'Petr', 'Ivanov', 'e9c91430-0d65-4811-8912-2c05d70b89fe', '1986-09-27');

insert into public.transaction_participant (id, type) values
    ('bf2ac5d3-d36f-4b17-b767-d5884a647794', 'ACCOUNT'),
    ('4fe21a4e-ac79-40b9-955c-05ae8cd349ac', 'ACCOUNT');

insert into public.account (id, amount, customer_id, transaction_participant_id) values
    ('90a209d3-799c-43f3-b563-41ae47d24a65', 3000, 'fdb7d712-67f2-457e-a1f5-f4ee2d36ba09', 'bf2ac5d3-d36f-4b17-b767-d5884a647794'),
    ('819ae1ea-a29a-4628-8cdf-cd1a3e66c2aa', 5000, '06b48e00-0ac5-46c6-9202-2fa4566a187b', '4fe21a4e-ac79-40b9-955c-05ae8cd349ac');