### Небольшой сервис для шифрования/дешифрования данных при помощи jasypt

После запуска приложения будет доступен сваггер по адресу - http://localhost:8080/swagger-ui/index.html
Будут доступны два эндпоинта по кодированию/декодированию данных.
Каждый из них предоставляет возможность массово работать с данными и принимает коллекции строк.
* При шифровании коллекции строк ответ будет возращен в виде мапы с данными отсортированными по ключам
* При дешифровке коллекции строк ответ будет возращен в виде мапы с данными отсортированными по значениям