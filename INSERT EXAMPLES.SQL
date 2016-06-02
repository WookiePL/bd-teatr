--Skrypt dodający przykładowe dane do każdej tabeli w bazie
--autor: Lukasz Janas

INSERT INTO theater.dayofweek (name, day_of_week_id) VALUES
  ('Poniedziałek', 1),
  ('Wtorek', 2),
  ('Środa', 3),
  ('Czwartek', 4),
  ('Piątek', 5),
  ('Sobota', 6),
  ('Niedziela', 7);

INSERT INTO theater.period (period_id, name) VALUES
  (nextval('theater.period_period_id_seq'), 'Weekend'),
  (nextval('theater.period_period_id_seq'), 'Dni powszednie'),
  (nextval('theater.period_period_id_seq'), 'Czwartki');

INSERT INTO theater.cycle (cycle_id, period_id, day_of_week_id) VALUES
  (nextval('theater.cycle_cycle_id_seq'), (select p.period_id from theater.period p where p.name = 'Weekend'), (select d.day_of_week_id from theater.dayofweek d where d.name = 'Sobota')),
  (nextval('theater.cycle_cycle_id_seq'), (select p.period_id from theater.period p where p.name = 'Dni powszednie'), (select d.day_of_week_id from theater.dayofweek d where d.name = 'Poniedziałek')),
  (nextval('theater.cycle_cycle_id_seq'), (select p.period_id from theater.period p where p.name = 'Czwartki'), (select d.day_of_week_id from theater.dayofweek d where d.name = 'Czwartek'));

INSERT INTO theater.eventtype (event_type_id, name) VALUES
  (nextval('theater.eventtype_event_type_id_seq'), 'Dramat'),
  (nextval('theater.eventtype_event_type_id_seq'), 'Komedia'),
  (nextval('theater.eventtype_event_type_id_seq'), 'Romans');

INSERT INTO theater.groupofclients (group_of_clients_id, name) VALUES
  (nextval('theater.groupofclients_group_of_clients_id_seq'), 'Podstawowa'),
  (nextval('theater.groupofclients_group_of_clients_id_seq'), 'Dzieci'),
  (nextval('theater.groupofclients_group_of_clients_id_seq'), 'Studenci'),
  (nextval('theater.groupofclients_group_of_clients_id_seq'), 'Emeryci'),
  (nextval('theater.groupofclients_group_of_clients_id_seq'), 'Specjalna grupa klientów ze specjalnymi zniżkami xD');

INSERT INTO theater.event (event_id, name, description, event_type_id) VALUES
  (nextval('theater.event_event_id_seq'), 'Romeo i Julia', 'Dramat Shakespeara', (SELECT et.event_type_id FROM theater.eventtype et WHERE et.name = 'Dramat')),
  (nextval('theater.event_event_id_seq'), 'Kasztanek', 'Bardzo śmieszne', (SELECT et.event_type_id FROM theater.eventtype et WHERE et.name = 'Komedia')),
  (nextval('theater.event_event_id_seq'), 'Sztuka', 'Dramat dla sztuki', (SELECT et.event_type_id FROM theater.eventtype et WHERE et.name = 'Dramat'));

INSERT INTO theater.pricelist (price_list_id, "from", "to", event_id) VALUES
  (nextval('theater.pricelist_price_list_id_seq'), '2016-07-01', '2016-08-31', (SELECT e.event_id from theater.event e where e.name = 'Romeo i Julia')),
  (nextval('theater.pricelist_price_list_id_seq'), '2016-01-01', '2016-08-31', (SELECT e.event_id from theater.event e where e.name = 'Kasztanek')),
  (nextval('theater.pricelist_price_list_id_seq'), '2016-07-01', '2022-08-31', (SELECT e.event_id from theater.event e where e.name = 'Sztuka'));

