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
        gender
    )
VALUES
    (
        1000,
        'psteide@ford.com',
        'Bean',
        'AA-19-01',
        'https://ik.imagekit.io/psteide/WDiM4AX_l-GpKiH0H.jpg',
        'Female'
    ),
    (
        1001,
        'psteide@ford.com',
        'Sprout',
        'AA-20-01',
        'https://ik.imagekit.io/psteide/Y8xh29a_cZnwocfuB.jpg',
        'Female'
    ),
    (
        1002,
        'psteide@ford.com',
        'Ozymandias',
        'AA-20-02',
        'https://ik.imagekit.io/psteide/ijzzJ8z_8oDB3DHtj.jpg',
        'Male'
    );

INSERT INTO
    snakes(
        id,
        owner,
        name,
        breeder_id,
        img_url,
        gender
    )
VALUES
    (
        1003,
        'psteide@ford.com',
        'Talula',
        'BO-22-01',
        'https://ik.imagekit.io/psteide/99a3lLX_y0fYL4CmG.jpg',
        'Female'
    ),
    (
        1004,
        'psteide@ford.com',
        'No Feet',
        'BO-22-02',
        'https://ik.imagekit.io/psteide/bUjQP7M_gwjS9llW2.jpg',
        'Unknown'
    ),
    (
        1005,
        'psteide@ford.com',
        'Kaa',
        'BO-22-03',
        'https://ik.imagekit.io/psteide/99a3lLX_y0fYL4CmG.jpg',
        'Unknown'
    );

INSERT INTO
    feedings(
        id,
        date,
        item,
        snake_link
    )
VALUES
    (2000, '05/14/2022', 'Jumbo', 1000),
    (2001, '05/28/2022', 'Jumbo', 1000),
    (2002, '06/12/2022', 'Jumbo', 1000),
    (2003, '06/14/2022', 'Adult', 1001),
    (2004, '06/13/2022', 'Adult', 1002);

INSERT INTO
    sheds(
        id,
        date,
        observation,
        snake_link
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
        snake_link
    )
VALUES
    (4000, '05/24/2022', 500, 1000),
    (4001, '06/01/2022', 513, 1000),
    (4002, '06/12/2022', 535, 1000),
    (4003, '06/12/2022', 400, 1001),
    (4004, '06/12/2022', 305, 1002),
    (4005, '06/12/2022', 4, 1003),
    (4006, '06/12/2022', 5, 1004),
    (4007, '06/12/2022', 4.5, 1005);

INSERT INTO
    notes(
        id,
        date,
        note,
        snake_link
    )
VALUES
    (
        5000,
        '06/01/2022',
        'Suspected she maybe gravid again',
        1000
    ),
    (
        5001,
        '06/12/2022',
        'Just laid her second clutch of eggs, 13 eggs total, but only 3 fertile. Currently in her post-lay shed',
        1000
    ),
    (
        5002,
        '06/10/2022',
        'Seemed extra defensive the last time she has handled',
        1001
    ),
    (
        5003,
        '06/12/2022',
        'Extra active during the day',
        1002
    ),
    (
        5004,
        '06/12/2022',
        'Fiesty out of the egg!',
        1003
    ),
    (
        5005,
        '06/12/2022',
        'Werid pattern. Parents are possibilty het for Motley?',
        1004
    ),
    (
        5006,
        '06/12/2022',
        'Baby hatched out as snow, proves parents are definately het for Anery',
        1005
    );