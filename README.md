# doorlock-api
Doorlock integration API
Hardware provider
- DOWS
- TESA
# Dows REST API
## Connect

Type | GET
--- | ---
URL | /dows/connect
Req Body | None
Resp Body | {"status": 0}

## Disconnect

Type | GET
--- | ---
URL | /dows/disconnect
Req Body | None
Resp Body | {"status": 0}

## Check Card

Type | GET
--- | ---
URL | /dows/card/check
Req Body | None
Resp Body | {"cardType": 2}

## Verify Card

Type | GET
--- | ---
URL | /dows/card/verify
Req Body | None
Resp Body | {"cardType": 2}

## Get Authorization Code

Type | GET
--- | ---
URL | /dows/auth
Req Body | None
Resp Body | {"auth": "123456"}

## Get Card Number

Type | GET
--- | ---
URL | /dows/card/number
Req Body | None
Resp Body | {"cardNumber": "123456"}

## Read Card

Type | GET
--- | ---
URL | /dows/card
Req Body | None

- Resp Body
```json 
{
  "status": 0,
  "cardNo": "751729",
  "building": "01",
  "room": "0101",
  "door": "00",
  "arrival": "2020-04-29 13:00:00",
  "departure": "2020-04-30 14:00:00"
}
```

## Write Card

Type | POST
--- | ---
URL | /dows/card
Resp Body | {"status":0}

- Body Request
```json
{
  "building": "01",
  "room": "0101",
  "door": "00",
  "arrival": "2020-04-29 13:00:00",
  "departure": "2020-04-30 14:00:00"
}
```

## Delete Card
Type | DELETE
--- | ---
URL | /dows/card/{room}
Resp Body | {"status":0}
