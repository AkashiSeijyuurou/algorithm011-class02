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
（2）学习了数组，链表，跳表，栈，队列，优先队列，双端队列这些数据结构
（3）学习了如何去查询API
（4）做题过程中积累了双指针的解题思想
（5）其中不足之处是对于具体数据结构还不够了解，导致有些逻辑难以很快消化。