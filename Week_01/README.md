学习笔记

1.作业1-用 add first 或 add last 这套新的 API 改写 Deque 的代码
修改的代码
Deque<String> deque = new LinkedList<>();

deque.addFirst("a");
deque.addFirst("b");
deque.addFirst("c");
System.out.println(deque);

String str = deque.peekFirst();
System.out.println(str);
System.out.println(deque);

while (deque.size() > 0) {
     System.out.println(deque.removeFirst());
}

System.out.println(deque);

学习总结
（1）学习了快速计算时间复杂度和空间复杂度的方法
       1）时间复杂度：通过查看当前算法的执行次数与数组长度n或递归深度n的表达式
       2）空间复杂度：通过查看数组长度或递归深度是多少来计算，其中参数中的数组长度忽略计算，这里指的是额外申请的空间
（2）学习了数组，链表，跳表，栈，队列，优先队列，双端队列这些数据结构
       1）数组：一组连续的地址空间，访问速度快(O(1))，插入删除操作慢(O(n))
       2）链表：一个个结点由其next指针相联系，访问速度慢（O(n)）,插入删除操作快（O(n)）
       3）跳表：在链表上添加索引，大大加快了链表元素访问速度（O(log n)）
       4）栈：先进后出的数据结构，添加取出操作时间复杂度为O(1)
       5）队列：先进先出的数据结构，添加取出操作时间复杂度为O(1)
       6）双端队列：一个队列结构，两头均能插入，取出元素
       7）优先队列：根据元素优先级取出元素，减慢了取出速度（O(log n)）
（3）学习了如何去查询API
       1）google搜索相应的类或方法 后面加变成语言便有文档了
（4）做题过程中积累了双指针的解题思想
（5）其中不足之处或着说是遇到的困难是对于具体数据结构还不够了解，导致有些逻辑难以很快消化。