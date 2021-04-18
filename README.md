## Deadline SQL [![master](https://github.com/aeontal/aqa-3.2/actions/workflows/gradle.yml/badge.svg?branch=main)](https://github.com/aeontal/aqa-3.2/actions/workflows/gradle.yml)

### Задача

Ключевой кейс: сборку приложения с СУБД.


1. Создать Docker Container на базе MySQL 8 
2. Запустить SUT.

Тестируемая функциональность: вход в систему.

### Решение

1. Создан  Docker Container на базе MySQL 8.
2. Написаны тесты на авторизацию в приложении.

### Порядок выполнения

### Подготовка к работе: 

1. Создать новый проект Java+Gradle в IDE (например, IntelliJ IDEA).
2. Инициализировать git репозиторий и подключить [репозиторий](https://github.com/aeontal/aqa-3.2) как удаленный
3. Скачать актуальную версию репозитория на локальный ПК (git pull).
5. Установить инструментарий работы с контейнерами Docker (Docker Desktop или Docker Toolbox) 

### Установка и запуск

1. Запустить docker контейнер с параметрами указанными в docker-compose.yml. 
2. Удостовериться в корректном запуске БД в контейнере (/usr/sbin/mysqld: ready for connections. Version: '8.0.19'  socket: '/var/run/mysqld /mysqld.sock'  port: 3306  MySQL Community Server - GPL)
3. Установить связь с сервером и запустить SUT. Запустить artifacts/app-deadline.jar через GUI IDEA, терминал IDE или ОС
4. Удостовериться в корректном запуске SUT:
 * 2020-10-08 21:30:53.830 [DefaultDispatcher-worker-1] INFO  Application - No ktor.deployment.watch patterns specified, automatic reload is not active
 * 2020-10-08 21:30:54.998 [DefaultDispatcher-worker-1] INFO  Application - Responding at http://0.0.0.0:9999
5. Запустить тесты (./gradlew clean test) 
