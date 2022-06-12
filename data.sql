TRUNCATE snakes,
feedings,
sheds,
weights,
notes;

INSERT INTO
    snakes(
        id,
        owner,
        name,
        breeder_id,
        img_url,
        gender,
        last_meal,
        last_note
    )
VALUES
    (
        1000,
        'psteide@ford.com',
        'Bean',
        'AA-19-01',
        'https://i.imgur.com/WDiM4AX.jpg',
        'Female',
        '06/04/2022',
        'Just laid her second clutch of eggs, 13 eggs total, but only 3 fertile. Currently in her post-lay shed'
    ),
    (
        1001,
        'psteide@ford.com',
        'Sprout',
        'AA-20-01',
        'https://i.imgur.com/Y8xh29a.jpg',
        'Female',
        '06/04/2022',
        'Seemed extra defensive the last time she has handled'
    ),
    (
        1002,
        'psteide@ford.com',
        'Ozymandias',
        'AA-20-02',
        'https://i.imgur.com/ijzzJ8z.jpg',
        'Male',
        '06/01/2022',
        'Still really active during the day'
    );

INSERT INTO
    snakes(
        id,
        owner,
        name,
        breeder_id,
        img_url,
        gender,
        last_note
    )
VALUES
    (
        1003,
        'psteide@ford.com',
        'Talula',
        'BO-22-01',
        'https://i.imgur.com/99a3lLX.jpg',
        'Female',
        'Fiesty out of the egg!'
    ),
    (
        1004,
        'psteide@ford.com',
        'No Feet',
        'BO-22-02',
        'https://i.imgur.com/bUjQP7M.jpg',
        'Unknown',
        'Werid pattern. Parents are possibilty het for Motley?'
    ),
    (
        1005,
        'psteide@ford.com',
        'Kaa',
        'BO-22-03',
        'https://i.imgur.com/Ui5puwe.jpg',
        'Unknown',
        'Baby hatched out as snow, proves parents are definately het for Anery'
    );

INSERT INTO
    feedings(
        id,
        date,
        item,
        snake_id
    )
VALUES
    (2000, '05/24/2022', 'Adult', 1000),
    (2001, '06/01/2022', 'Adult', 1000),
    (2002, '06/12/2022', 'Adult', 1000);

INSERT INTO
    sheds(
        id,
        date,
        observation,
        snake_id
    )
VALUES
    (3000, '05/24/2022', 'Noticed', 1000),
    (3001, '06/01/2022', 'Shed', 1000),
    (3002, '06/12/2022', 'Shed', 1000);

INSERT INTO
    weights(
        id,
        date,
        weight,
        snake_id
    )
VALUES
    (4000, '05/24/2022', 500, 1000),
    (4001, '06/01/2022', 513, 1000),
    (4002, '06/12/2022', 535, 1000);

INSERT INTO
    notes(
        id,
        date,
        note,
        snake_id
    )
VALUES
    (
        5000,
        '06/12/2022',
        'Just laid her second clutch of eggs, 13 eggs total, but only 3 fertile. Currently in her post-lay shed',
        1000
    );