INSERT INTO theater.price (price, price_id, group_of_clients_id, price_list_id, period_id) VALUES
  (
    52.99,
    nextval('theater.price_price_id_seq'),
    (SELECT gr.group_of_clients_id from theater.groupofclients gr where gr.name = 'Podstawowa'),
    (SELECT pl.price_list_id from theater.pricelist pl WHERE pl.event_id = ((SELECT e.event_id from theater.event e where e.name = 'Romeo i Julia'))),
    (select p.period_id from theater.period p where p.name = 'Weekend')
  ),
  (
    29.99,
    nextval('theater.price_price_id_seq'),
    (SELECT gr.group_of_clients_id from theater.groupofclients gr where gr.name = 'Emeryci'),
    (SELECT pl.price_list_id from theater.pricelist pl WHERE pl.event_id = (SELECT e.event_id from theater.event e where e.name = 'Romeo i Julia')),
    (select p.period_id from theater.period p where p.name = 'Dni powszednie')
  ),
  (
    26.99,
    nextval('theater.price_price_id_seq'),
    (SELECT gr.group_of_clients_id from theater.groupofclients gr where gr.name = 'Studenci'),
    (SELECT pl.price_list_id from theater.pricelist pl WHERE pl.event_id = ((SELECT e.event_id from theater.event e where e.name = 'Sztuka'))),
    (select p.period_id from theater.period p where p.name = 'Czwartki')
  );

INSERT INTO theater.building (building_id, address) VALUES
  (nextval('theater.building_building_id_seq'), 'ul. Akademicka 16, 44-100 Gliwice, Polska'),
  (nextval('theater.building_building_id_seq'), 'ul. Zwycięstwa 23, 44-100 Gliwice, Polska'),
  (nextval('theater.building_building_id_seq'), 'ul. Krasińskiego 29, 40-019 Katowice, Polska'),
  (nextval('theater.building_building_id_seq'), 'ul. Grabowa 2 , 40-172 Katowice, Polska');

INSERT INTO theater.room (room_id, number, building_id) VALUES
  (nextval('theater.room_room_id_seq'), 4, (SELECT b.building_id FROM theater.building b WHERE b.address = 'ul. Akademicka 16, 44-100 Gliwice, Polska')),
  (nextval('theater.room_room_id_seq'), 2, (SELECT b.building_id FROM theater.building b WHERE b.address = 'ul. Zwycięstwa 23, 44-100 Gliwice, Polska')),
  (nextval('theater.room_room_id_seq'), 3, (SELECT b.building_id FROM theater.building b WHERE b.address = 'ul. Krasińskiego 29, 40-019 Katowice, Polska')),
  (nextval('theater.room_room_id_seq'), 66, (SELECT b.building_id FROM theater.building b WHERE b.address = 'ul. Grabowa 2 , 40-172 Katowice, Polska'));

INSERT INTO theater.eventrealization (date, event_realization_id, price, hour, event_id, room_id) VALUES
  (
    '2016-06-06',
    nextval('theater.eventrealization_event_realization_id_seq'),
    26, 11,
    (SELECT e.event_id from theater.event e where e.name = 'Sztuka'),
    (SELECT r.room_id from theater.room r WHERE r.number = 4)
  ),
  (
    '2016-06-16',
    nextval('theater.eventrealization_event_realization_id_seq'),
    56, 11,
    (SELECT e.event_id from theater.event e where e.name = 'Romeo i Julia'),
    (SELECT r.room_id from theater.room r WHERE r.number = 66)
  );

INSERT INTO theater."user" (user_id, name, surname, email, password) VALUES
  (nextval('theater.user_user_id_seq'), 'Łukasz', 'Janas', 'lukasz@janas.pl', 'wookie123'),
  (nextval('theater.user_user_id_seq'), 'Mateusz', 'Szczesny', 'mateusz@szczesny.pl', 'qwerty345'),
  (nextval('theater.user_user_id_seq'), 'Michał', 'Urbański', 'michal@urbanski.pl', 'mama123'),
  (nextval('theater.user_user_id_seq'), 'Wiktor', 'Florencki', 'wiktor@florencki.pl', 'tata12345'),
  (nextval('theater.user_user_id_seq'), 'Michał', 'Tukaj', 'michal@tukaj.pl', 'tukan111'),
  (nextval('theater.user_user_id_seq'), 'Mateusz', 'Nurek', 'mateusz@nurek.pl', 'haslo1234');

INSERT into theater.roles (role_id, role) VALUES
  (nextval('theater.roles_role_id_seq'), 'Administrator'),
  (nextval('theater.roles_role_id_seq'), 'User');

