Para visualizar correctamente el funcionamiento, se sugiere crear una base de datos con el siguiente script:

``` sql
CREATE DATABASE `autenticacion` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `contrasena` (
  `contrasena` varchar(200) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
