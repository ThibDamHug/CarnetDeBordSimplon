-- roles
INSERT INTO `role` (`name`) VALUES
('formateur');
INSERT INTO `role` (`name`) VALUES
('tuteur');
INSERT INTO `role` (`name`) VALUES
('administrateur');
INSERT INTO `role` (`name`) VALUES
('apprenant');
-- promo
INSERT INTO `promo` (`name`,`start_date`,`end_date`) VALUES
('laposte1','2016-11-01','2017-07-30');
-- diary
INSERT INTO `diary` (`name`,`start_date`,`end_date`,`introduction`,`promo_id`) VALUES
('session1 complete','2017-01-01','2017-01-15','ceci sera ma premiere introduction',1);
INSERT INTO `diary` (`name`,`start_date`,`end_date`,`introduction`,`promo_id`) VALUES
('session2 sans conclusions','2017-01-16','2017-01-31','ceci sera ma deuxieme introduction',1);
INSERT INTO `diary` (`name`,`start_date`,`end_date`,`introduction`,`promo_id`) VALUES
('session3 sans conclusion','2017-02-01','2017-02-15','ceci sera ma troisieme introduction',1);
INSERT INTO `diary` (`name`,`start_date`,`end_date`,`introduction`,`promo_id`) VALUES
('session4 sans reponse','2017-02-15','2017-02-28','ceci sera ma quatrieme introduction',1);
INSERT INTO `diary` (`name`,`start_date`,`end_date`,`introduction`,`promo_id`) VALUES
('session5 sans reponse','2017-03-01','2017-03-15','ceci sera ma cinquieme introduction',1);
INSERT INTO `diary` (`name`,`start_date`,`end_date`,`introduction`,`promo_id`) VALUES
('session6 sans rien','2017-03-15','2017-03-30','ceci sera ma sixieme introduction',1);
-- users :
-- apprenant
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('abdel', 'dupont1', 'azerty', 'abdel@simplon.co', null, 4, 1); 
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('damien', 'dupont2', 'azerty', 'damien@simplon.co', null, 4, 1);
-- formateur
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('manu', 'dupont3', 'azerty', 'manu@simplon.co', null, 1, 1);
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('nico', 'dupont4', 'azerty', 'nico@simplon.co', null, 1, 1);
-- tuteur
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('michael', 'dupont5', 'azerty', 'michael@simplon.co', 1, 2, null);
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('ali', 'dupont6', 'azerty', 'ali@simplon.co', 2, 2, null);
-- administrateur
INSERT INTO `user` (`firstname`,`lastname`, `password`,`email`,`pair_id`,`role_id`,`promo_id` ) VALUES
('laeticia', 'dupont7', 'azerty', 'laeticia@simplon.co', null, 3, null);

-- questions

-- carnet 1
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 1ere question du carnet 1 du tuteur" ,1,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 2eme question du carnet 1 du tuteur" ,1,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 3eme question du carnet 1 du tuteur" ,1,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 4eme question du carnet 1 du tuteur" ,1,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 5eme question du carnet 1 du tuteur" ,1,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 1ere question du carnet 1 de l'apprenant" ,1,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 2eme question du carnet 1 de l'apprenant" ,1,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 3eme question du carnet 1 de l'apprenant" ,1,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 4eme question du carnet 1 de l'apprenant" ,1,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 5eme question du carnet 1 de l'apprenant" ,1,4);

-- carnet 2
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 1ere question du carnet 2 du tuteur" ,2,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 2eme question du carnet 2 du tuteur" ,2,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 3eme question du carnet 2 du tuteur" ,2,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 4eme question du carnet 2 du tuteur" ,2,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 5eme question du carnet 2 du tuteur" ,2,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 1ere question du carnet 2 de l'apprenant" ,2,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 2eme question du carnet 2 de l'apprenant" ,2,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 3eme question du carnet 2 de l'apprenant" ,2,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 4eme question du carnet 2 de l'apprenant" ,2,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 5eme question du carnet 2 de l'apprenant" ,2,4);

-- carnet 3
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 1ere question du carnet 3 du tuteur" ,3,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 2eme question du carnet 3 du tuteur" ,3,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 3eme question du carnet 3 du tuteur" ,3,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 4eme question du carnet 3 du tuteur" ,3,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 5eme question du carnet 3 du tuteur" ,3,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 1ere question du carnet 3 de l'apprenant" ,3,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 2eme question du carnet 3 de l'apprenant" ,3,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 3eme question du carnet 3 de l'apprenant" ,3,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 4eme question du carnet 3 de l'apprenant" ,3,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 5eme question du carnet 3 de l'apprenant" ,3,4);

-- carnet 4
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 1ere question du carnet 4 du tuteur" ,4,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 2eme question du carnet 4 du tuteur" ,4,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 3eme question du carnet 4 du tuteur" ,4,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 4eme question du carnet 4 du tuteur" ,4,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 5eme question du carnet 4 du tuteur" ,4,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 1ere question du carnet 4 de l'apprenant" ,4,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 2eme question du carnet 4 de l'apprenant" ,4,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 3eme question du carnet 4 de l'apprenant" ,4,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 4eme question du carnet 4 de l'apprenant" ,4,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 5eme question du carnet 4 de l'apprenant" ,4,4);

