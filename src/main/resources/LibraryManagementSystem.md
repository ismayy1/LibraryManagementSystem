# Library Management System

## Tasks

### 1. Save a Book

- **Method**: `POST`
- **Return: message**
- **Endpoint**:  
  `http://localhost:8080/book`

### 2. Get All Books

- **Method**: `GET`
- **Return: all books**
- **Endpoint**:  
  `http://localhost:8080/book`

### 3. Get a Book by its ID

- **Method**: `GET`
- **Return: found book**
- **Endpoint**:  
  `http://localhost:8080/book/2`

### 4. Delete a Book by its ID

- **Method**: `DELETE`
- **Return: message**
- **Endpoint**:  
  `http://localhost:8080/book/2`

### 5. Get a Book by its ID with RequestParam

- **Method**: `GET`
- **Return: found book**
- **Endpoint**:  
  `http://localhost:8080/book/q=id=2`

### 6. Get a Book by its Title with RequestParam

- **Method**: `GET`
- **Return: found book**
- **Endpoint**:  
  `http://localhost:8080/book/search?title=Atomic Habits`

### 7. Get Books With Pagination

- **Method**: `GET`
- **Return: books with pages**
- **Endpoint**:  
  `http://localhost:8080/book/s?page=1&size=2&sort=publicationDate&direction=ASC`

### 8. Update a Book Using DTOs

- **Method**: `PUT`
- **Return: a message**
- **Endpoint**:  
  `http://localhost:8080/book/update/2`

### 9. Get a Book By Its Author Using JPQL

- **Method**: `GET`
- **Return: found book**
- **Endpoint**:  
  `http://localhost:8080/book/a?author=AB`