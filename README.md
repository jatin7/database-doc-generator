# database-doc-generator

Database Document Generator

- This tool generates database documentation based on the given link. If you think powerdesigner is too heavy, then you can try this tool.
- You can download the [release package](https://github.com/enilu/database-doc-generator/releases/tag/1.0) or download the source code to use.
- If you use the source code, you need to clone the project, run mvn package, and then run bin / start.bat in the release report.
- After running the program, enter the corresponding database parameters as prompted:

```bash
choose database:
1:mysql
2:oracle
3:PostgreSQL
Select the appropriate numbers choose database type
(Enter 'c' to cancel): 3
input database name:
gunslite
input host:
localhost
input port:
5432
input username:
enilu
input password:
123456

```
-After completing the input, press Enter to generate the database document directory $ {dbname} -doc. The documents in the directory are based on the markdown file:：

![doc](doc.jpg)

- Make sure that after installing gitbook, enter the command line window of the above file directory and run: gitbook serve
```bash
E:\\database-doc-generator-20181006100721\guns-lite-doc>gitbook serve
openssl config failed: error:02001003:system library:fopen:No such process
Live reload server started on port: 35729
Press CTRL+C to quit ...

info: 7 plugins are installed
info: loading plugin "livereload"... OK
info: loading plugin "highlight"... OK
info: loading plugin "search"... OK
info: loading plugin "lunr"... OK
info: loading plugin "sharing"... OK
info: loading plugin "fontsettings"... OK
info: loading plugin "theme-default"... OK
info: found 15 pages
info: found 0 asset files
info: >> generation finished with success in 1.6s !

Starting server ...
Serving book on http://localhost:4000
```
- Visit http: // localhost: 4000 to view database documentation online

![summary](summary.jpg)

![table](table.jpg)