-- carnet 5
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 1ere question du carnet 5 du tuteur" ,5,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 2eme question du carnet 5 du tuteur" ,5,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 3eme question du carnet 5 du tuteur" ,5,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 4eme question du carnet 5 du tuteur" ,5,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 5eme question du carnet 5 du tuteur" ,5,2);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 1ere question du carnet 5 de l'apprenant" ,5,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 2eme question du carnet 5 de l'apprenant" ,5,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 3eme question du carnet 5 de l'apprenant" ,5,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 4eme question du carnet 5 de l'apprenant" ,5,4);
INSERT INTO `question` (`content`,`diary_id`,`role_id`) VALUES
("Ceci sera la 5eme question du carnet 5 de l'apprenant" ,5,4);

-- answers

-- carnet 1
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 1 du carnet 1 du tuteur d'abdel",1,1);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 2 du carnet 1 du tuteur d'abdel",1,2);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 3 du carnet 1 du tuteur d'abdel",1,3);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 4 du carnet 1 du tuteur d'abdel",1,4);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 5 du carnet 1 du tuteur d'abdel",1,5);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 1 du carnet 1 d'abdel",1,6);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 2 du carnet 1 d'abdel",1,7);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 3 du carnet 1 d'abdel",1,8);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 4 du carnet 1 d'abdel",1,9);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 5 du carnet 1 d'abdel",1,10);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 1 du carnet 1 du tuteur de Damien",2,1);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 2 du carnet 1 du tuteur de Damien",2,2);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 3 du carnet 1 du tuteur de Damien",2,3);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 4 du carnet 1 du tuteur de Damien",2,4);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 5 du carnet 1 du tuteur de Damien",2,5);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 1 du carnet 1 de Damien",2,6);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 2 du carnet 1 de Damien",2,7);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 3 du carnet 1 de Damien",2,8);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 4 du carnet 1 de Damien",2,9);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 5 du carnet 1 de Damien",2,10);

-- carnet 2
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 1 du carnet 2 du tuteur d'abdel",1,11);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 2 du carnet 2 du tuteur d'abdel",1,12);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 3 du carnet 2 du tuteur d'abdel",1,13);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 4 du carnet 2 du tuteur d'abdel",1,14);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 5 du carnet 2 du tuteur d'abdel",1,15);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 1 du carnet 2 d'abdel",1,16);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 2 du carnet 2 d'abdel",1,17);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 3 du carnet 2 d'abdel",1,18);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 4 du carnet 2 d'abdel",1,19);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 5 du carnet 2 d'abdel",1,20);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 1 du carnet 2 du tuteur de Damien",2,11);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 2 du carnet 2 du tuteur de Damien",2,12);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 3 du carnet 2 du tuteur de Damien",2,13);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 4 du carnet 2 du tuteur de Damien",2,14);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 5 du carnet 2 du tuteur de Damien",2,15);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 1 du carnet 2 de Damien",2,16);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 2 du carnet 2 de Damien",2,17);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 3 du carnet 2 de Damien",2,18);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 4 du carnet 2 de Damien",2,19);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 5 du carnet 2 de Damien",2,20);

-- carnet 3
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 1 du carnet 1 du tuteur d'abdel",1,21);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 2 du carnet 1 du tuteur d'abdel",1,22);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 3 du carnet 1 du tuteur d'abdel",1,23);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 4 du carnet 1 du tuteur d'abdel",1,24);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 5 du carnet 1 du tuteur d'abdel",1,25);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 1 du carnet 1 d'abdel",1,26);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 2 du carnet 1 d'abdel",1,27);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 3 du carnet 1 d'abdel",1,28);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 4 du carnet 1 d'abdel",1,29);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 5 du carnet 1 d'abdel",1,30);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 1 du carnet 1 du tuteur de Damien",2,21);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 2 du carnet 1 du tuteur de Damien",2,22);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 3 du carnet 1 du tuteur de Damien",2,23);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 4 du carnet 1 du tuteur de Damien",2,24);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 5 du carnet 1 du tuteur de Damien",2,25);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 1 du carnet 1 de Damien",2,26);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 2 du carnet 1 de Damien",2,27);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 3 du carnet 1 de Damien",2,28);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 4 du carnet 1 de Damien",2,29);
INSERT INTO `answer` (`content`,`user_id` ,`question_id`) VALUES
("ceci est la  reponse 5 du carnet 1 de Damien",2,30);

-- conclusions

-- carnet 1
INSERT INTO `conclusion` (`content`,`user_id`,`diary_id`) VALUES
("ceci est la conclusion de la session 1 du carnet d'abdel",1,1);
INSERT INTO `conclusion` (`content`,`user_id`,`diary_id`) VALUES
("ceci est la conclusion de la session 1 du carnet de Damien",2,1);

