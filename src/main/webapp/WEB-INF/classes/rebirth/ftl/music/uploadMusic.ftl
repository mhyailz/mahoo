<!doctype html>
<html lang="en-us">
    <body>
        <form action="/music/upload" method="post">
            <p>
                <label>类型：</label>
                <input name="musicType" type="text" />
            </p>
            <p>
                <label>文件路径：</label>
                <input name="names" type="file" multiple="multiple" />
            </p>
            <input type="submit" />
        </form>

    </body>
</html>