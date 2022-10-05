#mysql service
FROM mysql
ENV MYSQL_ROOT_PASSWORD=admin
ENV MYSQL_DATABASE=temperature
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=admin
COPY ../mysql_db/init.sql /docker-entrypoint-initdb.d/
EXPOSE 3306