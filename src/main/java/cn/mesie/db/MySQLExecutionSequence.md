# Mysql 执行顺序

```
执行顺序
(1) from 
(3) join 
(2) on 
(4) where 
(5) group by(开始使用select中的别名，后面的语句中都可以使用)
(6) avg,sum.... 
(7) having 
(8) select 
(9) distinct 
(10) order by 
```
从这个顺序中我们不难发现，所有的 查询语句都是从from开始执行的，在执行过程中，每个步骤都会为下一个步骤生成一个虚拟表，这个虚拟表将作为下一个执行步骤的输入。

如下SQL语句：
```
select 考生姓名, max(总成绩) as max总成绩 
 
from tb_Grade 
 
where 考生姓名 is not null 
 
group by 考生姓名 
 
having max(总成绩) > 600 
 
order by max总成绩 
```
在上面的示例中 SQL 语句的执行顺序如下: 

    (1). 首先执行 FROM 子句, 从 tb_Grade 表组装数据源的数据 
    (2). 执行 WHERE 子句, 筛选 tb_Grade 表中所有数据不为 NULL 的数据 
    (3). 执行 GROUP BY 子句, 把 tb_Grade 表按 "学生姓名" 列进行分组
    (4). 计算 max() 聚集函数, 按 "总成绩" 求出总成绩中最大的一些数值 
    (5). 执行 HAVING 子句, 筛选课程的总成绩大于 600 分的. 
    (6). 执行 ORDER BY 子句, 把最后的结果按 "Max 成绩" 进行排序. 
