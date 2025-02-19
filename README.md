
# Herramienta de Ubicaciones con Java y Microsoft Access

*Este pequeño proyecto es una aplicación en Java que permite gestionar países, departamentos y ciudades almacenados en una base de datos de Microsoft Access. Se conecta a la base de datos utilizando la librería UCanAccess y permite visualizar los datos en una interfaz gráfica*

## 🚀 Características

- Conexión a una base de datos Access (.accdb).

- Carga y visualización de países, departamentos y ciudades en JComboBox.

- Organización de datos con relaciones entre tablas.

- Uso de consultas SQL para recuperar la información.

## 🛠️ Tecnologías utilizadas

- Java (Swing para la interfaz gráfica)

- Microsoft Access (Base de datos local)

- UCanAccess (Driver JDBC para Access)

## 📂 Estructura del Proyecto
```
📦 GeoSelector
 ┣ 📂 src
 ┃ ┣ 📂 controller
 ┃ ┃ ┗ 📜 LocationController.java
 ┃ ┣ 📂 model
 ┃ ┃ ┣ 📜 Country.java
 ┃ ┃ ┣ 📜 Department.java
 ┃ ┃ ┣ 📜 City.java
 ┃ ┃ ┗ 📜 GeoService.java 
 ┃ ┣ 📂 database
 ┃ ┃ ┗ 📜 DatabaseConnection.java
 ┃ ┣ 📂 main
 ┃ ┃ ┗ 📜 Main.java
 ┃ ┗ 📂 view
 ┃ ┃ ┗ 📂 gui
 ┃ ┃ ┃ ┗ 📜 UI.java
 ┃ ┃ ┗ 📂 listeners
 ┃ ┃   ┗ 📜 LocationListener.java
 ┣ 📂 resources
 ┃ ┗ 📜 DataBase.accdb
```
# 🔧 Configuración y Uso

## 1️⃣ Clonar el repositorio

- git clone https://github.com/monxvoll/GeoSelector.git

## 2️⃣ Agregar la base de datos

- Coloca el archivo DataBase.accdb dentro de la carpeta resources.

## 3️⃣ Configurar la conexión

- En DatabaseConnection.java, asegurarse de que la ruta a la base de datos es correcta:

  String url = "jdbc:ucanaccess://C:/ruta/al/proyecto/resources/DataBase.accdb";

## 4️⃣ Ejecutar el programa
 
- Ejecutar la clase Main.java para iniciar la aplicación.


