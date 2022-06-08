TRUNCATE snakes;

INSERT INTO
    snakes(
        id,
        name,
        breeder_id,
        img_url,
        gender,
        last_meal,
        last_note
    )
VALUES
    (
        1,
        'Bean',
        'AA-19-01',
        'https://i.imgur.com/WDiM4AX.jpg',
        'Female',
        '06/04/2022',
        'Just laid her second clutch of eggs, 13 eggs total, but only 3 fertile. Currently in her post-lay shed'
    ),
    (
        2,
        'Sprout',
        'AA-20-01',
        'https://i.imgur.com/Y8xh29a.jpg',
        'Female',
        '06/04/2022',
        'Seemed extra defensive the last time she has handled'
    ),
    (
        3,
        'Ozymandias',
        'AA-20-02',
        'https://i.imgur.com/ijzzJ8z.jpg',
        'Male',
        '06/01/2022',
        'Still really active during the day'
    )