INSERT INTO theater.users_roles (role_id, user_id) VALUES
  ((SELECT r.role_id from theater.roles r where r.role = 'Administrator'), (SELECT u.user_id from theater."user" u where u.surname = 'Janas')),
  ((SELECT r.role_id from theater.roles r where r.role = 'User'), (SELECT u.user_id from theater."user" u where u.surname = 'Szczesny')),
  ((SELECT r.role_id from theater.roles r where r.role = 'User'), (SELECT u.user_id from theater."user" u where u.surname = 'Urbański')),
  ((SELECT r.role_id from theater.roles r where r.role = 'User'), (SELECT u.user_id from theater."user" u where u.surname = 'Florencki')),
  ((SELECT r.role_id from theater.roles r where r.role = 'Administrator'), (SELECT u.user_id from theater."user" u where u.surname = 'Tukaj')),
  ((SELECT r.role_id from theater.roles r where r.role = 'Administrator'), (SELECT u.user_id from theater."user" u where u.surname = 'Nurek'));

INSERT INTO theater.sector (sector_id, number, room_id) VALUES
  (nextval('theater.sector_sector_id_seq'), 1, (SELECT r.room_id from theater.room r WHERE r.number = 4)),
  (nextval('theater.sector_sector_id_seq'), 2, (SELECT r.room_id from theater.room r WHERE r.number = 4)),
  (nextval('theater.sector_sector_id_seq'), 3, (SELECT r.room_id from theater.room r WHERE r.number = 4)),
  (nextval('theater.sector_sector_id_seq'), 11, (SELECT r.room_id from theater.room r WHERE r.number = 66)),
  (nextval('theater.sector_sector_id_seq'), 12, (SELECT r.room_id from theater.room r WHERE r.number = 66)),
  (nextval('theater.sector_sector_id_seq'), 13, (SELECT r.room_id from theater.room r WHERE r.number = 66));

INSERT INTO theater.reservation (reservation_id, name, phone, email, date, revoke_date, event_realization_id, user_id) VALUES
  (
    nextval('theater.reservation_reservation_id_seq'),
    'Jan Kowalski',
    '606607608',
    'jan@kowalski.pl',
    '2016-06-02',
    NULL,
    (SELECT er.event_realization_id FROM theater.eventrealization er where er.date ='2016-06-16'),
    (SELECT u.user_id from theater."user" u where u.surname = 'Janas')
  ),(
    nextval('theater.reservation_reservation_id_seq'),
    'Mama i Tata',
    '123123123',
    'mama.tata@rodzice.pl',
    '2016-05-02',
    NULL,
    (SELECT er.event_realization_id FROM theater.eventrealization er where er.date ='2016-06-06'),
    (SELECT u.user_id from theater."user" u where u.surname = 'Janas')
  );

INSERT INTO theater.ticket (ticket_id, number, event_realization_id, user_id) VALUES
  (nextval('theater.ticket_ticket_id_seq'), '1', (SELECT er.event_realization_id FROM theater.eventrealization er where er.date ='2016-06-16'), (SELECT u.user_id from theater."user" u where u.surname = 'Janas')),
  (nextval('theater.ticket_ticket_id_seq'), '2', (SELECT er.event_realization_id FROM theater.eventrealization er where er.date ='2016-06-16'), (SELECT u.user_id from theater."user" u where u.surname = 'Janas')),
  (nextval('theater.ticket_ticket_id_seq'), '3', (SELECT er.event_realization_id FROM theater.eventrealization er where er.date ='2016-06-16'), (SELECT u.user_id from theater."user" u where u.surname = 'Janas')),
  (nextval('theater.ticket_ticket_id_seq'), '4', (SELECT er.event_realization_id FROM theater.eventrealization er where er.date ='2016-06-16'), (SELECT u.user_id from theater."user" u where u.surname = 'Janas'));

INSERT INTO theater.place (place_id, number, sector_id, ticket_id, reservation_id) VALUES
  (
    nextval('theater.place_place_id_seq'),
    '1',
    (select s.sector_id from theater.sector s WHERE s.number = '1'),
    (SELECT t.ticket_id from theater.ticket t WHERE t.number = '1'),
    (SELECT er.event_realization_id FROM theater.eventrealization er where er.date ='2016-06-16')
  ),
  (
    nextval('theater.place_place_id_seq'),
    '2',
    (select s.sector_id from theater.sector s WHERE s.number = '1'),
    (SELECT t.ticket_id from theater.ticket t WHERE t.number = '1'),
    (SELECT er.event_realization_id FROM theater.eventrealization er where er.date ='2016-06-16')
  );

