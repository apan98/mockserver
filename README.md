#Mock Server
## Rest API:
POST: `/api/json`
method for save json on database
```
{
  // "id": 34 // optional id for update
  "jsonIn": {
    // any json
  },
  "jsonOut": {
    // any json
  }
}
```
example: 
---
```json
{
  "jsonIn": {
    "creditId": 1,
    "status": {
      "id": 1,
      "code": "ACTIVE"
    }
  },
  "jsonOut": {
    "amount": 54575.00,
    "residue": 454.00
  }
}
```

GET: `api/`
Request:
---
```json
{
  "creditId": 1,
  "status": {
    "id": 1,
    "code": "ACTIVE"
  }
}
```

Response:
---
```json
{
  "amount": 54575.0,
  "residue": 454.0
}
```
#Other api
1) GET: `/api/json`
Get all key-value json from database

2) DELETE: `api/json/{id}`
simple delete json from database