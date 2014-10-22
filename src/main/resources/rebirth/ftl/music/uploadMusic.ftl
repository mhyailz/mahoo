<!doctype html>
<html lang="en-us">
    <body>
        <form action="/music/upload" method="post">
            <p>
                <label>标题：</label>
                <input name="musicName" type="text" />
            </p>
            <p>
                <label>文件路径：</label>
                <input name="musicUrl" type="file" multiple="multiple" />
            </p>
            <input type="submit" />
        </form>

    </body>
</html>