### 登录
http://localhost:8080/login    post
request：
```
{
"account":1,
"password":"EmmaPassword"

}

```
response:
```
{
    "code": 200,
    "msg": "登录成功",
    "body": {
        "id": 1,
        "name": "Emma",
        "passwordhash": "EmmaPassword",
        "question": "What is you name?",
        "answer": "Emma",
        "sex": false,
        "birth": "2000-07-02",
        "phone": "17362995000",
        "mail": "17362995000@qq.com"
    }
}
```
### 注册
http://106.14.199.222:8080/login?action=registed    post

request：
```
{
    "id": 111,
    "name": "王鹏宇",
    "passwordhash": "123456",
    "question": "What is you name?",
    "answer": "messi",
    "sex": true,
    "birth": "2000-1-2",
    "phone": "17362995000",
    "mail": "17362995000@qq.com"
}
```
Response：
```
{
    "code": 200,
    "msg": "注册成功!"
}
```

### 展示所有商品
http://106.14.199.222:8080/ProductServlet?action=showAll  get
response:
```
[
    {
        "id": 1,
        "name": "NONGFU SPRING",
        "categoryid": 1,
        "num": 1,
        "price": 2,
        "desc": "asdasdasd",
        "imagUrl": "sadsad"
    },
    {
        "id": 3,
        "name": "BRICK TEA",
        "categoryid": 1,
        "num": 1000,
        "price": 3,
        "desc": "asdasdasd",
        "imagUrl": "sadsad"
    },
    {
        "id": 4,
        "name": "MILK",
        "categoryid": 1,
        "num": 5000,
        "price": 4,
        "desc": "asdasdasd",
        "imagUrl": "sadsad"
    }
]

```
### 按类别查找商品
http://106.14.199.222:8080/product?categoryId=1  get
response
```
[
    {
        "id": 1,
        "name": "NONGFU SPRING",
        "categoryid": 1,
        "num": 1,
        "price": 2,
        "desc": "asdasdasd",
        "imagUrl": "sadsad"
    },
    {
        "id": 3,
        "name": "BRICK TEA",
        "categoryid": 1,
        "num": 1000,
        "price": 3,
        "desc": "asdasdasd",
        "imagUrl": "sadsad"
    },
    {
        "id": 4,
        "name": "MILK",
        "categoryid": 1,
        "num": 5000,
        "price": 4,
        "desc": "asdasdasd",
        "imagUrl": "sadsad"
    }
]

```
### 某个商品具体信息
http://106.14.199.222:8080/ProductServlet?action=seek&ID=5   get
action=seek   ID=
response:
```
{
    "id": 5,
    "name": "SODA",
    "categoryid": 1,
    "num": 10000,
    "price": 2.5,
    "desc": "asdasdasd",
    "imagUrl": "sadsad"
}
```
### 添加商品
http://106.14.199.222:8080/ProductServlet?action=insert post
request:
```
 {
        "id": 19,
        "name": "华为p10",
        "categoryid": 2,
        "num": 10,
        "price": 2000,
         "desc": "asdasdasd",
                "imagUrl": "sadsad"
 }
```
response:
```json
"增加商品成功！"
```

### 修改商品
http://106.14.199.222:8080/ProductServlet?action=update  get
request:
```json
{
        "id": 11,
        "name": "华为p10",
        "categoryid": 2,
        "num": 10,
        "price": 3000,
        "desc": "asdasdasd",
        "imagUrl": "sadsad"
    }
```
response:
```json
"更新商品成功！"
```
### 返回地址
http://106.14.199.222:8080/getReceiver?userId=10
request；userId
```json
{
    "code": 0,
    "msg": "查找成功",
    "body": [
        {
            "id": 3,
            "name": "messi",
            "province": "HuBei",
            "city": "WuHan",
            "country": "HongShan",
            "address": "CCNU LuoYu Road",
            "phone": "17362995006",
            "postcode": "430000",
            "street": "LuoNan",
            "userId": 10
        },
        {
            "id": 8,
            "name": "Joyce",
            "province": "HuBei",
            "city": "WuHan",
            "country": "HongShan",
            "address": "CCNU LuoYu Road",
            "phone": "17362995005",
            "postcode": "430000",
            "street": "LuoNan",
            "userId": 10
        }
    ]
}
```
### 生成购物车
http://106.14.199.222:8080/shop?action=getShopCar&userId=1
request userId

response:
```json
{
    "code": 200,
    "msg": "查找成功",
    "body": [
        {
            "id": 4,
            "name": "MILK",
            "categoryid": 1,
            "num": 100,
            "price": 0
        },
        {
            "id": 8,
            "name": "BEER",
            "categoryid": 1,
            "num": 100,
            "price": 0
        },
        {
            "id": 1,
            "name": "NONGFU SPRING",
            "categoryid": 1,
            "num": 2,
            "price": 0,
            "desc": "asdasdasd",
            "imagUrl": "sadsad"
        }
    ]
}
```
### 添加到购物车
http://106.14.199.222:8080/shop?action=add
```json
{
	"id"=23,(随便给一个id)
	"productId"=2,
	"userId"=3,
	"number"=12
	

}
```
### 删除商品


