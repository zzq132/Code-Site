# 开始

## 编写一个简单的C++程序

### 编译、运行程序

- 使用`g++ -o prog1 prog1.cpp`编译C++文件

    - 其中`-o prog1`指定了生成的可执行文件的文件名为prog1，若是省略此参数则默认生成一个名为a.exe的可执行文件

### 初识输入输出

输入输出标准库iostream包含了两个基础类型，istream和ostream，分别表示输入流和输出流

```C++
#include <iostream>
using namespace std;
int main(){
  cout <<"Enter two numbers:"<< endl;
  int v1=0,v2=0;
  cin >>v1 >>v2;
  cout <<"The sum of "<<v1 <and "<<v2<<"is"<<vl +v2 <<endl;
  return 0;
}
```

- 标准输入输出对象

    - `cin`为istream类型对象，为标准输入；`cout`为ostream类型对象，为标准输出

- 向流写入数据

    - 输出运算符`<<`：输出运算符左侧为ostream对象cout，右侧为要打印的值，此运算符将给定的值写到ostream对象中。运算符返回的结果为左侧ostream对象cout，所以可以连续使用<<

    - `endl`：效果是结束当前行

- 从流读取数据

    - 输入运算符`>>`：输入运算符左侧为istream对象，右侧为接收输入的运算对象，此运算符从istream读取数据并存入给定的对象中。运算符返回结果为左侧istream对象cin

- 使用标准库中的名字

    - `std::`前缀指出名字cout, endl等是定义在名为std的命名空间中的。命名空间帮助我们避免自定义的名字与标准库中的名字同名而发生冲突，标准库定义的所有名字都在命名空间std中

    - `::`为作用域运算符，指出我们想使用定义在std中的名字