# API Spec

## Create Product
Request :
- Methode : POST
- Endpoint : '/api/products'
- Header :
    - Contect-Type : application/json
    - Accept : aplication/json
- Body :
```json
{
  "id" : "string, unique", 
  "name" : "string", 
  "price" : "long", 
  "quantity" : "integer"
}
```
Response :
```json
{
  "code" : "number", 
  "status" : "string", 
  "data" : {
    "id" : "string, unique",
    "name" : "string",
    "price" : "long",
    "quantity" : "integer", 
    "createdAt" : "date", 
    "updateAt" : "date"
  }
}
```

## Get Product
Request :
- Methode : GET
- Endpoint : '/api/products/{id_product}'
- Header :
    - Accept : aplication/json
- Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : {
    "id" : "string, unique",
    "name" : "string",
    "price" : "long",
    "quantity" : "integer",
    "createdAt" : "date",
    "updateAt" : "date"
  }
}
```
## Update Product
Request :
- Methode : PUT
- Endpoint : '/api/products/{id_product}'
- Header :
    - Contect-Type : application/json
    - Accept : aplication/json
- Body :
```json
{
  "id" : "string, unique", 
  "name" : "string", 
  "price" : "long", 
  "quantity" : "integer"
}
```
Response :
```json
{
  "code" : "number", 
  "status" : "string", 
  "data" : {
    "id" : "string, unique",
    "name" : "string",
    "price" : "long",
    "quantity" : "integer", 
    "createdAt" : "date", 
    "updateAt" : "date"
  }
}
```

## List Product
Request :
- Methode : GET
- Endpoint : '/api/products'
- Header :
    - Accept : aplication/json
- Query Param :
    - size : number,
    - page : number
- Response :
```json
{
  "code" : "number",
  "status" : "string",
  "data" : [
    {
      "id" : "string, unique",
      "name" : "string",
      "price" : "long",
      "quantity" : "integer",
      "createdAt" : "date",
      "updateAt" : "date"
    },
    {
      "id" : "string, unique",
      "name" : "string",
      "price" : "long",
      "quantity" : "integer",
      "createdAt" : "date",
      "updateAt" : "date"
    }
  ]
}
```

## Delete Product
Request :
- Methode : DELETE
- Endpoint : '/api/products/{id_product}'
- Header :
    - Accept : aplication/json
- Response :
```json
{
  "code" : "number",
  "status" : "string"
}
```