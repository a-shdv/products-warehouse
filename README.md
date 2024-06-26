## Тестовое задание:
Создать CRUD-приложение для склада товаров.
Технологии: Spring-Boot, Hibernate, PostgreSQL.
Хранимая сущность товара должна содержать следующие поля:  название, артикул (уникальное), описание, категория товара, цена, количество, дата и время последнего изменения количества, дата создания. Настройка авторизации в проекте не требуется.
 
Дополнительные необязательные требования, но которые влияют на общую оценку:
1. 	Подключить Swagger или использовать specification-first подход (Open-API спецификацию написать самостоятельно).
2. 	В качестве первичного ключа использовать UUID
3. 	Использовать Lombok в проекте.
4. 	Реализовать валидацию полей запросов (на null, пустоту и т.д.)
5. 	В проект поместить коллекцию Postman с запросами и тестами.
6. 	Добавить юнит-тесты на бизнес-логику
7. 	Настроить локальный старт приложения под отдельным профилем.
8. 	Создать глобальный обработчик исключений.
9. 	Написать dockerfile или docker-compose для создания образа приложения.
10.  Написать Javadocs и инструкцию по запуску приложения.

## Сдача задания:
Тестовое задание необходимо сделать в отдельном публичном репозитории на github. Реализация должна быть в ветке develop, созданной от master. Ветка master должна содержать пустой readme.md файл.

## Запуск проекта
+ Скачать проект:
  + `git clone https://github.com/a-shdv/products-warehouse.git -b develop`
+ Перейти в папку с проектом:
  + `cd products-warehouse`
+ Находясь в директории проекта, запустить следующую команду:  
  + `docker compose up -d`

## Swagger
+ `http://localhost:8080/swagger-ui/index.html`

## p.s.
Реализовано всё, кроме 5-го пункта, - "В проект поместить коллекцию Postman с запросами и тестами.".
