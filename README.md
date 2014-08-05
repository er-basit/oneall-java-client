# OneAll Java Client

This tiny library allows you to easily integrate the server-side of your java website with [OneAll](https://oneall.com)
social login service.

## Installation

Add these lines to your pom.xml:

```xml
    <repositories>
        <repository>
            <id>triptomap-public</id>
            <url>http://maven.triptomap.com</url>
        </repository>
    </repositories>
```

```xml
        <dependency>
            <groupId>com.triptomap.libs</groupId>
            <artifactId>oneall-client</artifactId>
            <version>1.0</version>
        </dependency>
```

Now you can create the servlet, which will act as a [callback script](http://docs.oneall.com/services/implementation-guide/social-login/).
To verify the user, you need to do the following:

```java
    private User getUser(HttpServletRequest request) throws IOException {
        try {
            OneAll client = new OneAll(publicKey, privateKey, domain);
            return client.getUser(request.getParameter("connection_token")));
        } catch (Exception e) {
            throw new RuntimeException("Failed to authenticate user", e);
        }
    }
```
