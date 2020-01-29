insert into category (id, origin, description, img)
values (1, 'Italian', 'Pyszne włoskie jedzenie', '/img/italy-food.jpg'),
       (2, 'Polish', 'Pyszne amerykańskie jedzenie', '/img/american.jpg'),
       (3, 'American', 'Pyszne polskie jedzenie', '/img/polish.jpg');
insert into recipe(id, title, description, rating, category_id)
values (1, 'Sałatka z awokado z rukolą, pomidorkami i mozzarellą ', 'Przepis na sałatke',1, 1),
       (2, 'Spaghetti alla puttanesca ', 'Przepis na spaghetti', 1,1),
       (3, 'Pizza', 'Przepis na pizze', 1,1),
       (4, 'Kotlety schabowe ', 'Przepis na kotlety',1, 2),
       (5, 'Bigos', 'Przepis na bigos',1, 2),
       (6, 'Pierogi ruskie', 'Przepis na pierogi',1, 2),
       (7, 'Burger', 'Przepis na burgera', 1,3),
       (8, 'Hot-dog', 'Przepis na hot-doga',1, 3),
       (9, 'Indyk na Swieto Dziękczynienia', 'Przepis na indyk',1, 3);
