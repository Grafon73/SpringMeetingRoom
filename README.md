Программа для бронирования комнаты переговоров.

-Авторизация системы по логину и паролю. Данные пользователей уже содержаться в базе данных, регистрация не нужна;

-При создании события “бронирование переговорки”, мнимальный промежуток бронирования 30 минут, максимальный 24 часа;

-События “бронирования переговорки” нельзя создать в одно и то же время;

-Возможность перелистывания недели как в будущее, так и в прошлое;



Инструкция по запуску:

-Таблица с базой данных эвентов и юзеров в файле MeetingRoom.sql

-Все настройки присоединения базы данных к приложению в файле db.properties

-Используемая кодировка UTF-8


-Переключение недель происходит через выбор в календаре.

-Добавление эвента через клик на ячейку таблицы.

-Изменение/Удаление эвента через кнопку, возле эвента в таблице.

-Spring Security защищает все страницы. Тестовые логины и пароли на странице /login присутствуют.





Используемое ПО:

-Apache Maven 3.6.3

-Java version: 11.0.5, vendor: Oracle Corporation 

-mysql-connector-java v8.0.20

-hibernate 5.4.18.Final

-spring-webmvc 5.2.7.RELEASE

-spring-security 5.3.3.RELEASE

-thymeleaf

-tomcat
