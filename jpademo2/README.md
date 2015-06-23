### jpademo2

仅作测试

1. 使用spring boot框架来测试hibernate关联关系映射, 在表不加外键约束的情况下, 仅在程序内作关联, 也可以正常使用, 当然注解时候如果你的外键字段不是像country_id这样子规范的, 请添加`@JoinColumn`.
2. 使用hql查询返回自定义bean更加方便, 只需要在bean里面定义构造方法, 在查询语句中new出来就可以了...纯hibernate框架需要addScalar(), spring-data-jpa需要setResultTransform(), 而且spring-data-jpa的太霸道, 
他说出来的是什么格式就得是什么格式, 然后我只好妥协用了BigInteger.
3. 可以返回list, map等对象
4. `com.vicitf.springdatajpa.repository.PersonDaoTest.findCountryBeanTest()`方法查出来结果打印之后为什么要报一个EntityManagerFactory is closed错误呢,
使用spring-data-jpa也报同样错误, 删掉SessionFactory那个bean就好了...
5. hql可以直接把一个实体当查询参数.
6. select * 不行
7. having count() > ?1, 这里的参数必须是Long型