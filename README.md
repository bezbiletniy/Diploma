# Описание процедуры запуска автотестов

## MySQL:

1. В application.properties использовать:

     `spring.datasource.url=jdbc:mysql://localhost:3306/app`

2. Поднять контейнеры MySQL, Node.js через команду в терминале:

     `docker-compose -f docker-compose-mysql.yml up`

3. Запустить jar файл через команду в терминале:

      `java -jar ./artifacts/aqa-shop.jar`

4. Запустить автотесты используя зеленый треугольник в IDEA либо через команду в терминале:
       
      `gradlew test`

6. Остановить контейнеры через команду в терминале:

      `docker-compose -f docker-compose-mysql.yml down`

## PostgreSQL:

1. В application.properties использовать:

   `spring.datasource.url=jdbc:postgresql://localhost:5432/app`

2. Поднять контейнеры MySQL, Node.js через команду в терминале:

   `docker-compose -f docker-compose-postgresql.yml up`

3. Запустить jar файл через команду в терминале:

   `java -jar ./artifacts/aqa-shop.jar`

4. Запустить автотесты используя зеленый треугольник в IDEA либо через команду в терминале:

   `gradlew test`

6. Остановить контейнеры через команду в терминале:

   `docker-compose -f docker-compose-posgresql.yml down`
