### jpademo2

仅作测试

1. 使用spring boot框架来测试hibernate关联关系映射, 在表不加外键约束的情况下, 仅在程序内作关联, 也可以正常使用, 当然注解时候如果你的外键字段不是像country_id这样子规范的, 请添加`@JoinColumn`.
2. 使用hql查询返回自定义bean更加方便, 只需要在bean里面定义构造方法, 在查询语句中new出来就可以了...纯hibernate框架需要addScalar(), spring-data-jpa需要setResultTransform(); 