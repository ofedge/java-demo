### mongodb

框架spring-data-mongodb

虽然是nosql, 但还是要了映射类, 不爽的是如果新增加了一个属性, 不更改映射类是显示出不来的, 而且每次通过框架添加的记录都会带一个_class, 看着不舒服.

update和remove方法都会返回WriteResult对象, 但是insert却没有? save也没有? 命令行添加还有呢... 