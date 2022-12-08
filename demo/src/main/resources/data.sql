Insert Into Author (id, first_name, last_name, nick_name, birthday)
VALUES (1, 'Filip', 'Szczesniak', 'Taco Hemingway', '1990-06-29');

Insert Into Author (id, first_name, last_name, nick_name, birthday)
VALUES (2, 'Jakub', 'Grabowski', 'Quebonafide', '1991-07-07');

Insert into Album (id, name, release_date, author_id)
VALUES (1, 'Trójkąt Warszawski', '2014-12-19', 1);
Insert into Album (id, name, release_date, author_id)
VALUES (2, 'Umowa o dzieło', '2015-12-19', 1);
Insert into Album (id, name, release_date, author_id)
VALUES (3, 'Wosk', '2016-07-13', 1);
Insert into Album (id, name, release_date, author_id)
VALUES (4, 'Egzotyka', '2017-07-09', 1);

INSERT into Song (album_id, author_id, name, duration_time, lyrics, views)
VALUES (
        1,
        1,
        'Szlugi i kalafiory',
        '00:03:06',
        'https://genius.com/Taco-hemingway-szlugi-i-kalafiory-lyrics',
        11386420);

INSERT into Song (album_id, author_id, name, duration_time, lyrics, views)
VALUES (
        1,
        1,
        'Marsz, Marsz',
        '00:03:50',
        'https://genius.com/Taco-hemingway-marsz-marsz-lyrics',
        7424286);

INSERT into Song (album_id, author_id, name, duration_time, lyrics, views)
VALUES (
           4,
           2,
           'Zorza',
           '00:02:54',
           'https://genius.com/Quebonafide-zorza-lyrics',
           12763123);