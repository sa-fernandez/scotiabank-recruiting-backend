# Scotiabank Backend Test
Results for the Backend Software Engineer Associate Test. 

## Previous steps

You need to set the path and credentials of the MySQL database used for the application to run properly. 

This information can be found in the file:

```sh
application.properties
```

The model and test data can be found in the folder:

```sh
/data
```

## Run the App

The server runs with the following command: 

```sh
.\mvnw spring-boot:run
```

This generates a server that can be accessed with the following URL:

```sh
http://localhost:8080
```

## Endpoints
| Request Type | Endpoints | Body | Params |
| ------ | ------ | ------ | ------ |
| POST | `/api/city/` | `{ "name": "New City" }` |  |
| GET | `/api/city/{id}` |  | `id` |
| GET | `/api/city/cities` |  |  |
| PUT | `/api/city/{id}` | `{ "name": "New City Name" }` | `id` |
| DELETE | `/api/city/{id}` |  | `id` |
| POST | `/api/position/` | `{ "title": "New Position", "salary": 100 }` |  |
| GET | `/api/position/{id}` |  | `id` |
| GET | `/api/position/positions` |  |  |
| PUT | `/api/position/{id}` | `{ "title": "New Position Title", "salary": 200 }` | `id` |
| DELETE | `/api/position/{id}` |  | `id` |
| POST | `/api/employee/` | `{ "firstName": "Kiryu", "middleName": "John", "lastName": "Kazuma", "address": "Carrera 77C # 7 - 7", "dateBirth": "17-06-1968", "hireDate": "02-11-2024", "email": "kiryu.kazuma@gmail.com", "telephone": "+573214658999", "status": "ACTIVE", "idCity": 1, "idPosition": 1 }` |  |
| GET | `/api/employee/{id}` |  | `id` |
| GET | `/api/employee/employees` |  |  |
| PUT | `/api/employee/{id}` | `{ "firstName": "Goro", "middleName": "Pedro", "lastName": "Majima", "address": "Carrera 77C # 7 - 7", "dateBirth": "14-05-1964", "hireDate": "02-11-2024", "email": "goro.majima@gmail.com", "telephone": "+573214658997", "status": "ACTIVE", "idCity": 1, "idPosition": 1 }` | `id` |
| DELETE | `/api/employee/{id}` |  | `id` |
| GET | `/api/employee/details/{id}` |  | `id` |
| GET | `/api/employee/view` |  |  |