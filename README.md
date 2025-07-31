
### Описание

Архитектура микросервисов:

- `user-service` — сервис пользователей
- `order-service` — сервис заказов
- `bff-service` — агрегирует данные из `user-service` и `order-service`

---

### Запуск

Запустить **три сервиса**:

1. `user-service` — порт `8080`
2. `order-service` — порт `8081`
3. `bff-service` — порт `8082`

### Примеры запросов

GET http://localhost:8082/api/site-bff/user/1
GET http://localhost:8082/api/site-bff/user/2