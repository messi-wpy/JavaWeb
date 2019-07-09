### 登录
http://localhost:8080/login
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
http://106.14.199.222:8080/login?action=registed

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
### 按类别查找商品
### 某个商品具体信息
### 添加商品
### 修改商品
### 返回地址
### 生成购物车