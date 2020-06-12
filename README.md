# springboot2-http2
使用springboot2支持http2

##1，创建p12证书
keytool -genkeypair -alias serverkey -keyalg RSA -keysize 2048 -validity 3650 -keystore D:\tmp\pwd\p12demo1123456.keystore

keytool -importkeystore -srckeystore D:\tmp\pwd\p12demo1123456.keystore -destkeystore D:\tmp\pwd\p12demo1123456.p12 -srcalias serverkey -destalias serverkey -srcstoretype jks -deststoretype pkcs12 -noprompt

###2，然后把生成的p12文件拷入工程中，并启动工程

###3，本工程启动之后，可以通过如下两个链接访问
https://localhost:8443/http/info   （该链接使用http2）
http://localhost:8080/http/info    （该链接使用http1.1）
