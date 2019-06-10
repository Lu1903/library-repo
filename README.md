Building 

To build the app use following command: mvn clean package

Running 

After building the dashboard run following command to start it: java -jar target/library-0.0.1.jar
You can choose your file by adding --books.path=nameofjson.json at the end, but if you don't specify it, app will look for books.json in target folder. For example: "java -jar target/library-0.0.1.jar --books.path=newBooks.json" will look for newBooks.json in target folder and java -jar target/library-0.0.1.jar will look for books.json.

Access 

After running app is available at the url: http://localhost:8080
Here you can see all the books.

Book by ISBN:

Run url: http://localhost:8080/isbn/{isbn} where {isbn} is isbn number.

Book by categories:

Run url: http://localhost:8080/category/{category} where {isbn} is category.

Author's rating:

Run url: http://localhost:8080/authorsRating to see calculated author's rating.
