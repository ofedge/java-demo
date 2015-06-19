### jpademo

用来监测MySQL数据库中除了test, mysql, information_schema之外所有数据库表的记录总数变化

1. 第一步, 调用`com.vicitf.springdatajpa.service.SchemaTablesServiceTest.fillTabelsTest()`方法, 把初始时候所有要监测的表放进t\_schema\_tables中.
2. 第二步, 调用`com.vicitf.springdatajpa.service.TableChangesServiceTest.fillTableChangesTest()`方法, 把初始时候所有表的总记录数放进t\_table\_changes中, change\_id为0代表初始值.

之后每次数据库发生过修改, 就调用`com.vicitf.springdatajpa.service.ChangesServiceTest.newChangesTestN()`, 改变内容自己改, 调用完成后记录更改过之后表行数保存到t\_table\_changes中, 查看t_changes表更改前后的两个id, 放在com.vicitf.springdatajpa.service.QueryServiceTest.getChangedTablesTest()中, 运行就可以得到记录总数发生变化的表以及变化的记录数.