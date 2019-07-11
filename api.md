### 登录
http://106.14.199.222:8080/login    post
request：
```json
{
"account":1,
"password":"EmmaPassword"

}

```
response:
```json
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
```json
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
```json
{
    "code": 200,
    "msg": "注册成功!"
}
```

### 展示所有商品
http://106.14.199.222:8080/ProductServlet?action=showAll  get
response:
```json
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
```json
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
```json
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

### 删除商品
http://106.14.199.222:8080/ProductServlet?action=delete&ID=  get
- request:ID  商品id

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
### 添加地址
http://106.14.199.222:8080/Receiver
- POST
- request:
```json
 {
            "name": "messi",
            "province": "HuBei",
            "city": "WuHan",
            "country": "HongShan",
            "address": "CCNU LuoYu Road",
            "phone": "17362995006",
            "postcode": "430000",
            "street": "LuoNan",
            "userId": 10
   }

```

### 返回地址
http://106.14.199.222:8080/Receiver?userId=10  
- GET
- request；userId
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
    "id":23,
    "productId":2,
    "userId":3,
    "number":12
}
```
### 删除购物车商品

http://106.14.199.222:8080/shop?action=delete&pId=1&uId=2

### 添加订单:
http://106.14.199.222:8080/order   
- post
- request:
```json
{
   "productId":[2,3,3,4],
   "nums":[2,1,2,1],
   "sumPrice":24.5,
   "userId":2000,
   "addressId":2, 
   "orderId":2
}
```
### 获取所有订单:
http://106.14.199.222:8080/order   
- get
- response:
```json
[
    {
        "receiver": {
            "id": 1,
            "name": "刘德华",
            "province": "湖北",
            "city": "武汉",
            "country": "中国",
            "address": "华中师范大学",
            "phone": "17362992000",
            "postcode": "430000",
            "street": "珞南街道",
            "userId": 2000
        },
        "products": [
            {
                "id": 1,
                "name": "千味岛早餐面包",
                "categoryid": 4,
                "num": 1224,
                "price": 39.9,
                "desc": "营养软长崎蛋糕原味手工纯蛋糕小面包整箱零食960g",
                "imagUrl": "https://img.alicdn.com/imgextra/i2/2200561834814/O1CN01pBrnIm1lQrC2W6piS_!!2200561834814.jpg_430x430q90.jpg"
            },
            {
                "id": 1,
                "name": "千味岛早餐面包",
                "categoryid": 4,
                "num": 1224,
                "price": 39.9,
                "desc": "营养软长崎蛋糕原味手工纯蛋糕小面包整箱零食960g",
                "imagUrl": "https://img.alicdn.com/imgextra/i2/2200561834814/O1CN01pBrnIm1lQrC2W6piS_!!2200561834814.jpg_430x430q90.jpg"
            },
            {
                "id": 2,
                "name": "学生坐垫",
                "categoryid": 4,
                "num": 735,
                "price": 27.8,
                "desc": "卡通记忆棉坐垫学生教室椅子凳子垫子可爱宿舍椅垫夏季防滑屁股垫 ",
                "imagUrl": "https://img.alicdn.com/imgextra/i2/487740454/TB2GU_adOgSXeFjy0FcXXahAXXa_!!487740454.jpg_430x430q90.jpg"
            }
        ],
        "user": {
            "id": 2000,
            "name": "刘德华",
            "passwordhash": "123456",
            "question": "我的名字是什么",
            "answer": "刘德华",
            "sex": true,
            "birth": "1999-02-05",
            "phone": "17362992000",
            "mail": "2000@qq.com"
        },
        "sum": 23
    }
]
```

### 更新购物车
http://106.14.199.222:8080/shop?action=update
```json
{
	"productId":2,
	"userId":3,
	"number":12

}
```
