# Дипломный проект

## План автоматизации и отчетные документы:

1. [План автоматизации](https://github.com/bezbiletniy/Diploma/blob/master/plan_reports/plan.md)
2. [Отчётные документы по итогам автоматизированного тестирования](https://github.com/bezbiletniy/Diploma/blob/master/plan_reports/report.md)
3. [Отчётные документы по итогам автоматизации](https://github.com/bezbiletniy/Diploma/blob/master/plan_reports/summary.md)

## Файлы и директории:

1. Файлы docker-compose-mysql.yml, docker-compose-posgreSQL.yml, application.properties находятся в корне проекта
2. Jar файл и gate-simulator находятся в папке artifacts
3. Код тестов находится в папке src/test/java/ru/netology

## Описание процедуры запуска автотестов:

### MySQL:

1. В application.properties использовать:

     `spring.datasource.url=jdbc:mysql://localhost:3306/app`

2. Поднять контейнеры MySQL, Node.js через команду в терминале:

     `docker-compose -f docker-compose-mysql.yml up`

3. Запустить jar файл через команду в терминале:

      `java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar`

4. Запустить автотесты используя зеленый треугольник в IDEA либо через команду в терминале:
       
      `gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app"`

6. Остановить контейнеры через команду в терминале:

      `docker-compose -f docker-compose-mysql.yml down`

### PostgreSQL:

1. В application.properties использовать:

   `spring.datasource.url=jdbc:postgresql://localhost:5432/app`

2. Поднять контейнеры MySQL, Node.js через команду в терминале:

   `docker-compose -f docker-compose-postgresql.yml up`

3. Запустить jar файл через команду в терминале:

   `java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar`

4. Запустить автотесты используя зеленый треугольник в IDEA либо через команду в терминале:

   `gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app`

6. Остановить контейнеры через команду в терминале:

   `docker-compose -f docker-compose-postgresql.yml down`
